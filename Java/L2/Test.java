public class Test {
    public static void main(String[] args) 
    {
        LiczbyPierwsze liczby=null;
        if(args.length<=1){
            System.out.println("Brak argumentow");
            return;
        }

        try {
            int n = Integer.parseInt(args[0]);
            if(n<0){
                throw new NumberFormatException("Liczba ujemna");
            }
            liczby = new LiczbyPierwsze();
            liczby.Konstruktor(n);
            }catch(NumberFormatException ex)
            {
                System.out.println(ex.getMessage());
            }

        for(int i=1;i<args.length;i++){
            try {
                int n = Integer.parseInt(args[i]);
                if(n<0){
                    throw new NumberFormatException("Liczba ujemna");
                }
                if(n>liczby.pierwsze.length-1){
                    throw new NumberFormatException("jest poza zakresem tablicy");
                }
                
                
                    System.out.println(args[i] + " " + liczby.liczba(n));
                
            }catch (NumberFormatException e) 
            {
                System.out.println(args[i]+" "+e.getMessage());
            }
        }
    }
}
