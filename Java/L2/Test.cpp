#include <iostream>
#include <string>
#include "LiczbyPierwsze.hpp"

using namespace std;

int main() {
    int x=10;
    int tab[]={x,2,3,4,5,6,7,8,9,10};
    
    try{
        if(x<=0){            
            throw "Za maly zakres";
        }        
        
    }catch(string blad){
        cout<<blad<<endl;
        return 0;
    }
    catch(invalid_argument e){
        cout<<"Niepoprawne dane"<<endl;
        return 0;
    }
LiczbyPierwsze liczby(x);
    for(int i=1;i<x;i++){
        try{
            if(tab[i]<0){
                throw "Za mala liczba";
            }
            if(tab[i]>x){
                throw "Za duza liczba";
            }
            cout<<liczby.liczba(tab[i])<<endl;
        }catch(string blad){
            cout<<blad<<endl;
        }
        catch(invalid_argument e)
        {
            cout<<"Niepoprawne dane"<<endl;
        }
    }
    return 0;
}