

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
                        if((Double.parseDouble(args[1])<=0d)||(Double.parseDouble(args[2])<=0d)||(Double.parseDouble(args[3])<=0d)||(Double.parseDouble(args[4])<=0d)){throw new Exception("Zbyt mala liczba");}
                        else if(Double.parseDouble(args[5])==90d)
                        {
                            if(Double.parseDouble(args[1])==Double.parseDouble(args[2])&&Double.parseDouble(args[2])==Double.parseDouble(args[3])&&Double.parseDouble(args[3])==Double.parseDouble(args[4])){
                                Pojedyncze kwadrat = Pojedyncze.KWADRAT;
                                System.out.println(kwadrat.ObliczPole(Double.parseDouble(args[1])));
                                System.out.println(kwadrat.ObliczObwod(Double.parseDouble(args[1])));
                                System.out.println(kwadrat.PodajNazwe());
                            }
                            else{
                                if(Double.parseDouble(args[1])!=Double.parseDouble(args[3])||Double.parseDouble(args[2])!=Double.parseDouble(args[4]))throw new Exception("To nie jest prostokat");
                                Wielokrotne prostokat = Wielokrotne.PROSTOKAT;
                                System.out.println(prostokat.ObliczPole(Double.parseDouble(args[1]),Double.parseDouble(args[3])));
                                System.out.println(prostokat.ObliczObwod(Double.parseDouble(args[1]),Double.parseDouble(args[3])));
                                System.out.println(prostokat.PodajNazwe());
                            }
                        }
                        else{
                            Wielokrotne romb = Wielokrotne.ROMB;
                            System.out.println(romb.ObliczPole(Double.parseDouble(args[1]),Double.parseDouble(args[5])));
                            System.out.println(romb.ObliczObwod(Double.parseDouble(args[1]),Double.parseDouble(args[5])));
                            System.out.println(romb.PodajNazwe());
                        }
                     }else{
                        throw new Exception("Za malo argumentow dla czworokata");
                     }
                        break;
            default:
            throw new Exception("Niepoprawny typ figury");
                
        }
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
}
}
