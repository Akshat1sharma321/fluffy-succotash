import java.util.Arrays;

public class Question12_CoinChange {
    //Coin change through permutation 
    public static int coinchangeperm(String asf , int target , int idx , int[]ar){
        if(target==0){
            System.out.println(asf);
            return 1 ; 
        }
        int totalways = 0 ;  
        if(target - ar[idx]>=0){
           totalways += coinchangeperm(asf+""+ ar[idx] ,  target - ar[idx],idx, ar) ; 
        }
        if(idx+1<ar.length){
            totalways += coinchangeperm(asf , target ,idx+1, ar);
        }
        return totalways ; 
    }
    
    // Coin change through permutation for loop
    public static int coinchangepermf(String asf, int target, int idx, int[] ar) {
        if (target == 0) {
            System.out.println(asf);
            return 1;
        }
        int totalways = 0;
        for(int i = 0 ; i < ar.length ; i++){
            if (target - ar[i] >= 0) {
                totalways += coinchangepermf(asf + "" + ar[i], target - ar[i], 0, ar);
            }
        }
        return totalways;
    }
    //Coin change through permutation through memoization 
    public static int coinchangepermm(String asf , int target , int idx , int [] ar , int [] dp){
        if(target==0){
            System.out.println(asf);
            return dp[idx] = 1 ; 
        }
        if(dp[target]!=-1) return dp[target] ; 
        int tot = 0  ; 
        for(int i : ar){
            if(target - i>=0){
                tot+=coinchangepermm(asf+""+i, target-i, 0, ar, dp) ; 
            }
        }
        return dp[target] = tot ; 
    }
    
    // Coin change through permutation through tabulation
    public static int coinchangepermt(String asf, int target,  int[] ar, int[] dp) {
        for(int tar = 0 ; tar <= target ; tar++ ){
            if (tar == 0) {
            System.out.println(asf);
            dp[tar] = 1;
            continue ; 
        }
        int tot = 0;
        for (int i : ar) {
            if (tar - i >= 0) {
                tot += dp[tar-i];
            }
        }
        dp[tar] = tot;
        }
        return dp[target] ; 
    }
    public static void main(String[] args) {
        String asf = "" ; 
        int[]dp = new int[8] ; 
        Arrays.fill(dp,-1);
        int[]ar = {2,3,5} ; 
        System.out.println(coinchangepermt(asf, 7,  ar , dp));  
    }
}
