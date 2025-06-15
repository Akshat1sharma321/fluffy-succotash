
 class Stack {
    int[] arr;
    int top;
    int maxi = 4;

    public Stack() {
        top = -1;
        arr = new int[maxi];
    }

    public void push(int value) {
        if (top + 1 == arr.length) {
            int[] newarr = new int[2 * arr.length];
            System.out.println("Creating new stack");
            for (int i = 0; i < arr.length; i++) {
                newarr[i] = arr[i];
            }
            arr = newarr;
        }
        top += 1;
        arr[top] = value;
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        int popped = arr[top];
        top -= 1;
        return popped;
    }

    public int size() {
        if (top == -1) {
            return 0;
        }
        return top + 1;
    }

    public int peek() {
        if (top == -1) {
            return -1;
        }
        return arr[top];
    }
}

public class stackimple {
 

    public static void main(String[] args) {
        System.out.println("hello");
        Stack st = new Stack();

        st.push(2);
        st.push(23);
        st.push(23);
        st.push(2123);
        st.push(2321);
        st.push(2323);
        st.push(223);
        st.push(13);
        st.push(123);
        st.push(2113);

        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.size());
    }
}
