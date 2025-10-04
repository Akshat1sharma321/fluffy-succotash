import java.util.Arrays;

public class Question43_targetSumLC {
    public int tot(int[] nums, int target, int n, int su, int curr) {
        if (curr == n && su == target)
            return 1;
        if (curr == n)
            return 0;
        int totways = 0;
        int pos = tot(nums, target, n, su + nums[curr], curr + 1);
        int neg = tot(nums, target, n, su - nums[curr], curr + 1);
        return totways = pos + neg;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return tot(nums, target, n, 0, 0);
    }


    //  public int tot(int[]nums , int target , int n  , int su  , int curr , int[][]dp ,int off){
    //     if(curr == n && su == target) return dp[curr][su + off] = 1 ; 
    //     if(curr == n) return dp[curr][su + off] = 0   ; 
    //     int totways = 0  ; 
    //     if(dp[curr][su+off]!=-1)return dp[curr][off+su] ; 
    //     int pos = tot(nums , target , n  , su + nums[curr], curr + 1 , dp , off) ; 
    //     int neg = tot(nums, target , n  , su - nums[curr], curr + 1 , dp , off) ; 
    //     return dp[curr][su+off] = pos + neg ; 
    // }
    // public int findTargetSumWays(int[] nums, int target) {
    //     int n  = nums.length ; 
    //     int [][] dp = new int[n+1][2001] ;
    //     for(int[]row : dp){
    //          Arrays.fill(row,-1) ; 
    //     }
        
    //    return tot(nums , target , n , 0 , 0  , dp , 1000) ; 
    // }
}
