import java.util.ArrayList;
import java.util.Stack;
public class Question3_NextGreaterElement {
     public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n  = arr.length ; 
        Stack<Integer>st = new Stack<>() ; 
        int [] ans = new int[n] ; 
        for(int i = n - 1  ;i >= 0 ; i--){
            
            while(st.size()>0 && st.peek() <= arr[i]){
                st.pop() ; 
            }
            if(st.size()!=0) ans[i] = st.peek() ; 
            else ans[i] = -1 ; 
            st.push(arr[i]) ; 
        }
       ArrayList<Integer>ar = new ArrayList<>() ; 
       for(int i : ans){
           ar.add(i) ; 
       }
       return ar ; 
    }
}

