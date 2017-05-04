#-*-coding:utf-8-*--
from sklearn.datasets import load_digits
digits = load_digits()

#�ָ�ԭʼ����Ϊѵ�����ݺͲ�������
from sklearn.cross_validation import train_test_split
x_train, x_test, y_train, y_test = train_test_split(digits.data, digits.target,test_size=0.25, random_state=33)

#����Ԥ����ò��û�еĻ����Ȼ��½�
from sklearn.preprocessing import StandardScaler
ss = StandardScaler()
x_train = ss.fit_transform(x_train)
x_test = ss.transform(x_test)

#svm���з���
from sklearn.svm import LinearSVC
lsvc = LinearSVC()
lsvc.fit(x_train, y_train)
y_predict = lsvc.predict(x_test)

#����ɼ�
print lsvc.score(x_test,y_test)
from sklearn.metrics import classification_report
print classification_report(y_test, y_predict, target_names=digits.target_names.astype(str))