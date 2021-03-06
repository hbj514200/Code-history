#-*-coding:utf-8-*--
import pandas as pd
titanic = pd.read_csv('d:/titanic.csv')

x = titanic[['pclass', 'age', 'sex']]
y = titanic['survived']                             #单独提取出CSV的列
x['age'].fillna(x['age'].mean(), inplace=True)      #把缺失的年龄值替换为平均值

from sklearn.cross_validation import train_test_split       #数据分割为训练集和测试集
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.25, random_state=33)

from sklearn.feature_extraction import DictVectorizer
vec = DictVectorizer(sparse=False)
x_train = vec.fit_transform(x_train.to_dict(orient='record'))
x_test = vec.transform(x_test.to_dict(orient='record'))

from sklearn.tree import DecisionTreeClassifier             #决策树训练
dtc = DecisionTreeClassifier()
dtc.fit(x_train, y_train)
y_predict = dtc.predict(x_test)

from sklearn.metrics import classification_report           #决策树成绩报告
print dtc.score(x_test, y_test)
print classification_report(y_predict, y_test, target_names=['died', 'survived'])