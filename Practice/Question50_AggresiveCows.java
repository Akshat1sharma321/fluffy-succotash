import java.util.Arrays;

public class Question50_AggresiveCows {
    public boolean possible(int dis , int[] stalls, int k){
        int total = 1 ;
        int last = stalls[0]  ;
        for(int i =  0 ;  i < stalls.length ; i++){
        
            if(stalls[i] - last >= dis){
                total ++  ; 
                last = stalls[i] ; 
            }
            if(total >= k) return true ; 
        }
        return false ; 
    }
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls) ; 
        int n  = stalls.length  ;
        int high = stalls[n - 1] - stalls[0] ; 
        int low  = 1  ; 
        int  ki =  0 ; 
        while(low <= high){
            int mid = (high - (high - low)/2) ; 
            if(possible(mid , stalls, k)){
                ki = mid ; 
                low = mid + 1 ; 
            }
            else{
                high = mid - 1 ; 
            }
        }
        return  ki  ; 
        
    }
}
