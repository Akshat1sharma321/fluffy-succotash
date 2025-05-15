import java.util.*;

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
        int  [] arr= {1,3,-1,-3,5,3,6,7} ; 
        int []ans = nge(arr) ; 
        for(int i : ans){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] ans2 = nse2(arr);
        for (int i : ans2) {
            System.out.print(i + " ");
        }
        
    }
}
