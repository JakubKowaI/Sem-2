#include <iostream>

class figura {
   virtual double obwod();
    virtual double pole();
    virtual void wypisz();
    
}
class czworokat : figura{
    public:
    double bok1;
    double bok2;
    double bok3;
    double bok4;
    double kat;
}

class kolo : figura{
    public:
    double promien;
kolo(double r){
    promien =r;
}
double pole(){
    return (Math.PI*promien*promien);
}
double obwod(){
    return 2*Math.PI*promien;    
}
void wypisz(){    
    cout<<"Pole: "<<pole()<<endl;
    cout<<"Obwod: "<<obwod()<<endl;
    cout<<"Kolo\n";
}
}

class pieciokat : figura{
    public:
double bok;
pieciokat(double b){
    bok = b;
}
double pole(){
    return (5*bok*bok)/(4*Math.tan(Math.PI/5));    
}
double obwod(){
    return 5*bok;    
}

void wypisz(){    
    System.out.println("Pole: "+pole());
    System.out.println("Obwod: "+obwod());
    System.out.println("Pieciokat");
}

}
class szeciokat extends figura {
public double bok;
szeciokat(double b){
    bok = b;
}

public double pole(){
    return (3*Math.sqrt(3)*bok*bok)/2;    
}

public double obwod(){
    return 6*bok;    
}

public void wypisz(){    
    System.out.println("Pole: "+pole());
    System.out.println("Obwod: "+obwod());
    System.out.println("Szesciokat");
}
}

class prostokat extends czworokat{
prostokat(double b1,double b2,double b3, double b4,double k){
    bok1 = b1;
    bok2 = b2;
    bok3 = b3;
    bok4 = b4;
    kat = k;
}
public double pole(){
    if(bok1!=bok2){
    return bok1*bok2;    
    }
    else{        
        return bok1*bok3;
    }    
}
public double obwod(){
    return bok1+bok2+bok3+bok4;    
}
public void wypisz(){    
    System.out.println("Pole: "+pole());
    System.out.println("Obwod: "+obwod());
    System.out.println("Prostokat");
}
    
}
class kwadrat extends czworokat{
    kwadrat(double b1,double b2,double b3, double b4,double k){
        bok1 = b1;
        bok2 = b2;
        bok3 = b3;
        bok4 = b4;
        kat = k;
    }
public double pole(){
    return bok1*bok1;    
}
public double obwod(){
    return 4*bok1;    
}
public void wypisz(){    
    System.out.println("Pole: "+pole());
    System.out.println("Obwod: "+obwod());
    System.out.println("Kwadrat");
}
    
}
class romb extends czworokat{
    romb(double b1,double b2,double b3, double b4,double k){
        bok1 = b1;
        bok2 = b2;
        bok3 = b3;
        bok4 = b4;
        kat = k;
    }

public double pole(){
    return bok1*bok1*Math.sin(kat);
}

public double obwod(){
    return 4*bok1;    
}

public void wypisz(){    
    System.out.println("Pole: "+pole());
    System.out.println("Obwod: "+obwod());
    System.out.println("Romb");
}
}

int man(int argc, char* argv[])
{
    cout << "Hello, World!" << endl;
    return 0;
}