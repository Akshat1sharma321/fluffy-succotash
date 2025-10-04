public class Question13_ValidateStackOptimised {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        int n = pushed.length;
        for (int x : pushed) {
            pushed[i++] = x;
            while (j < n && i > 0 && pushed[i - 1] == popped[j]) {
                i--;
                j++;
            }
        }
        return j == n;
    }
}
