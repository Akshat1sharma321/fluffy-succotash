import java.util.Arrays; ; 
public class Question14_MinCoinslc322 {
    //MIn coins using memoization 
    public static int min_coinchange(int[] coins, int target, int[] dp) {
        if (target == 0) {
            return dp[target] = 0;
        }
        int mini = (int) (1e8);
        if (dp[target] != -1)
            return dp[target];
        for (int coin : coins) {
            int currcoins = (int) (1e8);
            if (target - coin >= 0)
                currcoins = min_coinchange(coins, target - coin, dp);
            mini = Math.min(currcoins + 1, mini);
        }
        return dp[target] = mini;
    }
    //Min coins using tabulation 
    public static int minCoins(int[]coins,int target , int[] dp){
        for(int tar = 0 ;  tar <= target ; tar++){
            if(tar==0){
                dp[tar] = 0 ; 
                continue ; 
            }
            int minC = (int)(1e9) ; 
            for(int coin : coins){
                int currCoin =  0 ; 
                if(tar-coin>=0){
                    currCoin =  dp[tar-coin] ;  
                }
                minC = Math.min(currCoin+1,minC) ; 
            }
            dp[tar]  = minC ; 
        }
        return dp[target];  
    }
    public static void main(String[] args) {
        int target  =  7   ; 
        int[]coins = {2,4,5} ; 
        int[]dp = new int[target+1] ;
        Arrays.fill(dp,-1) ; 
        System.out.println(minCoins(coins, target, dp)) ; 
    }
}
