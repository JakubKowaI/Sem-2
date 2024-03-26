public class LiczbyPierwsze {
    public int pierwsze[];
    public int licznik=0;
        LiczbyPierwsze() {
                 
        }

        public void Konstruktor(int k)
        {
            for(int i=0;i<k;i++){
                if(pierwsza(i)){
                    licznik++;
                }
            }
            pierwsze = new int[licznik];
            for(int i=0,j=0;i<=k;i++){
                if(pierwsza(i)){
                    pierwsze[j]=i;
                    j++;
                }
            }       

        }
        
        public boolean pierwsza(int n){
            if(n<2){
                return false;
            }
            for(int i=2;i<n;i++){
                if(n%i==0){
                    return false;
                }
            }
            return true;
        }
        public int liczba(int m){
            return pierwsze[m];
        }
}
