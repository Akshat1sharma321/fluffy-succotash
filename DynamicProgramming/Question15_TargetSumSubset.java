import java.util.Arrays;
public class Question15_TargetSumSubset {
    //Target Sum Subset using recursion 
    public static Boolean targetsumrec(int [] array , int target , int idx){
        if(target==0 || idx== array.length){
            return target == 0 ? true : false ; 
        }
        Boolean isPossible  = false ; 
        if(target - array[idx]>=0){
            isPossible = targetsumrec(array, target - array[idx], idx + 1)  ; 
        }
        isPossible = isPossible || targetsumrec(array, target, idx + 1) ; 
        return isPossible  ; 
    }
    
    // Target Sum Subset using memoization but boolean
    public static boolean targetsumrecMr(int[] array, int target, int idx, int[][] dp) {
        if (target == 0 || idx == array.length) {
            return target == 0 ? true : false;
        }
        Boolean isPos = false ; 
        if (dp[idx][target] != -1)
            if(dp[idx][target]==0){
                return false ; 
            }
            else{
                return true ; 
            }
        if (target - array[idx] >= 0) {
            isPos = targetsumrecMr(array, target - array[idx], idx + 1, dp);
        }
         isPos = isPos || targetsumrecMr(array, target, idx + 1, dp);
        return isPos ; 
    }
    // Target Sum Subset using memoization
    public static int targetsumrecM(int[] array, int target, int idx , int[][]dp) {
        if (target == 0 || idx == array.length) {
            return dp[idx][target] =  target == 0 ? 1 : 0;
        }
        int count = 0  ;
        if(dp[idx][target]!=-1) return dp[idx][target] ; 
        if (target - array[idx] >= 0) {
            count = targetsumrecM(array, target - array[idx], idx + 1 , dp);
        }
        count  +=  targetsumrecM(array, target, idx + 1, dp);
        return count;
    }
    //target sum using tabulation 
    public static int targetsum_tab(int[]arr , int target ,  int[][]dp){
        for(int idx = arr.length ; idx >= 0 ; idx--){
            for(int tar = 0 ; tar <= target ; tar++){
                if(idx == arr.length){
                    dp[idx][tar] = tar == 0  ?  1 : 0 ; 
                    continue ;   
                }
                int count  = 0 ; 
                if(tar - arr[idx]>=0){
                    count  = dp[idx+1][tar-arr[idx]] ; 
                }
                count  += dp[idx+1][tar] ; 
                dp[idx][tar] = count  ; 
            }
        }
        return dp[0][target] ; 
    }
    public static void main(String[] args) {
        int[]array = {2,5,1,4,3} ;
        int target = 9 ; 
        int[][] dp = new int[array.length + 1][target + 1];
        for(int[]row : dp){
            Arrays.fill(row,-1) ; 
        }
        System.out.println(targetsum_tab(array, target , dp));
    }
}
