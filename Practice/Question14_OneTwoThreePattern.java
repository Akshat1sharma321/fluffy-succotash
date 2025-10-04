import java.util.Stack;
public class Question14_OneTwoThreePattern {
    //Brute Force
    public boolean find132patternBf(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] < nums[k] && nums[i] < nums[j] && nums[j] > nums[k])
                        return true;
                }
            }
        }
        return false;
    }
    //Optimised to n2 
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] minSofar = new int[n];
        minSofar[0] = nums[0];
        for (int i = 1; i < n; i++) {
            minSofar[i] = Math.min(nums[i], minSofar[i - 1]);
        }
        st.push(nums[n - 1]);
        for (int j = n - 2; j >= 0; j--) {
            while (st.size() > 0 && (minSofar[j] >= st.peek())) {
                st.pop();
            }
            if (st.size() != 0 && st.peek() < nums[j]) {
                return true;
            }
            st.push(nums[j]);
        }
        return false;
    }
}
