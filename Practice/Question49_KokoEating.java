import java.util.Arrays;

public class Question49_KokoEating {
    public boolean possible(int speed , int [] piles , int h){
        long time = 0  ; 
        for(int i = 0  ; i < piles.length ; i++){
            if(speed >= piles[i])time += 1 ;
            else time += (piles[i] + speed - 1)/speed ; 
        }
        return time <= h ? true : false ; 
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n  = piles.length ; 
        Arrays.sort(piles) ; 
        int maxim = piles[n-1] ; 
        int start = 1 ; 
        int end = maxim  ; 
        int k = maxim ; 
        while(start <= end){
            int mid =( start - (start - end)/2);
            if(possible(mid , piles ,h)){
                k = mid ; 
                end = mid - 1 ; 
            }
            else{
                start = mid + 1 ; 
            }
        }
        return  k ; 
    }
}
