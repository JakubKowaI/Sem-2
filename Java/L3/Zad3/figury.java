

interface MetodyPoj {
    public double ObliczPole(double a);
    public double ObliczObwod(double a);
    public String PodajNazwe();    
    }

    interface MetodyWiel {
        public double ObliczPole(double a,double b);
        public double ObliczObwod(double a,double b);
        public String PodajNazwe();    
        }

public class figury {
    
    
public enum Pojedyncze implements MetodyPoj{
            KOLO{
                public double ObliczPole(double r){
                    return Math.PI*r*r;
                }
                public double ObliczObwod(double r){
                    return 2*Math.PI*r;
                }
                public String PodajNazwe(){
                    return "Kolo";
                }
            },
            PIECIOKAT{
                public double ObliczPole(double bok){
                    return ((Math.sqrt(25+(10*Math.sqrt(5))))/4)*bok*bok;
                }
                public double ObliczObwod(double bok){
                    return 5*bok;
                }
                public String PodajNazwe(){
                    return "Pieciokat";
                }
            },
            SZESCIOKAT{
                public double ObliczPole(double bok){
                    return (3*Math.sqrt(3)*bok*bok)/2;
                }
                public double ObliczObwod(double bok){
                    return 6*bok;
                }
                public String PodajNazwe(){
                    return "Szesciokat";
                }
            },
            KWADRAT{
                public double ObliczPole(double bok){
                    return bok*bok;
                }
                public double ObliczObwod(double bok){
                    return 4*bok;
                }
                public String PodajNazwe(){
                    return "Kwadrat";
                }
            };

            
            
        }

        public enum Wielokrotne implements MetodyWiel{
            PROSTOKAT{
                public double ObliczPole(double bok1,double bok2){
                    return bok1*bok2;
                }
                public double ObliczObwod(double bok1,double bok2){
                    return 2*bok1+2*bok2;
                }
                public String PodajNazwe(){
                    return "Prostokat";
                }
            },
            ROMB{
                public double ObliczPole(double bok, double kat){
                    return bok*bok*Math.sin(kat);
                }
                public double ObliczObwod(double bok, double kat){
                    return 4*bok;
                }
                public String PodajNazwe(){
                    return "Romb";
                }
            },
            
        }
    
    public static void main(String args[]){

try{
if(args.length<2)throw new Exception("Za malo argumentow");
if(args.length>6)throw new Exception("Za duzo argumentow");
if(Double.parseDouble(args[1])<=0d)throw new Exception("Zbyt mala liczba");

        switch (args[0]) {
            case "o":
                Pojedyncze kolo = Pojedyncze.KOLO;
                System.out.println(kolo.ObliczPole(Double.parseDouble(args[1])));
                System.out.println(kolo.ObliczObwod(Double.parseDouble(args[1])));
                System.out.println(kolo.PodajNazwe());
                break;
            case "p":
                Pojedyncze pieciokat = Pojedyncze.PIECIOKAT;
                System.out.println(pieciokat.ObliczPole(Double.parseDouble(args[1])));
                System.out.println(pieciokat.ObliczObwod(Double.parseDouble(args[1])));
                System.out.println(pieciokat.PodajNazwe());
                    break;
            case "s":
                Pojedyncze szesciokat = Pojedyncze.SZESCIOKAT;
                System.out.println(szesciokat.ObliczPole(Double.parseDouble(args[1])));
                System.out.println(szesciokat.ObliczObwod(Double.parseDouble(args[1])));
                System.out.println(szesciokat.PodajNazwe());
                    break;
            case "c":
                     if(args.length==6){  
                        double bok1 = Double.parseDouble(args[1]);
                        double bok2 = Double.parseDouble(args[2]);
                        double bok3 = Double.parseDouble(args[3]);
                        double bok4 = Double.parseDouble(args[4]);
                        double kat = Double.parseDouble(args[5]); 
                        if((bok1<=0d)||(bok2<=0d)||(bok3<=0d)||(bok4<=0d)){throw new Exception("Zbyt mala liczba");}
                        else if(kat==90d)
                        {
                            if(bok1==bok2&&bok2==bok3&&bok3==bok4){
                                Pojedyncze kwadrat = Pojedyncze.KWADRAT;
                                System.out.println(kwadrat.ObliczPole(bok1));
                                System.out.println(kwadrat.ObliczObwod(bok1));
                                System.out.println(kwadrat.PodajNazwe());
                            }
                            else{
                                if(bok1==bok3&&bok2==bok4){
                                    Wielokrotne prostokat = Wielokrotne.PROSTOKAT;
                                    System.out.println(prostokat.ObliczPole(bok1,bok2));
                                    System.out.println(prostokat.ObliczObwod(bok1,bok2));
                                    System.out.println(prostokat.PodajNazwe());
                                }
                                else if(bok1==bok2&&bok3==bok4){
                                    Wielokrotne prostokat = Wielokrotne.PROSTOKAT;
                                    System.out.println(prostokat.ObliczPole(bok1,bok3));
                                    System.out.println(prostokat.ObliczObwod(bok1,bok3));
                                    System.out.println(prostokat.PodajNazwe());
                                }else if(bok1 == bok4 && bok2 == bok3){
                                    Wielokrotne prostokat = Wielokrotne.PROSTOKAT;
                                    System.out.println(prostokat.ObliczPole(bok1,bok2));
                                    System.out.println(prostokat.ObliczObwod(bok1,bok2));
                                    System.out.println(prostokat.PodajNazwe());
                                }else throw new Exception("Niepoprawne wymiary prostokata");
                            }
                        }
                        else{
                            Wielokrotne romb = Wielokrotne.ROMB;
                            System.out.println(romb.ObliczPole(bok1,kat));
                            System.out.println(romb.ObliczObwod(bok1,kat));
                            System.out.println(romb.PodajNazwe());
                        }
                     }else{
                        throw new Exception("Za malo argumentow dla czworokata");
                     }
                        break;
            default:
            throw new Exception("Niepoprawny typ figury");
                
        }
    
    }catch(NumberFormatException e){
        System.out.println("Zly format liczby");
    }catch(Exception e){
            System.out.println(e.getMessage());
}
}
}
