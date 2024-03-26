public class Test{
    public static void main(String[] args) 
    {
        int n;
        try{
        if(args.length <= 1){
                throw new Exception("Za malo argumentow");
            }
        if(Integer.parseInt(args[0])<1){
            throw new Exception("Za mala wartosc");
            }
            n = Integer.parseInt(args[0]);
        }catch(Exception e)
        {
            System.out.println(args[0]+ " "+ e.getMessage());
            return;
        }
        
        WierszTrojkataPascala w = new WierszTrojkataPascala(n);
        for(int i=1;i<args.length;i++){
            try {
                int m = Integer.parseInt(args[i]);
                if(m<0){
                    throw new Exception("Liczba ujemna");
                }
                if(m>n){
                    throw new Exception("Liczba wieksza od n");
                }
                System.out.println(args[i]+" | "+w.liczba(m));
            }catch (Exception e) 
            {
                System.out.println(args[i]+" "+e.getMessage());
            }
        }
    }
}
