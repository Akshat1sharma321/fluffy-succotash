public class Question17_KnapsackUnbound {
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int[] dp = new int[capacity + 1];
        for (int cap = 0; cap <= capacity; cap++) {
            for (int i = 0; i < val.length; i++) {
                if (cap - wt[i] >= 0) {
                    dp[cap] = Math.max(val[i] + dp[cap - wt[i]], dp[cap]);
                }
            }
        }
        return dp[capacity];
    }
}
