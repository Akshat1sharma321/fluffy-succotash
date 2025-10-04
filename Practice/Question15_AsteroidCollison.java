import java.util.Stack;
public class Question15_AsteroidCollison {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int power = asteroids[i];
            if (power >= 0) {
                st.push(power);
            } else {
                int in = 1;
                while (st.size() > 0 && st.peek() > 0) {
                    if (st.peek() < -power) {
                        st.pop();
                        in = 1;
                    } else if (st.peek() == -power) {
                        st.pop();
                        in = 0;
                        break;
                    } else {
                        in = 0;
                        break;
                    }
                }
                if (in == 1)
                    st.push(power);
            }
        }
        int[] ans = new int[st.size()];
        int i = st.size() - 1;
        while (st.size() != 0) {
            ans[i--] = st.pop();
        }
        return ans;
    }
}
