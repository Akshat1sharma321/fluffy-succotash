import java.util.Arrays;

public class Question9_MinimumCostClimbingStairs {
    //this is the leetcode 746 question
    //Recursion method of the mincost climbing stairs 
    public static int minCostClimbingStairs(int n , int[] cost) {
        if(n==-1){
            return 0 ; 
        }
        int mini = Integer.MAX_VALUE ; 
        if(n-1>=-1){
            mini = Math.min(mini,minCostClimbingStairs(n-1, cost)) ; 
        }
        if (n - 2 >= -1) {
            mini = Math.min(mini,minCostClimbingStairs(n-2, cost)) ;
        }
        return mini + cost[n] ; 
    }
    
    // Memozation method of the mincost climbing stairs
    public static int minCostClimbingStairsM(int n, int[] cost , int [] dp) {
        if (n == -1) {
            return dp[n+1] = 0 ;
        }
        int mini = Integer.MAX_VALUE;
        if(dp[n+1]!=-1)return dp[n+1] ; 
        if (n - 1 >= -1) {
            mini = Math.min(mini, minCostClimbingStairs(n - 1, cost));
        }
        if (n - 2 >= -1) {
            mini = Math.min(mini, minCostClimbingStairs(n - 2, cost));
        }
        return  dp[n+1] = mini + cost[n];
    }
    
    // Tabulation method of the mincost climbing stairs
    public static int minCostClimbingStairsT(int n, int[] cost, int[] dp) {
        for(int i = -1  ; i < n ; i++){
            if (i == -1) {
            dp[i + 1] = 0;
            continue  ;
            }

            int mini = Integer.MAX_VALUE;
            mini = Math.min(mini, dp[i]);
            if(i-2>=-1){
               mini = Math.min(mini,dp[i-1]); 
            }
            
            dp[i+1] = mini + cost[i] ; 
        }
        
        int mini = Integer.MAX_VALUE ; 
        mini = dp[n]>dp[n-1] ? dp[n-1] : dp[n] ; 
        return mini ; 
    }
    public static void main(String[] args) {
        int mini = Integer.MAX_VALUE  ;
        int[]cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1} ; 
        int n  = cost.length ; 
        int []dp =  new int[n+1] ; 
        Arrays.fill(dp, -1);
        // mini = Math.min(mini , minCostClimbingStairsM(n - 1, cost , dp)) ; 
        // mini = Math.min(mini, minCostClimbingStairsM(n - 2, cost , dp)) ; 
        mini = minCostClimbingStairsT(n, cost, dp) ; 
        System.out.println(mini);
    }
}
