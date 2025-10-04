import java.util.*;
public class Question10_DecodeWays {
    //Decode ways in recursion 
    public static int numDecodings(int idx  , String s) {
     if(idx == s.length()) return 1 ; 
     if(s.charAt(idx)-'0'==0) return  0  ; 
     int oneways = numDecodings(idx + 1, s) ; 
     int twoways = 0  ; 
     if(idx+1<s.length()){
        int twodigit = 10*(s.charAt(idx)-'0') + s.charAt(idx+1)-'0' ;
        if(twodigit<=26) {
            twoways =  numDecodings( idx + 2 , s) ;
        }
     }
     return twoways + oneways ; 
    }
    //Decode Ways in memoization
    public static int numDecodingsM(int idx , String s , int[]dp){
        if(idx==s.length()) return dp[idx] = 1  ; 
        if(s.charAt(idx)-'0'==0)return dp[idx] = 0 ; 
        if(dp[idx]!=-1) return dp[idx] ; 
        int oneways = numDecodingsM(idx+1, s , dp) ; 
        int twoways =  0 ; 
        if(idx+1<s.length()){
            int twodigitnumber = 10*(s.charAt(idx)-'0') + s.charAt(idx+1) - '0' ; 
            if(twodigitnumber <= 26){
                twoways = numDecodingsM(idx+2, s, dp) ; 
            }
        }
        return dp[idx] = oneways + twoways ; 
    }
    //Decode ways in tabulation form 
    public static int numDecodingsT(String s ,  int[]dp){
        for(int idx = s.length() ; idx>=0 ; idx--){
            if(idx==s.length()){
                dp[idx] = 1 ; 
                continue ; 
            }
            if(s.charAt(idx)-'0'==0){
                dp[idx]=0  ; 
                continue  ; 
            } 
            int oneways = dp[idx+1] ; 
            int twoways = 0  ; 
            if(idx+1<s.length()){
                int twodigit = 10*(s.charAt(idx)-'0') + s.charAt(idx+1) - '0' ; 
                if(twodigit<=26){
                     twoways = dp[idx+2] ; 
                }

            }
            dp[idx] = oneways + twoways ; 
            
        }
        return dp[0] ; 
    }
    public static void main(String[] args) {
        int[]dp = new int[4] ; 
        Arrays.fill(dp,-1) ; 
        System.out.println(numDecodingsT("123",dp)) ; 
    }
}
