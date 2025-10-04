public class Question37_FriendsPairing {
    public static int rec_fp(int n){
        if(n<=2) return  1  ; 
        int one  = rec_fp(n -1 ) ; 
        int two = (n-1) * rec_fp(n -2) ; 
        return one + two  ; 
    }
    public static int mem_fp(int n){
        int[]mem = new int[n+1] ; 
        if(n<=2) return mem[n] = 1 ; 
        if(mem[n]!=0) return mem[n] ; 
        int one  = mem_fp(n - 1) ; 
        int two  = (n-1) * mem_fp(n -2) ; 
        return mem[n]  = one + two  ; 
    }
    public static int tab_fp(int n){
        int [] tab = new int[n+1] ; 
        for(int i  = 0  ;  i   <= n  ; i ++){
            if(i <= 2){
                tab[i] = 1 ; 
                continue ; 
            }
            int one  = tab[i -1] ; 
            int two   = (i-1)*tab[i-2] ; 
            tab[i] = one + two  ; 
        }
        return tab[n] ; 
    }
    public static int  tab_bet_fp(int n){
        int a = 1 , b =1  ; 
        int c = 0  ; 
        for(int i = 3 ; i <= n ; i++){
            int one  = b ; 
            int two = (i-1)*a ; 
            c = one + two  ; 
            a = b ; 
            b = c ; 
        }
        return c; 
    }
    public static void main(String[] args) {
        int n = 5 ; 
        System.out.println("== Recursive ==");
        System.out.println(rec_fp(n));
        System.out.println("== Memoized ==");
        System.out.println(mem_fp(n));
        System.out.println("== Tabulation ==");
        System.out.println(tab_fp(n));
        System.out.println("== Tabulation Better ==");
        System.out.println(tab_bet_fp(n));
    }
}
