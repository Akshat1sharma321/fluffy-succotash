import java.util.Arrays;

public class Question7_MinimumPathSum {
    //minimumpathsum recursion way 
    public static int mps(int row , int col , int n , int m , int[][]grid){
        if(row==n-1 && col==m-1){
            return grid[row][col] ; 
        }
        int mini = Integer.MAX_VALUE ; 
        if(col+1<m){
            mini = Math.min(mini,mps(row, col+1, n, m, grid)) ; 
        }
        if (row + 1 < n) {
            mini = Math.min(mini, mps(row + 1 , col , n, m, grid));
        }
        return mini + grid[row][col] ; 
    }
    //minimum path sum memoizattion way 
    public static int mpsM(int row , int col ,  int n , int m , int[][]dp , int [][] grid) {
        if(row == n - 1 && col == m - 1){
            return dp[row][col] = grid[row][col] ; 
        }
        if(dp[row][col]!=-1) return dp[row][col] ; 
        int mini = Integer.MAX_VALUE ; 
        if(row + 1 < n){
            mini = Math.min(mpsM(row + 1, col, n, m,dp, grid), mini) ;  
        }
        if(col + 1 < m){
            mini = Math.min(mpsM(row, col + 1, n, m, dp, grid),mini) ; 
        }
        return dp[row][col] = mini + grid[row][col]  ; 
    }
    
    // minimum path sum tabulation way
    public static int mpsT( int n, int m, int[][] dp, int[][] grid) {
        for(int row = n - 1 ; row >= 0 ; row--){
            for(int col = m - 1 ; col>= 0 ; col--){
                if (row == n - 1 && col == m - 1) {
                    dp[row][col] = grid[row][col];
                    continue ; 
                }
                int mini = Integer.MAX_VALUE;
                if (row + 1 < n) {
                    mini = Math.min(dp[row+1][col], mini);
                }
                if (col + 1 < m) {
                    mini = Math.min(dp[row][col+1], mini);
                }
                dp[row][col] = mini + grid[row][col]; 
            }
           
        }
        
        return dp[0][0];
    }
    public static void main(String[] args) {
        int[][]grid = {{1,3,1},{1,5,1},{4,2,1}} ;
        int[][]dp = new int [3][3] ; 
        for(int[]row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(mpsT( 3, 3, dp , grid));
    }
}
