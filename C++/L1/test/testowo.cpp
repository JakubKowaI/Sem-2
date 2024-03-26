#include <iostream>
using namespace std;

int main(int liczba_argumentow, char *argumenty[]){
    for(int i=0;i<liczba_argumentow;i++){
        cout<<argumenty[i]<<endl;
    }
    return 0;
}