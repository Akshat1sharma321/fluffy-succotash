import java.util.Stack;
public class Question2_ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (st.size() == 0 || st.peek() == '{' || st.peek() == '[') {
                    return false;
                } else
                    st.pop();
            } else if (ch == ']') {
                if (st.size() == 0 || st.peek() == '(' || st.peek() == '{') {
                    return false;
                } else
                    st.pop();
            } else if (ch == '}') {
                if (st.size() == 0 || st.peek() == '[' || st.peek() == '(') {
                    return false;
                } else
                    st.pop();
            } else {
                st.push(ch);
            }
        }
        return st.size() == 0;
    }
}
