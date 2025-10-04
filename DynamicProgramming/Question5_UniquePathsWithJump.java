import java.util.Arrays;
public class Question5_UniquePathsWithJump {
    public static int cnt = 0 ; 
    public static int cnt1 = 0;
    public static int cnt2 = 0;
    //Recursive solution with tc  = 3 power n+m
    public static int upw(int r , int c  , int n , int m ){
        if(r == n - 1 && c == m -1) return 1 ; 
        int tways = 0 ; 
        for(int i = 1 ; i < n - r ; i++){
            tways += upw(r + i , c , n ,  m) ; 
            cnt++;
        }
        for (int i = 1; i <  m - c; i++) {
            tways += upw(r , c + i, n, m);
            cnt++ ;
        }
        for (int i = 1; i < Math.min((n-r),(m-c)); i++) {
            tways += upw(r + i, c+i, n, m);
            cnt++;
        }
        return tways ; 
    }

    //Memoized solution
    public static int upwm(int r, int c, int n, int m , int[][]dp) {
        if (r == n - 1 && c == m - 1){
             return dp[r][c] =  1  ;
        }
        if(dp[r][c]!=-1)return dp[r][c] ;    
        int tways = 0;
        for (int i = 1; i < n - r; i++) {
            tways += upw(r + i, c, n, m);
            cnt1++;
        }
        for (int i = 1; i < m - c; i++) {
            tways += upw(r, c + i, n, m);
            cnt1++;
        }
        for (int i = 1; i < Math.min((n - r), (m - c)); i++) {
            tways += upw(r + i, c + i, n, m);
            cnt1++;
        }
        return dp[r][c] = tways;
    }
    //Tabulation solution
    public static int upwt( int n, int m, int[][] dp) {
        for(int r  =  n - 1 ; r >= 0 ; r--){
            for(int c = m - 1 ; c >= 0 ; c--){
                if (r == n - 1 && c == m - 1) {
                    dp[r][c] = 1;
                    continue ; 
                }
                int tways = 0;
                for (int i = 1; i < n - r; i++) {
                    tways += dp[r+i][c];
                    cnt2++;
                }
                for (int i = 1; i < m - c; i++) {
                    tways += dp[r][c+i];
                    cnt2++;
                }
                for (int i = 1; i < Math.min((n - r), (m - c)); i++) {
                    tways += dp[r+i][c+i];
                    cnt2++;
                }
               dp[r][c] = tways;
            }
        }
        return dp[0][0]; 
    }
    public static void main(String[]args){
        int n = 2 ; 
        int m  = 3 ; 
        int [][]dp = new int[n][m] ; 
        for(int[]rows : dp){
            Arrays.fill(rows,-1);
        }
        System.out.println("total number of eays to reach the end are :" + upwt(n,m,dp));
        System.out.println("Number of steps that are required are : " + cnt2);
    }
}
