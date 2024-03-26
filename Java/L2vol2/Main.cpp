#include<iostream>
#include"LiczbyPierwsze.hpp"

using namespace std;

int main(int argc,char *argv[])
{   
   try{
    int n = stoi(argv[1]);
    if(n<2){
        cout<<argv[1]<<" to za krotki zakres\n";
        return 0;
    }
    }
    catch(invalid_argument){ 
        cout<<argv[1]<<" nie jest liczba"; return 0;
        }

        LiczbyPierwsze LiczPier(stoi(argv[1]));

        for(int i=2;i<argc;i++){  
        try{ 
        int n = stoi(argv[i]);
        if(n<0||n>LiczPier.pierwsze.size()-1){
            throw out_of_range("Liczba spoza zakresu");

            }
        cout<<argv[i]<<" "<<LiczPier.liczba(n)<<endl;
        }
        catch(out_of_range ){
            cout<<argv[i]<<" liczba spoza zakresu \n";
            }
        catch(invalid_argument){
            cout<<argv[i]<<" nie jest liczba \n";
            }
        catch(...){ 
            cout<<argv[i]<<" niepoprawne dane \n";
            }
    }    
    //delete LiczPier;
    return 0;
}