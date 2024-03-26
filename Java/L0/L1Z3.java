import java.util.Scanner;

public class L1Z3 {

    public static int div(int n){
        int d = 1;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
            d = i;
            }
        }
        return d;
    }

    public static void main(String[] args) {
        //int n;
        Scanner scanner = new Scanner(System.in);
        string n = scanner.nextLine();
        try { n=Integer.parseInt(args[i]); }
catch (NumberFormatException ex) {
System.out.println(args[i] + " nie jest liczba calkowita");
}
//string name =div(10);
    System.out.println(div(n));
    
    }
}
