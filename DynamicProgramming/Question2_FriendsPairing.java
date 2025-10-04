import java.util.Arrays ; 
public class Question2_FriendsPairing {
    //Recursion 
    public static long cfr_Rec(int n) {
        // code here
        if(n<=1)return 1 ;
        return cfr_Rec(n-1) + (n-1)*cfr_Rec(n-2) ; 
    }
    //Memoization
    public static long cfr_Memo(int n , int[]dp) {
        // code here
        if (n <= 1)
            return dp[n]=1;
        if(dp[n]!=-1)return dp[n] ; 
        return dp[n] = (int)(cfr_Rec(n - 1) + (n - 1) * cfr_Rec(n - 2));
    }
    //Tabulation
    public static long cfr_Tab(int n, int[] dp) {
        for(int i = 0  ; i <= n ; i++){
            if (i <= 1){
                dp[n] = 1;
                continue ; 
            }
        dp[i] = dp[i-1] + (i-1)*dp[i-2] ; 
        }
        return (long)dp[n] ; 
    }
    //Tabulation Better
    public static long cfr_TabBet(int n) {
        int a  = 1   ; 
        int b = 1 ;
        int c = 0 ; 
        for (int i = 2; i <= n; i++) {
            
            c = b + (i - 1) * a;
            a = b  ;
            b = c ; 
        }
        return (long) c ;
    }
    public static void main(String []args){
        int n = 3  ; 
        int[]dp  = new int[n+1] ; 
        Arrays.fill(dp, -1);
        System.out.println(cfr_TabBet(n));
    }
}
