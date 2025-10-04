public class Question18_LongestPalindromicSubstring {
    public static boolean palindrome(String s ,int i , int j ){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false  ;
            }
            i++ ; 
            j-- ;
        }
        return true ;
    }
    //longest palindromic subsequence by the brute force manner 
    public static int lps(String s){
        int si =  0  ; 
        int ei =  0  ; 
        int maxlen = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i  ; j < s.length() ; j++){
                int currlen =  1  ; 
                if(palindrome(s,i,j)){
                    currlen = j - i  +1 ;
                    if(currlen>maxlen){
                        si = i  ; 
                        ei =  j ; 
                        maxlen = currlen ; 
                    }
                }
            }
        }
        System.out.println(s.substring(si, ei+1));
        return maxlen ; 
    }

    //Longest palindromic substring by dp  method 
    public static String pld(String s){
        int n  = s.length() ; 
        int [][] dp = new int[n][n] ; 
        int maxlen = 0 ; 
        int si = 0  ; 
        for(int gap = 0 ; gap < s.length() ; gap++){
            for(int i = 0  , j  = gap ; j < n ; i++ , j++ ){
                if(gap==0){
                dp[i][j] = 1 ;
                }
                else if(gap==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = 1 ; 
                    }
                    else dp[i][j] = 0 ; 
                }
                else {
                    if(s.charAt(i)==s.charAt(j)){
                        // si = i ; 
                        dp[i][j] = dp[i+1][j-1] ; 
                    }
                }
                if(dp[i][j]==1 && maxlen < j - i + 1){
                    si = i  ;
                    maxlen = Math.max(maxlen,j-i + 1) ; 
                }
            }
        }
        System.out.println(maxlen);
        return s.substring(si , si + maxlen ) ; 
    }
    public static void main(String[] args) {
        String s  = "aaaaabaaa" ;
        System.out.println(pld(s));
    }
}
