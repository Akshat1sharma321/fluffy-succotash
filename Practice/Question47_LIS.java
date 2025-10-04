public class Question47_LIS {
    public static int lis(int idx , int [] nums ){
        int maxi = 1 ; 
        for(int j  = idx -1 ; j >= 0  ;j--){
            if(nums[j] < nums[idx]){
                maxi = Math.max(maxi ,lis(j , nums) + 1 ) ; 
            }
        }
        return maxi ; 
    }
    public static int lis_dp(int[]nums){
        int n = nums.length ; 
        int [] dp = new int[n] ; 
        int res = 0  ; 
        for(int idx =  0 ;  idx < n ; idx++){
            dp[idx] = 1; 
            for(int j = idx - 1; j >= 0 ;j--){
                if(nums[j] < nums[idx]){
                    dp[idx]  =Math.max(dp[idx] , dp[j] + 1) ; 
                }
            }
        }
        return dp[n-1] ; 
    }
    public static void main(String[] args) {
        int len = 1 ; 
        int[]nums = {0 , 1 , 4 , 2 , 5 , 6} ; 
        for(int i =  0 ; i < nums.length ; i++){
            len = Math.max(len , lis(i , nums)) ; 
        }
        System.out.println(lis_dp(nums));
    }
}
