import java.util.Stack;
public class Question4_NextSmallerElement {
    public int[] leftSmaller(int[] arr) {
        // code here
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (st.size() > 0 && st.peek() >= arr[i]) {
                st.pop();
            }
            if (st.size() != 0)
                ans[i] = st.peek();
            else
                ans[i] = -1;
            st.push(arr[i]);
        }
        return ans;
    }
}
