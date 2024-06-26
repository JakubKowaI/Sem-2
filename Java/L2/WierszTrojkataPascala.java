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
        for (int i = 1; i <= n; i++) {
            wiersz[i]=silnia(n)/(silnia(i)*silnia(n-i));
        }

    }

    public int liczba(int m){
        return wiersz[m];
    }
}