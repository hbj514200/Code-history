# -*- coding:gb2312 -*-
from sklearn.datasets import load_boston
boston = load_boston()
x = boston.data
y = boston.target

from sklearn.cross_validation import train_test_split   #分为测试集和训练集
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.25, random_state=33)

from sklearn.preprocessing import StandardScaler        #数据差值大，进行标准归一化处理
ss_x = StandardScaler()
ss_y = StandardScaler()
x_train = ss_x.fit_transform(x_train)
x_test = ss_x.transform(x_test)
y_train = ss_y.fit_transform(y_train)
y_test = ss_y.transform(y_test)

from sklearn.linear_model import LinearRegression
lr = LinearRegression()
lr.fit(x_train, y_train)
lr_y_predict = lr.predict(x_test)

from sklearn.linear_model import SGDRegressor
sgdr = SGDRegressor()
sgdr.fit(x_train, y_train)
sgdr_y_predict = sgdr.predict(x_test)

#三种评测回归效果的方式，标准差、方差和R-squared
from sklearn.metrics import r2_score, mean_squared_error, mean_absolute_error
print r2_score(y_test, lr_y_predict)
print mean_squared_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(lr_y_predict))
print mean_absolute_error(ss_y.inverse_transform(y_test), ss_y.inverse_transform(lr_y_predict))






