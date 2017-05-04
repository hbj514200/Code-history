#-*-coding:utf-8-*--
from sklearn.datasets import load_digits
digits = load_digits()

#分割原始数据为训练数据和测试数据
from sklearn.cross_validation import train_test_split
x_train, x_test, y_train, y_test = train_test_split(digits.data, digits.target,test_size=0.25, random_state=33)

#数据预处理，貌似没有的话精度会下降
from sklearn.preprocessing import StandardScaler
ss = StandardScaler()
x_train = ss.fit_transform(x_train)
x_test = ss.transform(x_test)

#svm进行分类
from sklearn.svm import LinearSVC
lsvc = LinearSVC()
lsvc.fit(x_train, y_train)
y_predict = lsvc.predict(x_test)

#报告成绩
print lsvc.score(x_test,y_test)
from sklearn.metrics import classification_report
print classification_report(y_test, y_predict, target_names=digits.target_names.astype(str))