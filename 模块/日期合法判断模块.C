int riqipanduan(int y, int, m, int d){

if(y<=0)          return 0;
if(m<=0||m>12)    return 0;
if(d<=0)          return 0;

if(m==1||m==3||m==5||m==7||m==8||m==10||m==12)          {  if(d>31) return 0;    }
if(m==4||m==6||m==9||m==11)                             {  if(d>30) return 0;    }

if(runnian(y)==1&&m==2)
if(d>29)    return 0;
if(runnian(y)==0&&m==2)
if(d>28)    return 0;

return 1;
}

//输入3个int值： 年、月、日。  返回1————日期合法。 返回0表示日期不合法。