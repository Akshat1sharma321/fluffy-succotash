import java.util.ArrayList;
import java.util.Arrays;

public class Question8_MergeIntervalsOptimised {
     public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (int[]a , int[]b) ->{
            if(a[0]!=b[0]) return a[0] - b[0] ; 
            return a[1] - b[1] ; 
        });
        ArrayList<int[]>ans  = new ArrayList<>() ; 
        for(int i  = 0 ; i < intervals.length ; i++){
            if(ans.size()==0 || ans.get(ans.size()-1)[1] < intervals[i][0]){
                int []temp = {intervals[i][0] , intervals[i][1]} ; 
                ans.add(temp) ; 
            }
            else{
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size()-1)[1] , intervals[i][1]) ; 
            }
        }
        return ans.toArray(new int[ans.size()][]) ; 
    }
}
