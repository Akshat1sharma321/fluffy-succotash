import java.util.Stack;
public class Question11_NextGreaterElementInCircular {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (st.size() > 0 && nums[st.peek()] <= nums[i % n]) {
                st.pop();
            }
            ans[i % n] = st.size() == 0 ? -1 : nums[st.peek()];
            st.push(i % n);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
