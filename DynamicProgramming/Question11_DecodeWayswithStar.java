import java.util.*;

public class Question11_DecodeWayswithStar {
    // Leetcode decode ways 2 by recursion
    public static int decWays(String s, int idx, int[] dp) {
        if (idx == s.length()) {
            return 1;
        }
        if (s.charAt(idx) - '0' == 0) {
            return 0;
        }
        int oneways = decWays(s, idx + 1, dp);
        oneways = s.charAt(idx) == '*' ? 9 * oneways : oneways;
        int twoways = 0;

        if (idx + 1 < s.length()) {
            if ((s.charAt(idx + 1) == '*') && (s.charAt(idx) == '*')) {
                twoways = 15 * decWays(s, idx + 2, dp);
            } else if (s.charAt(idx) == '*') {
                if (s.charAt(idx + 1) - '0' <= 6) {
                    twoways = 2 * decWays(s, idx + 2, dp);
                }

                else {
                    twoways = decWays(s, idx + 2, dp);
                }
            } else if (s.charAt(idx + 1) == '*') {
                if (s.charAt(idx) - '0' == 1) {
                    twoways = 9 * decWays(s, idx + 2, dp);
                } else if (s.charAt(idx) - '0' == 2) {
                    twoways = 6 * decWays(s, idx + 2, dp);
                }
            } else {
                int twodigit = 10 * (s.charAt(idx) - '0') + s.charAt(idx + 1) - '0';
                if (twodigit <= 26) {
                    twoways = decWays(s, idx + 2, dp);
                }
            }

        }
        return oneways + twoways;
    }

    // Leetcode decodeways 2 by memoization
    public static int decWaysM(String s, int idx, int[] dp) {
        if (idx == s.length()) {
            return dp[idx] = 1;
        }
        if (s.charAt(idx) - '0' == 0) {
            return dp[idx] = 0;
        }
        if (dp[idx] != -1)
            return dp[idx];
        int oneways = s.charAt(idx) == '*' ? 9 * decWaysM(s, idx + 1, dp) : decWaysM(s, idx + 1, dp);
        int twoways = 0;
        if (idx + 1 < s.length()) {
            if (s.charAt(idx) == '*' && s.charAt(idx + 1) == '*') {
                twoways = 15 * decWaysM(s, idx + 2, dp);
            } else if (s.charAt(idx) == '*') {
                if (s.charAt(idx + 1) - '0' <= 6) {
                    twoways = 2 * decWaysM(s, idx + 2, dp);
                } else {
                    twoways = decWaysM(s, idx + 2, dp);
                }
            } else if (s.charAt(idx + 1) == '*') {
                if ((s.charAt(idx) - '0') == 1) {
                    twoways = 9 * decWaysM(s, idx + 2, dp);
                } else if ((s.charAt(idx) - '0') == 2) {
                    twoways = 6 * decWaysM(s, idx + 2, dp);
                }
            } else {
                int twodigitnumber = 10 * (s.charAt(idx) - '0') + (s.charAt(idx + 1) - '0');
                if (twodigitnumber <= 26) {
                    twoways = decWaysM(s, idx + 2, dp);
                }
            }
        }
        return dp[idx] = twoways + oneways;
    }

    // Leetcode decodeways2 by tabulation method
    public static int decWaysT(String s, int[] dp) {
        for (int idx = s.length(); idx >= 0; idx--) {
            if (idx == s.length()) {
                dp[idx] = 1;
                continue;
            }
            if (s.charAt(idx) - '0' == 0) {
                dp[idx] = 0;
                continue;
            }
            int totways = s.charAt(idx) == '*' ? 9 * dp[idx + 1] : dp[idx + 1];
            if (idx + 1 < s.length()) {
                if (s.charAt(idx) == '*' && s.charAt(idx + 1) == '*')
                    totways += 15 * dp[idx + 2];
                else if (s.charAt(idx) == '*') {
                    if (s.charAt(idx + 1) - '0' <= 6) {
                        totways += 2 * dp[idx + 2];
                    } else {
                        totways += dp[idx + 2];
                    }
                } else if (s.charAt(idx + 1) == '*') {
                    if ((s.charAt(idx) - '0') == 1) {
                        totways += 9 * dp[idx + 2];
                    } else if ((s.charAt(idx) - '0') == '2') {
                        totways += 6 * dp[idx + 2];
                    }
                } else {
                    int twodigit = (10 * (s.charAt(idx) - '0')) + (s.charAt(idx+1) - '0');
                    if (twodigit <= 26) {
                        totways += dp[idx + 2];
                    }
                }

            }
            dp[idx] = totways;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String s = "1**23*78";
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(decWaysT("1**23*78", dp));
    }
}
