# -*-coding:gbk-*-
import pandas as pd
import numpy as np
column_names = ['Sample code number',                           #CSV文件的第零行表头数据说明
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
data = pd.read_csv('d:/breast-cancer-wisconsin.csv')            #读取CSV文件
data = data.replace('?', np.nan)                                #问号的单元格表示缺失，问号转为nan
data = data.dropna()                                            #nan的单元格表示缺失，剔除整行

from sklearn.cross_validation import train_test_split
#测试集和训练集的按比例随机划分
x_train, x_test, y_train, y_test = train_test_split(data[column_names[1:10]], data[column_names[10]], test_size=0.25, random_state=33)

from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression
from sklearn.linear_model import SGDClassifier
ss = StandardScaler()       #解析的方式，精准
x_train = ss.fit_transform(x_train)
x_test = ss.transform(x_test)
lr = LogisticRegression()
sgdc = SGDClassifier()      #梯度估计的方式，可能比较不精准，性能好
lr.fit(x_train, y_train)
lr_y_predict = lr.predict(x_test)
sgdc.fit(x_train, y_train)
sgdc_y_predict = sgdc.predict(x_test)

from sklearn.metrics import classification_report                                       #报告成绩，第一行是分数
print lr.score(x_test,y_test)
print classification_report(y_test, lr_y_predict, target_names=['Bengin','Malignant'])
print sgdc.score(x_test,y_test)
print classification_report(y_test, sgdc_y_predict, target_names=['Bengin','Malignant'])
