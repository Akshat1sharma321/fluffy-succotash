public class Question48_BestTimetobuy {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp0 = new int[n];
        int[] dp1 = new int[n];
        dp0[0] = 0;
        dp1[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp0[i] = Math.max(dp0[i - 1], dp1[i - 1] + prices[i]);
            dp1[i] = Math.max(dp1[i - 1], -prices[i]);
        }
        return dp0[n - 1];
    }
}
