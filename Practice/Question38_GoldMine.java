public class Question38_GoldMine {
    public int findGold(int[][] mat, int row, int col) {
        int n = mat.length;
        int m = mat[0].length;
        if (col == m - 1) {
            return mat[row][col];
        }
        int maxGoldsurr = Integer.MIN_VALUE;
        if (row - 1 >= 0 && col + 1 < m) {
            maxGoldsurr = Math.max(maxGoldsurr, findGold(mat, row - 1, col + 1));
        }
        maxGoldsurr = Math.max(maxGoldsurr, findGold(mat, row, col + 1));
        if (row + 1 < n && col + 1 < m) {
            maxGoldsurr = Math.max(maxGoldsurr, findGold(mat, row + 1, col + 1));
        }
        return maxGoldsurr + mat[row][col];
    }

    public int maxGold(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        // code here
        int maxGold = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxGold = Math.max(maxGold, findGold(mat, i, 0));
        }
        return maxGold;
    }


    public int findGoldt(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        for (int col = m - 1; col >= 0; col--) {
            for (int row = n - 1; row >= 0; row--) {
                if (col == m - 1) {
                    dp[row][col] = mat[row][col];
                    continue;
                }
                int gold_adj = Integer.MIN_VALUE;
                if (row - 1 >= 0) {
                    gold_adj = dp[row - 1][col + 1];
                }

                gold_adj = Math.max(gold_adj, dp[row][col + 1]);
                if (row + 1 < n) {
                    gold_adj = Math.max(gold_adj, dp[row + 1][col + 1]);
                }

                dp[row][col] = gold_adj + mat[row][col];
            }
        }
        return dp[r][c];
    }

    public int maxGoldt(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        // code here
        int maxGold = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxGold = Math.max(maxGold, findGold(mat, i, 0));
        }
        return maxGold;
    }
}
