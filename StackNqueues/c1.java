import java.util.Stack;
import java.util.ArrayList;
// import java.util.* ; 
class twoStacks {
    int[] arr;
    int size = 200;
    int tos1;
    int tos2;

    twoStacks() {
        arr = new int[size];
        tos1 = -1;
        tos2 = size;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        // code here
        if(tos1+1 == tos2){
            System.out.println("Overflow") ;
        }
        tos1+=1 ; 
        arr[tos1]=x ; 
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        if(tos2-1 == tos1){
            System.out.println("Overflow") ;
        }
        tos2-=1 ; 
        arr[tos2]=x ;
        // code here
    }

    // Function to remove an element from top of the stack1.

    int pop1() {
        if (tos1 == -1) {
            return -1;
        }
        int pop = arr[tos1];
        tos1 -= 1;
        return pop;
        // code here
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        if (tos2 == size) {
            return -1;
        }
        int pop = arr[tos2];
        tos2 += 1;
        return pop;
        // code here
    }

}
public class c1 {

    class Solution {
        public ArrayList<Integer> calculateSpan(int[] arr) {
            ArrayList<Integer> ans = new ArrayList<>();

            Stack<Integer> st = new Stack<>();
            st.push(-1);

            for (int i = 0; i < arr.length; i++) {
                while (st.peek() != -1 && arr[st.peek()] <= arr[i]) {
                    st.pop();

                    ans.add(i - st.peek());

                    st.push(i);
                }
            }
            return ans;

        }
    }
    public static int cal(int a , int b , char c){
        if(c=='+'){
            return a + b ; 
        }
        else if(c=='-'){
            return a - b ; 
        }
        else if(c=='*'){
            return a * b ;
        }
        else{
            return a / b ;
        }
    }
    public static void preEva(String S){
        Stack<String>OperandsIn = new Stack<>();
        Stack<String>OperandsPo = new Stack<>() ; 
        Stack<Integer>cal = new Stack<>() ; 
        int n = S.length() ; 
        for(int i = n -1  ; i >= 0 ; i--){
            if(S.charAt(i)>='0' && S.charAt(i)<='9'){
                OperandsIn.push(S.charAt(i)+"") ; 
                OperandsPo.push(S.charAt(i) + "");
                cal.push(S.charAt(i)-'0');
            }
            else{
                String one = OperandsIn.peek() ; 
                OperandsIn.pop() ; 
                String two = OperandsIn.peek();
                OperandsIn.pop();
                String ans1 = "(" + one + S.charAt(i) + two +")" ; 
                OperandsIn.push(ans1) ;

                String onep = OperandsPo.peek();
                OperandsPo.pop();
                String twop = OperandsPo.peek();
                OperandsPo.pop();
                String ans2 = onep + twop + S.charAt(i)  ;
                OperandsPo.push(ans2) ; 

                int onec = cal.peek();
                cal.pop();
                int twoc = cal.peek();
                cal.pop();
                int ans3 = cal(onec , twoc ,S.charAt(i)) ; 
                cal.push(ans3) ; 
            }
        }
        System.out.println(cal.peek());
        System.out.println(OperandsIn.peek());
        System.out.println(OperandsPo.peek());
    }
    public static boolean isDup(String letter) {
        Stack<Character> st = new Stack<>();
        int n = letter.length();
        for (int i = 0; i < n; i++) {
            if (letter.charAt(i) != ')') {
                st.push(letter.charAt(i));
            } else {

                if (st.peek() == '(')
                    return true;
                while (st.peek() != '(') {
                    st.pop();
                }
                st.pop();
            }
        }
        return false;
    }
    public static int [] nge(int[]arr){
        Stack<Integer>st =new Stack<>() ; 
        int [] nge = new int[arr.length] ; 
        st.push(-1) ; 
        for(int i = 0 ; i < arr.length ; i++){
            while(st.peek()!=-1 && arr[st.peek()]<arr[i]){
                nge[st.peek()] = i ; 
                st.pop() ; 
            }
            st.push(i) ; 
        }
        while(st.peek()!=-1){
            nge[st.peek()]=8 ; 
            st.pop() ; 
        }
        return nge ; 
    }
    
    public static int[] nse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        st.push(-1);
        for (int i = 0; i < arr.length; i++) {
            while (st.peek() != -1 && arr[st.peek()] > arr[i]) {
                nge[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while (st.peek() != -1) {
            nge[st.peek()] = -1;
            st.pop();
        }
        return nge;
    }
    
    public static int[] nse2(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        st.push(-1);
        for (int i = arr.length - 1; i >= 0 ; i--) {
            while (st.peek() != -1 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.peek() == -1) {
                nge[i] = arr.length;
            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }
        return nge;
    }
    public static int[] pse(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        st.push(-1);
        for (int i = 0; i < arr.length; i++) {
            while (st.peek() != -1 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if(st.peek()==-1){
                nge[i] = -1 ; 
            }
            else{
                nge[i]=st.peek() ; 
            }
            st.push(i) ; 
        }
        return nge;
    }
    public static void main(String[] args) {

        // System.out.println("((a+b))");
        // String a = "((a+b))";
        // System.out.println(isDup(a));
        // int  [] arr= {1,3,-1,-3,5,3,6,7} ; 
        // int []ans = nge(arr) ; 
        // for(int i : ans){
        //     System.out.print(i+" ");
        // }
        // System.out.println();
        // int[] ans2 = nse2(arr);
        // for (int i : ans2) {
        //     System.out.print(i + " ");
        // }
        String s = "-+7*45+20" ; 
        preEva( s);
    }
}
