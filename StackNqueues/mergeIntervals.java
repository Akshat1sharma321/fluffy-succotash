import java.util.Stack;
import java.util.Arrays;

public class mergeIntervals {
    static class pair {
        int startTime;
        int endTime;

        pair(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        Stack<pair> st = new Stack<pair>();
        int n = intervals.length;
        pair[] intervalPair = new pair[n] ;
        
        for (int i = 0; i < n; i++) {
            intervalPair[i] = new pair(intervals[i][0], intervals[i][1]) ; 
        }

        for(int i = 0 ; i < n ; i++){
            pair current = intervalPair[i] ; 
            while(st.size()>0 &&  st.peek().endTime > current.startTime && st.peek().startTime < current.startTime){
                current.startTime = st.peek().startTime ;
                st.pop() ;
            }
            st.push(current) ; 
        }

        int[][]ans = new int[st.size()][2] ; 
        for(int i = 0 ; i <ans.length ; i++){
            ans[i][0] = st.peek().startTime ; 
            ans[i][1] = st.peek().endTime ; 
            st.pop() ; 
        }
        return ans ; 
    }

    public static void main(String[] args) {
        // [[1,3],[2,6],[8,10],[15,18]]
        int [][]v ={{1,3},{2,6},{8,10},{15,18}} ;
        int[][]ans = merge(v) ;
        for(int i = 0  ; i < ans.length ; i++){
             System.out.print("[" + ans[i][0]+","+ans[i][1] + "]");
        }
       
    }
}
