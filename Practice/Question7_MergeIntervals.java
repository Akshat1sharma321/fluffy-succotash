import java.util.Arrays;
import java.util.Stack;
class Pair {
    int a;
    int b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
};
public class Question7_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (int[]a , int[]b) ->{
            if(a[0]!=b[0]) return a[0] - b[0] ; 
            return a[1] - b[1] ; 
        });
        Stack<Pair>st = new Stack<>() ; 
        int n  = intervals.length ; 
        Pair[]intervalPair = new Pair[n]; 
        for(int i  = 0  ; i < n ; i++){
            intervalPair[i] = new Pair(intervals[i][0] , intervals[i][1]) ; 
        }
        for(int i = 0 ; i < n ; i ++){
            Pair inter = intervalPair[i] ; 
            while(st.size()> 0 && st.peek().b >= inter.a){
                Pair tp = st.pop() ; 
                inter.a = tp.a ; 
               inter.b =  Math.max(tp.b, inter.b); 
            }
            st.push(inter) ; 
        }
        int ni  = st.size() ; 
        int[][] ans = new int[ni][2] ;  
        for(int i = 0 ; i < ni ; i++){
            Pair in = st.pop() ; 
            ans[i][0] = in.a ; 
            ans[i][1] = in.b ; 
        }
        return ans ; 
    }
}
