#include "LiczbyPierwsze.hpp"
#include <iostream>
using namespace std;


    int licznik=0;
    int pierwsze[]{1,2,3,4};
    LiczbyPierwsze::LiczbyPierwsze(int n){
        //int *pierwsz=new int[n];
            for(int i=0;i<=n;i++){
                if(pierwsza(i)){
                    //pierwsz[licznik]=i;
                    licznik++;
                }
            }    
            //memcpy(pierwsze,pierwszel,sizeof(pierwszel));
            //pierwsze=pierwsz;
    }
    LiczbyPierwsze::~LiczbyPierwsze(){
        delete[] pierwsze;
    }
    bool LiczbyPierwsze::pierwsza(int n){
            if(n<2){
                return false;
            }
            for(int i=2;i==n;i++){
                if(n%i==0){
                    return false;
                }
            }
            return true;
        }
    int LiczbyPierwsze::liczba(int m){
            return pierwsze[m];
        } 
