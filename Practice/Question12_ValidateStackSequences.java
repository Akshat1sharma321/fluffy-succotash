import java.util.Stack;
public class Question12_ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int i = 0, j = 0;
        Stack<Integer> st = new Stack<>();
        while (i < n) {
            st.push(pushed[i++]);
            while (j < n && st.size() > 0 && popped[j] == st.peek()) {
                st.pop();
                j++;
            }
        }
        return st.size() == 0 ? true : false;
    }
}
