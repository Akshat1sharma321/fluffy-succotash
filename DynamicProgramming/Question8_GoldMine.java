import java.util.Arrays;

public class Question8_GoldMine {
    // Recursion method of goldmine
    public static int maxGold(int row, int col, int n, int m, int[][] mat) {
        if (col == m - 1) {
            return mat[row][col];
        }
        int maxi = Integer.MIN_VALUE;
        if (row - 1 >= 0) {
            maxi = Math.max(maxi, maxGold(row - 1, col + 1, n, m, mat));
        }
        maxi = Math.max(maxi, maxGold(row, col + 1, n, m, mat));
        if (row + 1 < n) {
            maxi = Math.max(maxi, maxGold(row + 1, col + 1, n, m, mat));
        }

        return maxi + mat[row][col];
    }

    // Memoization method of goldmine
    public static int maxGoldM(int row, int col, int n, int m, int[][] mat, int[][] dp) {
        if (col == m - 1) {
            return dp[row][col] = mat[row][col];
        }
        int maxi = Integer.MIN_VALUE;
        if (dp[row][col] != -1)
            return dp[row][col];
        if (row - 1 >= 0) {
            maxi = Math.max(maxi, maxGoldM(row - 1, col + 1, n, m, mat, dp));
        }
        maxi = Math.max(maxi, maxGoldM(row, col + 1, n, m, mat, dp));
        if (row + 1 < n) {
            maxi = Math.max(maxi, maxGoldM(row + 1, col + 1, n, m, mat, dp));
        }

        return dp[row][col] = maxi + mat[row][col];
    }

    // Tabulation methos of goldmine
    public static int maxGoldT(int n, int m, int[][] mat, int[][] dp) {
        for (int col = m - 1; col >= 0; col--) {
            for (int row = n - 1; row >= 0; row--) {
                if (col == m - 1) {
                    dp[row][col] = mat[row][col];
                    continue;
                }
                int maxi = Integer.MIN_VALUE;
                if (row - 1 >= 0) {
                    maxi = Math.max(maxi, dp[row - 1][col + 1]);
                }
                maxi = Math.max(maxi, dp[row][col + 1]);
                if (row + 1 < n) {
                    maxi = Math.max(maxi, dp[row + 1][col + 1]);
                }
                dp[row][col]= maxi + mat[row][col] ; 
            }

        }
        int maxim = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxim = Math.max(maxim, dp[i][0]);
        }
        return maxim ;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 3, 3 }, { 2, 1, 4 }, { 0, 6, 4 } };
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        System.out.println(maxGoldT(n,m,mat,dp));
    }
}
