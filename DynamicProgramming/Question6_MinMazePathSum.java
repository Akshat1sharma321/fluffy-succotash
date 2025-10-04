import java.util.Arrays;
public class Question6_MinMazePathSum {
    public static int minSum(int r  , int c , int n , int m , int[][]dp  , int[][]grid , String[][]sdp){
        if(r == n -1 && c == m -1){
            sdp[r][c] = "" + grid[r][c]; 
            return dp[r][c] = grid[r][c] ; 
        }
        int rways = Integer.MAX_VALUE ;
        int dways = Integer.MAX_VALUE; 
        if(r +1 < n){
            rways =  minSum(r+1, c, n, m, dp, grid , sdp) ; 
        }
        if(c + 1 < m ){
            dways = minSum(r, c + 1, n, m, dp, grid , sdp) ;
        }
        sdp[r][c] =  grid[r][c] + " , " +  Math.min(rways,dways) ; 
         return dp[r][c] = Math.min(rways , dways) + grid[r][c]; 
    }
    public static void main(String[]args){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}} ;
        int[][]dp = new int[3][3] ; 
        String[][]sdp = new String[3][3];
        for(int[]row : dp){
            Arrays.fill(row ,-1) ; 
        }
        System.out.println("Minimum path sum of the maze  is : " + minSum(0 , 0 , 3 , 3 , dp , grid , sdp));
        System.out.println("The min path of traversal is :" + sdp[0][0]);

    }
}
