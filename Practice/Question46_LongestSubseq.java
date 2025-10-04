public class Question46_LongestSubseq {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int start = 0, end = gap; end < n; end++, start++) {
                if (gap == 0) {
                    dp[start][end] = 1;
                    continue;
                }
                if (gap == 1) {
                    if (s.charAt(start) == s.charAt(end)) {
                        dp[start][end] = 2;
                        continue;
                    }
                }
                int maxim = 1;
                if (s.charAt(start) == s.charAt(end)) {
                    maxim = 2 + dp[start + 1][end - 1];
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
                dp[start][end] = Math.max(maxim, dp[start][end]);
            }
        }
        return dp[0][n - 1];
    }

}
