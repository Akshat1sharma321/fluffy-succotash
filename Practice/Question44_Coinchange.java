public class Question44_Coinchange {
    public int cc(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i == 0) {
                dp[i] = 0;
                continue;
            }
            int tot = (int) (1e8);
            for (int coin : coins) {
                if (i - coin >= 0) {

                    tot = Math.min(dp[i - coin] + 1, tot);
                }
            }
            dp[i] = tot;
        }
        return dp[amount] == (int) (1e8) ? -1 : dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        return cc(coins, amount);
    }
}
