#include<iostream>
#include<vector>
#include "LiczbyPierwsze.hpp"

using namespace std;

bool pierwsza(int k)
{
    if(k<2)return false;
    for(int i=2;i<k;i++)
    {
        if(k%i==0)return false;
    }
    return true;
}

LiczbyPierwsze::LiczbyPierwsze(int n){
    for(int i=2;i<=n;i++)
    {
        if(pierwsza(i)){
            
        this->pierwsze.push_back(i);
        }
    }
    
}

LiczbyPierwsze::~LiczbyPierwsze()
{
    cout<<"Destruktor\n";
}



int LiczbyPierwsze::liczba(int m)
{     
    return pierwsze[m];
}

