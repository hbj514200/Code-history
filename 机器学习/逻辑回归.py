# -*-coding:gbk-*-
import pandas as pd
import numpy as np
column_names = ['Sample code number',                           #CSV�ļ��ĵ����б�ͷ����˵��
                'Clump Thickness',
                'Uniformity of Cell Size',
                'Uniformity of Cell Shape',
                'Marginal Adhesion',
                'Single Epithelial Cell Size',
                'Bare Nuclei',
                'Bland Chromatin',
                'Normal Nucleoli',
                'Mitoses',
                'Class'
                ]
data = pd.read_csv('d:/breast-cancer-wisconsin.csv')            #��ȡCSV�ļ�
data = data.replace('?', np.nan)                                #�ʺŵĵ�Ԫ���ʾȱʧ���ʺ�תΪnan
data = data.dropna()                                            #nan�ĵ�Ԫ���ʾȱʧ���޳�����

from sklearn.cross_validation import train_test_split
#���Լ���ѵ�����İ������������
x_train, x_test, y_train, y_test = train_test_split(data[column_names[1:10]], data[column_names[10]], test_size=0.25, random_state=33)

from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression
from sklearn.linear_model import SGDClassifier
ss = StandardScaler()       #�����ķ�ʽ����׼
x_train = ss.fit_transform(x_train)
x_test = ss.transform(x_test)
lr = LogisticRegression()
sgdc = SGDClassifier()      #�ݶȹ��Ƶķ�ʽ�����ܱȽϲ���׼�����ܺ�
lr.fit(x_train, y_train)
lr_y_predict = lr.predict(x_test)
sgdc.fit(x_train, y_train)
sgdc_y_predict = sgdc.predict(x_test)

from sklearn.metrics import classification_report                                       #����ɼ�����һ���Ƿ���
print lr.score(x_test,y_test)
print classification_report(y_test, lr_y_predict, target_names=['Bengin','Malignant'])
print sgdc.score(x_test,y_test)
print classification_report(y_test, sgdc_y_predict, target_names=['Bengin','Malignant'])
