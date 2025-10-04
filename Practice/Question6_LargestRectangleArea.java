import java.util.Stack;
public class Question6_LargestRectangleArea {
    public int[] nextSmallerElem(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 0 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.size() != 0)
                nse[i] = st.peek();
            else
                nse[i] = n;
            st.push(i);
        }
        return nse;
    }

    public int[] prevSmallerElem(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (st.size() > 0 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.size() != 0)
                pse[i] = st.peek();
            else
                pse[i] = -1;
            st.push(i);
        }
        return pse;
    }

    public int largestRectangleArea(int[] heights) {
        int[] pse = prevSmallerElem(heights);
        int[] nse = nextSmallerElem(heights);
        int maxar = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            maxar = Math.max((nse[i] - pse[i] - 1) * heights[i], maxar);
        }
        return maxar;
    }
}
