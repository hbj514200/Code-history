
    int tem;
    if(*a<*b)   { tem=*a; *a=*b; *b=tem; }
    if(*a<*c)   { tem=*a; *a=*c; *c=tem; }
    if(*b<*c)   { tem=*c; *c=*b; *b=tem; }
