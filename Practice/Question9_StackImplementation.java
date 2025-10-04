class Stack {
    int n = 10;
    int[] st = new int[n];
    int idx = -1;

    public void push(int num) {
        if (idx == n) {
            System.out.println("No Size Left");
        }
        idx++;
        st[idx] = num;
    }

    public int pop(){
        if(idx == -1){
            System.out.println("No more elemnet left") ; 
            return -1 ; 
        }
        int num = st[idx--]; 
        return num ; 
    }

    public int size(){
        return idx+1 ; 
    }

    public int peek(){
        if(idx == -1){
            System.out.println("No Element") ; 
            return -1 ; 
        }
        return st[idx] ; 
    }
};

public class Question9_StackImplementation {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(10);
       System.out.println( st.pop()) ; 
    }
}
