public class Question19_LongestPalindromicSubsequence {
    //longest palindromic subsequence by the recursion method  
    public static int lps_rec(int start ,  int end ,  String s){
        if(start == end){
            if(s.charAt(start)==s.charAt(end)) return 1 ; 
        }
        
        if(start > end){
            return 0 ; 
        }

        int wepicked =  0  ; 
        int notpicked = 0  ; 
        if(s.charAt(start)==s.charAt(end)){
            wepicked = lps_rec(start+1, end-1, s) + 2 ; 
        }
        else{
            notpicked = Math.max(lps_rec(start, end-1,  s),lps_rec(start+1, end,  s)) ; 
        }
        return Math.max(wepicked, notpicked) ; 
    }
    //longest palindromic subsequence by the memoization method 
    public static int lps_mem(int start , int end , String s , int[][]dp){
        if(start==end){
            return dp[start][end] = 1 ; 
        }
        if(start > end){
            return dp[start][end] = 0    ; 
        }
        if(dp[start][end]!=0) return dp[start][end]  ; 
        if(s.charAt(start)==s.charAt(end)){
            return dp[start][end] = lps_mem(start+1, end-1, s, dp) + 2 ; 
        }
        else{
            return dp[start][end] = Math.max(lps_mem(start+1, end, s, dp),lps_mem(start, end-1, s, dp)) ; 
        }
    }
    //longest palindrom subsequence by the tabulation method 
    public static int lps_tab(String s ){
        int n  = s.length() ; 
        int maxim = 1  ; 
        int [][] dp = new int [n+1][n+1] ;
        for(int gap = 0  ; gap < n ; gap++){
            for(int start = 0 , end = gap ; end< n ; start++ ,end++){
                if(start == end ){
                    dp[start][end] = 1 ; 
                    continue  ; 
                }
                if(s.charAt(start)==s.charAt(end)){
                    dp[start][end] = 2 + dp[start+1][end-1] ; 
                    maxim = Math.max(maxim,dp[start][end]) ;
                    continue ;  
                }
                else{
                    dp[start][end]  = Math.max(dp[start+1][end] , dp[start][end-1]) ; 
                    maxim = Math.max(maxim , dp[start][end]) ; 
                    continue  ; 
                }

            }
        } 
        return maxim ; 
    }
    public static void main(String[] args) {
        String s = "badbbb" ; 
        // int[][]dp = new int[s.length()+1][s.length()+1] ; 
        System.out.println(lps_tab( s));
    }
}
