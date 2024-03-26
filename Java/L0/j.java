
public class j {

    public static int div(int n){
        int d = 1;
        int z=n;
        if(n<0)
        {
            z=-n;
        }
        for (int i = 2; i < z; i++) {
            if (z % i == 0) {
            d = i;
            }
        }
        /*if(n<0)
        {
            d=-d;
        }*/
        return d;
    }

    public static void main(String[] args) {
        for(int i=0; i<args.length; i++){
            try {int n = Integer.parseInt(args[i]);
                System.out.println(args[i]+ " "+div(Integer.parseInt(args[i]))); }
            catch (NumberFormatException ex) {
                System.out.println(args[i] + " nie jest liczba calkowita");
            }
        
        }    
    }
}
