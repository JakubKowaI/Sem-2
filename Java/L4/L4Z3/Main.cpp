#include <iostream>
#include <string>
#include "WTP.hpp"

using namespace std;

int main(int licznik, char* argumenty[]) {
    try{
        if(licznik<3){
            throw string("Niepoprawna liczba argumentow");
        }
        int m = stoi(argumenty[1]);
        if(stoi(argumenty[1])<0){
            throw string("Argument 1 nie moze byc ujemny");
        }

    }catch(string e){
        cout<<e<<endl;
    }

    WTP wier(stoi(argumenty[1]));

    for(int i=2; i<=licznik-1; i++){
        try{
            int x=stoi(argumenty[i]);
            if(stoi(argumenty[i])<0){
                throw string("Argument "+to_string(i)+" nie moze byc ujemny");
            }
            if(stoi(argumenty[i])>stoi(argumenty[1])){
                throw string("Argument "+to_string(i)+" nie moze byc wiekszy od argumentu 1");
            }
            
            cout<<wier.wiersz[stoi(argumenty[i])]<<endl;
        }catch(string e){
            cout<<e<<endl;
        }catch(invalid_argument)
        {
            cout<<argumenty[i]<<" | zly typ"<<endl;
        }catch(...)
        {
            cout<<"blad"<<endl;
        }

        
        
    }
    
    return 0;
}