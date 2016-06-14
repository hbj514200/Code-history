
long long gcd(long long m, long long n){
    return n? gcd(n,m%n) : m;
}
