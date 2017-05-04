#-*-coding:utf-8-*--
import pandas as pd
titanic = pd.read_csv('d:/titanic.csv')

x = titanic[['pclass', 'age', 'sex']]
y = titanic['survived']                             #������ȡ��CSV����
x['age'].fillna(x['age'].mean(), inplace=True)      #��ȱʧ������ֵ�滻Ϊƽ��ֵ

from sklearn.cross_validation import train_test_split       #���ݷָ�Ϊѵ�����Ͳ��Լ�
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.25, random_state=33)

from sklearn.feature_extraction import DictVectorizer
vec = DictVectorizer(sparse=False)
x_train = vec.fit_transform(x_train.to_dict(orient='record'))
x_test = vec.transform(x_test.to_dict(orient='record'))

from sklearn.tree import DecisionTreeClassifier             #������ѵ��
dtc = DecisionTreeClassifier()
dtc.fit(x_train, y_train)
y_predict = dtc.predict(x_test)

from sklearn.metrics import classification_report           #�������ɼ�����
print dtc.score(x_test, y_test)
print classification_report(y_predict, y_test, target_names=['died', 'survived'])