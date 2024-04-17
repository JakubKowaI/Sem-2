#include <iostream>
#include <cmath>
#include <string>

using namespace std;

class figura {
    public:
   virtual double obwod()=0;
    virtual double pole()=0;
    virtual void wypisz()=0;
    
};
class czworokat : public figura{
    public:
    double bok1;
    double bok2;
    double bok3;
    double bok4;
    double kat;
};

class kolo : public figura{
    public:
    double promien;
kolo(double r){
    promien =r;
}
double pole(){
    return (M_PI*promien*promien);
}
double obwod(){
    return 2*M_PI*promien;    
}
void wypisz(){    
    cout<<"Pole: "<<pole()<<endl;
    cout<<"Obwod: "<<obwod()<<endl;
    cout<<"Kolo\n";
}
};

class pieciokat : public figura{
    public:
double bok;
pieciokat(double b){
    bok = b;
}
double pole(){
    return ((sqrt(25+(10*sqrt(5))))/4)*bok*bok;    
}
double obwod(){
    return 5*bok;    
}

void wypisz(){    
    cout<<"Pole: "<<pole()<<endl;
    cout<<"Obwod: "<<obwod()<<endl;
    cout<<"Pieciokat\n";
}
};
class szeciokat : public figura {
    public:
double bok;
szeciokat(double b){
    bok = b;
}

double pole(){
    return (3*sqrt(3)*bok*bok)/2;    
}

double obwod(){
    return 6*bok;    
}

void wypisz(){    
    cout<<"Pole: "<<pole()<<endl;
    cout<<"Obwod: "<<obwod()<<endl;
    cout<<"Szesciokat\n";
}
};

class prostokat : public czworokat{
    public:
prostokat(double b1,double b2,double b3, double b4,double k){
    bok1 = b1;
    bok2 = b2;
    bok3 = b3;
    bok4 = b4;
    kat = k;
}
double pole(){
    if(bok1!=bok2){
    return bok1*bok2;    
    }
    else{        
        return bok1*bok3;
    }    
}
double obwod(){
    return bok1+bok2+bok3+bok4;    
}
void wypisz(){    
    cout<<"Pole: "<<pole()<<endl;
    cout<<"Obwod: "<<obwod()<<endl;
    cout<<"Prostokat\n";
}
};
class kwadrat : public czworokat{
    public:
    kwadrat(double b1,double b2,double b3, double b4,double k){
        bok1 = b1;
        bok2 = b2;
        bok3 = b3;
        bok4 = b4;
        kat = k;
    }
double pole(){
    return bok1*bok1;    
}
double obwod(){
    return 4*bok1;    
}
void wypisz(){    
    cout<<"Pole: "<<pole()<<endl;
    cout<<"Obwod: "<<obwod()<<endl;
    cout<<"Kwadrat\n";
}   
};

class romb : public czworokat{
    public:
    romb(double b1,double b2,double b3, double b4,double k){
        bok1 = b1;
        bok2 = b2;
        bok3 = b3;
        bok4 = b4;
        kat = k;
    }

double pole(){
    return bok1*bok1*sin(kat);
}

double obwod(){
    return 4*bok1;    
}

void wypisz(){    
    cout<<"Pole: "<<pole()<<endl;
    cout<<"Obwod: "<<obwod()<<endl;
    cout<<"Romb\n";
}
};
/*
enum stringi{
            eo = 'o',
            ep = 'p',
            es = 's',
            ec = 'c',
            test = 0,
        };

    stringi czy(string const& s){
            if(s=="o")return eo;
            if(s=="p")return ep;
            if(s=="s")return es;
            if(s=="c")return ec;
            return test;
        }*/

int main(int argc,char* args[])
{
    try {
            if(argc<3){
                throw new string("Za malo argumentow");
            }
            if(argc>7){
                throw new string("Za duzo argumentow");
            }
        if(args[1][0]=='o'){
            if(stod(args[2])<=0){
                throw new string("Promien nie moze byc ujemny lub rowny 0");
            }
            figura *f = new kolo(stod(args[2]));f->wypisz();}
        else if(args[1][0]=='p'){
            if(stod(args[2])<=0){
                throw new string("Bok nie moze byc ujemny lub rowny 0");
            }
            figura *f = new pieciokat(stod(args[2]));f->wypisz();}
        else if(args[1][0]=='s'){
            if(stod(args[2])<=0){
                throw new string("Bok nie moze byc ujemny lub rowny 0");
            }
            figura *f = new szeciokat(stod(args[2]));f->wypisz();}
        else if(args[1][0]=='c'){ 
            if(stod(args[2])<=0.0 || stod(args[3])<=0.0 || stod(args[4])<=0.0 || stod(args[5])<=0.0)throw new string("Bok nie moze byc ujemny lub rowny 0");
            if(stod(args[6])<=0)throw new string("Kat nie moze byc ujemny lub rowny 0");
                    if (stod(args[6]) == 90.0) {
                        if (args[2] == args[3] && args[3] == args[4] && args[4] == args[5]) {
                            figura *f = new kwadrat(stod(args[2]), stod(args[3]), stod(args[4]), stod(args[5]), stod(args[6]));
                            f->wypisz();
                        }
                        else {
                            figura *f = new prostokat(stod(args[2]), stod(args[3]), stod(args[4]), stod(args[5]), stod(args[6]));
                            f->wypisz();
                        }
                    }
                    else {
                        figura *f = new romb(stod(args[2]), stod(args[3]), stod(args[4]), stod(args[5]), stod(args[6]));
                        f->wypisz();
                    }
                
                }else{
                    throw new string("Zla ilosc argumentow");
                }

        
        
            
         }catch (string e) {
            cout<<e<<endl;
        }catch(invalid_argument){
            cout<<"Zly typ argumentu"<<endl;
        }catch(...){
            cout<<"Blad"<<endl;
        }
        return 0;
}