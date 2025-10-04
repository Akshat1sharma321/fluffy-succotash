import java.util.Arrays; 
public class Question16_KnapsackProblem {
    //Recursiive solution of the knapsack problem using the value ;
    public static int Knapsack(int[]val , int [] wt , int weight , int idx , int value){
        if(weight == 0 || idx == val.length){
         return value ;    
        }
        int currval = 0  ; 
        if(weight - wt[idx]>=0){
            currval = Knapsack(val, wt, weight - wt[idx], idx + 1, value + val[idx]) ; 
        }
        currval = Math.max(currval , Knapsack(val, wt, weight, idx + 1, value)) ; 
        return value  = currval ; 
    }
    //Recursive without using the value  
    public static int Knapsack(int[] val, int[] wt, int weight, int idx) {
        if (weight == 0 || idx == val.length) {
            return 0;
        }
        int currval = 0;
        if (weight - wt[idx] >= 0) {
            currval = val[idx] + Knapsack(val, wt, weight - wt[idx], idx + 1);
        }
        currval = Math.max(currval, Knapsack(val, wt, weight, idx + 1));
        return currval;
    }
    
    // Memoization solution  
    public static int Knapsack(int[] val, int[] wt, int weight, int idx , int[][] dp) {
        if (weight == 0 || idx == val.length) {
            return dp[idx][weight] = 0;
        }
        int currval = 0;
        if(dp[idx][weight]!=-1) return dp[idx][weight] ; 
        if (weight - wt[idx] >= 0) {
            currval = val[idx] + Knapsack(val, wt, weight - wt[idx], idx + 1 , dp);
        }
        currval = Math.max(currval, Knapsack(val, wt, weight, idx + 1 , dp));
        return dp[idx][weight] = currval;
    }

    // Tabulation solution of knapsack problem
    public static int knap_tab(int[]val , int [] wt , int weight , int[][]dp){
        for(int idx = 0 ; idx <= val.length ; idx++){
            for(int cap = 0 ; cap <= weight ; cap++){
                if(idx==0){
                    dp[idx][cap] = 0 ; 
                    continue  ; 
                }
                int pick = 0 ;  
                if(cap - wt[idx-1]>=0){
                    pick = val[idx-1] + dp[idx-1][cap - wt[idx-1]] ; 
                }
                int unpick  = dp[idx-1][cap] ; 
                dp[idx][cap] = Math.max(pick , unpick) ; 
            }
        }
        return dp[val.length][weight] ; 
    }
    //Practicing knapsack 
    public static int knap_prec( int [][] dp , int [] val , int[] wt , int cap , int idx ){
        if(idx == 0){
            return dp[0][cap] = 0 ; 
        }
        int pickCurr = 0  ; 
        if(cap-wt[idx-1]>=0){
            pickCurr = val[idx-1] + knap_prec(dp, val, wt, cap - wt[idx-1], idx - 1) ; 
        }
        int notpick = knap_prec(dp, val, wt, cap, idx - 1 ) ;
        return dp[idx][cap] =  Math.max(pickCurr, notpick) ; 
    }
    public static int knap_ptab(int [][] dp , int [] val , int [] wt ,int capacity){
        for(int idx  = 0 ; idx <= val.length ; idx++){
            for(int cap  =  0 ; cap <= capacity ; cap++){
                if(idx==0){
                    dp[idx][cap] = 0  ; 
                    continue ; 
                }
                int pick = 0 ; 
                if(cap - wt[idx - 1]>=0){
                    pick = val[idx-1] + dp[idx - 1][cap-wt[idx-1]] ; 
                }
                int notpick = dp[idx-1][cap] ; 
                dp[idx][cap] = Math.max(pick , notpick) ; 
            }
        }
        return dp[val.length][capacity] ; 
    }
    public static void main(String [] args){
        int [] val = {10,20,30,15,50} ; 
        int [] wt  = {5,4,2,1,3} ;
        int weight  = 6 ;  
        int[][]dp = new int[val.length+1][weight+1] ; 
        for(int [] row : dp){
            Arrays.fill(row,-1) ; 
        }
        System.out.println(knap_ptab(dp, val, wt, weight )) ; 
        // System.out.println(knap_tab(val,wt,weight ,dp)) ; 
    }
}
