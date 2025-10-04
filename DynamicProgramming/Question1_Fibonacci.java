import java.util.Arrays; 
public class Question1_Fibonacci {
   //Recursion Method of Fibonacci 
   public static int fibRec(int n){
   if(n<=1)return n ; 
   int oneback  = fibRec(n-1) ; 
   int twoback = fibRec(n-2) ; 
   return oneback + twoback ; 
   }
   //Memoization Method of Fibonacci
   public static int fibTab(int n , int []dp) {
      if (n <= 1)
         return dp[n]=n;
      if(dp[n]!=-1)return dp[n] ; 
      int oneback = fibTab(n - 1,dp);
      int twoback = fibTab(n - 2,dp);
      return dp[n] =  oneback + twoback;
   } 
   //Tabulation of Fibonacci
   public static int fibMem(int n , int[]dp) {
      for(int  i =  0 ; i <= n ; i++){
         if(i<=1){
            dp[i]=i ; 
            continue ; 
         }
         int oneback = dp[i-1];
         int twoback = dp[i-2];
         dp[i] = oneback + twoback ; 
      }
      return dp[n] ; 
   }
   //Tabulation better
   public static int fibMem(int n) {
     int a  =  0 ; 
     int b = 1 ; 
     for(int i = 2 ; i <= n  ; i++){
      int c = a + b ; 
      a = b ; 
      b = c ; 
     }
     return b  ;
   }
   public static void main(String[]args){
      int[]dp = new int[6] ; 
      Arrays.fill(dp,-1) ; 
   System.out.println(fibRec(5));
   } 
}
