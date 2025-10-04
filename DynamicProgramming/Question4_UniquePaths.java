import java.util.Arrays;
public class Question4_UniquePaths {
    //Unique Paths Recursion
    public static int Upr(int row ,  int col , int n , int m ){
        if(row == n-1 && col == m -1 ) return 1 ; 
        int tot  = 0 ; 
        if(col+1<m){
            tot+= Upr(row, col+1, n, m) ; 
        } 
        if(row+1<n){
            tot+=Upr(row+1, col, n, m)  ;
        }
        if(col+1<m && row+1<n){
           tot+= Upr(row+1, col+1, n, m) ;
        }
        
        return tot ; 
    }
    
    // Unique Paths Memoization
    public static int UprM(int row, int col, int n, int m,int[][]dp) {
        if (row == n - 1 && col == m - 1)
        return dp[row][col]=1 ; 
        int tot = 0;
        if(dp[row][col]!=-1)return dp[row][col] ; 
        if (col + 1 < m) {
            tot += UprM(row, col + 1, n, m,dp);
        }
        if (row + 1 < n) {
            tot += UprM(row + 1, col, n, m , dp);
        }
        if (col + 1 < m && row + 1 < n) {
            tot += UprM(row + 1, col + 1, n, m ,dp);
        }

        return dp[row][col] = tot;
    }

    // Unique Paths Tabulation
    public static int UprT(int n, int m, int[][] dp) {
        for(int row = n  - 1 ; row >=0 ; row--){
            for(int col = m  -1 ; col >= 0 ; col--){
                if (row == n - 1 && col == m - 1){
                     dp[row][col] = 1;
                     continue ; 
                }   
                int tot = 0;
                if (col + 1 < m) {
                    tot += dp[row][col+1];
                }
                if (row + 1 < n) {
                    tot += dp[row+1][col];
                }
                if (col + 1 < m && row + 1 < n) {
                    tot += dp[row+1][col+1];
                }
                dp[row][col]=tot ; 
            }
        }
        

        return dp[0][0] ;
    }
    public static void main(String[]args){
        int[][]dp = new int[2][3] ; 
        for(int[]row : dp){
            Arrays.fill(row,-1) ; 
        }
        System.out.println(UprT(2,3,dp));
    }
}
