double jiechen(double t){
if(t==1||t==0)  return 1;
else            return t*jiechen(t-1);
}

//正整数求阶乘。 double型