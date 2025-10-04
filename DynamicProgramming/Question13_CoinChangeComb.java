import java.util.Arrays;
public class Question13_CoinChangeComb {
    //Coin change combination through recursion
    public static int ccr(int target , int [] coins , int idx){
        if(target == 0 ){
            return 1 ; 
        }
        int tot =  0  ;  
        for(int i = idx ; i < coins.length ; i++){
            if(target - coins[i]>=0){
                tot+= ccr(target-coins[i], coins, i ) ; 
            }
        }
        return tot ; 
    }
    
    // Coin change combination through Memoization it is wrong 
    public static int ccm(int target, int[] coins, int idx , int[]dp) {
        if (target == 0) {
           return dp[target] = 1 ; 
        }
        if(dp[target]!=-1) return dp[target] ;
        int tot = 0;
        for (int i = idx; i < coins.length; i++) {
            if (target - coins[i] >= 0) {
                tot += ccm(target - coins[i], coins, i ,dp);
            }
        }
        return  dp[target] = tot;
    }
    // Coin change combination through Tabulation 1D 
    public static int cct(int target , int []coins){
        int[] dp = new int[target+1]  ; 
        for(int coin : coins){
            for(int idx = coin ; idx <= target ; idx++){
                dp[idx]+=dp[idx-coin] ; 
            }
        }
        return dp[target] ; 
    }
    public static void main(String[] args) {
        int [] coins = {2,3,5} ; 
        int target = 7  ; 
        int[]dp  = new int[target+1] ;
        Arrays.fill(dp,-1) ; 
        System.out.println(ccm(target, coins, 0 , dp));
    }
    
}
