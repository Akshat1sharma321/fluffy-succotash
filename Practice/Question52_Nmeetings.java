import java.util.Arrays;
import java.util.Comparator;

public class Question52_Nmeetings {
    public static int maxMeetings(int start[], int end[]) {
        int n = start.length ; 
        int  [][] len = new int[n][2] ; 
        for(int i  = 1 ; i <= n ; i++){
            len[i-1][0] = start[i-1] ; 
            len[i-1][1] = end[i-1] ; 
        }
        Arrays.sort(len, new Comparator<int[]>(){
            @Override 
            public int compare(int[]arr1 , int[]arr2){
                return Integer.compare(arr1[1],arr2[1]) ; 
            }
        }) ; 
        int cnt  = 1 ; 
        int freetime  = len[0][1]; 
        for(int i  = 0 ; i < start.length ; i++ ){
            if(len[i][0] > freetime){
                cnt++ ; 
                freetime  = len[i][1] ; 
            }
        }
        return cnt ; 
    }
    public static void main(String [] args){
        int [] start = {1, 3, 0, 5, 8, 5} ; 
        int [] end = { 2, 4, 6, 7, 9, 9} ; 
        System.out.println(maxMeetings(start, end)) ; 
    }
}
