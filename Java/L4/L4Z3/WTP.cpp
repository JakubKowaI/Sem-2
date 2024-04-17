#include <iostream>
#include "WTP.hpp"

using namespace std;

//int wiersz[0];

 int WTP::silnia(int n){
        int iloczyn=1;
        for(int i=1;i<=n;i++){
            iloczyn*=i;
        }
        return iloczyn;
    }



WTP::WTP(int n){
    wiersz = new int[n+1];
        wiersz[0] = 1;
        for (int i = 1; i <= n; i++) {
            wiersz[i]=silnia(n)/(silnia(i)*silnia(n-i));
        }
}

    int WTP::liczba(int m){
    return wiersz[m];
}

WTP::~WTP(){
    //cout<<"Destruktor"<<endl;
}