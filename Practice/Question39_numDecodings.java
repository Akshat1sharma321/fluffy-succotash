public class Question39_numDecodings {
    public int tot(int idxo, int n, String s) {
        int[] dp = new int[n + 1];
        for (int idx = s.length(); idx >= 0; idx--) {
            if (idx == s.length()) {
                dp[idx] = 1;
                continue;
            }
            if (s.charAt(idx) - '0' == 0) {
                dp[idx] = 0;
                continue;
            }
            int one = dp[idx + 1];
            if (idx + 1 < s.length()) {
                int two = 10 * (s.charAt(idx) - '0') + (s.charAt(idx + 1) - '0');
                if (two <= 26) {
                    one += dp[idx + 2];
                }
            }
            dp[idx] = one;
        }
        return dp[0];

    }

    public int numDecodings(String s) {
        int n = s.length();
        return tot(0, n, s);
    }
}
