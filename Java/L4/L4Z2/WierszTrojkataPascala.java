public class WierszTrojkataPascala {
    public int[] wiersz;

    public int silnia(int n){
        int iloczyn=1;
        for(int i=1;i<=n;i++){
            iloczyn*=i;
        }
        return iloczyn;
    }

    WierszTrojkataPascala(int n)
    {
        wiersz = new int[n + 1];
        wiersz[0] = 1;
        int wynik;

        for(int i = 1; i <= n; i++) {
            wynik=1;
            for (int j = 1; j <= i; j++) {
                wynik = wynik * (n-j+1)/j;
            }
            wiersz[i]=wynik;
        }
    }

    public String wypisz(){
        String wynik = "";
        for (int i = 0; i < wiersz.length; i++) {
            wynik += wiersz[i] + " ";
        }
        return wynik;
    }
}