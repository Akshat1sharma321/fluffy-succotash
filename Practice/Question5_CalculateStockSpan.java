import java.util.ArrayList;
import java.util.Stack;
public class Question5_CalculateStockSpan {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length ; 
        int [] ans = new int[n] ; 
        Stack<Integer> st = new Stack<>() ; 
        for(int i = 0 ; i < n ; i++){
            while(st.size() > 0 && arr[st.peek()] <= arr[i]){
                st.pop() ; 
            }
            if(st.size()!=0)ans[i] = st.peek(); 
            else ans[i] = -1 ; 
            st.push(i) ; 
        }
        ArrayList<Integer>an = new ArrayList<>() ; 
        for(int i = 0 ; i < n ; i++){
            an.add(i - ans[i]) ; 
        }
        return an  ; 
    }
}
