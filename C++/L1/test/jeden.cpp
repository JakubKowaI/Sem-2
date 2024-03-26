#include <iostream>
#include <string>
#include "Klasy.h"

using namespace std;

int main(int argumenty,char *args[]) {
    try{
        if(argumenty<=0){            
            throw "Za malo argumentow";
        }
        if(stoi(args[0])<1){
            throw "Za mala liczba";
        }
        if(stoi(args[0])>1000){
            throw "Za duza liczba";
        }
    }catch(string blad){
        cout<<blad<<endl;
    }
    catch(invalid_argument e){
        cout<<"Niepoprawne dane"<<endl;
    }
    LiczbyPierwsze liczby= LiczbyPierwsze(stoi(args[0]));
    for(int i=1;i<argumenty;i++){
        try{

        }catch(...)
        {

        }
    }
    return 0;
}