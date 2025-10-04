import java.util.Arrays;
public class Question3_ClimbingStairs {
    //Recursion climbStairs 
    public static int climbStairs(int n) {
        if(n<0)return 0 ; 
        if(n==0)return 1 ; 
        int onestep = climbStairs(n - 1) ; 
        int twostep = climbStairs(n - 2) ; 
        return onestep  + twostep ; 
    }
    //Memoization climmbStairs 
    public static int climbStairs_Memo(int n , int[]dp) {
        if(n==0)return dp[n] = 1 ; 
        int onestep = 0 , twostep =  0 ;
        if(n-1>=0){
            onestep  = climbStairs_Memo(n-1 , dp) ; 
        }
        if(n-2>=0){
            twostep = climbStairs_Memo(n-2, dp) ;  
        }
        return dp[n] = onestep + twostep ; 
    }
    
    // Tabulation climmbStairs
    public static int climbStairs_Tab(int n, int[] dp) {
        for(int i  = 0 ; i <= n ; i++){
            if(i==0){
                dp[i] = 1 ; 
                continue ; 
            }
            int onestep = 0 , twostep = 0 ; 
            if(i-1>=0){
            onestep  = dp[i-1] ;  
            }
            if(i-2>=0){
            twostep =  dp[i-2] ; 
            }
            
            dp[i] = onestep + twostep ; 
        }
        return dp[n] ; 
    }
    
    // Tabulation climmbStairs
    public static int climbStairs_TabBet(int n) {
        int a = 1 ; 
        int b = 1  ; 
        int c = 0  ; 
        if(n<=1) return 1 ; 
        for (int i = 2; i <= n; i++) {
            int onestep = 0, twostep = 0;
            if (i - 1 >= 0) {
                onestep = b;
            }
            if (i - 2 >= 0) {
                twostep = a;
            }
            c = onestep + twostep;
            a = b ; 
            b = c ; 
        }
        return c;
    }
    public static void main(String [] args){
        int n = 3 ; 
        int[]dp = new int[n+1] ; 
        Arrays.fill(dp,-1) ; 
        System.out.println(climbStairs_TabBet(n))  ; 
    }
}
