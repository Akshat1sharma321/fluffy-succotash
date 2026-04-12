import java.util.Arrays;
public class RoughWork {
    public static int findFac(int n , int [] mem){
        if(n == 1){
            return mem[1] = 1 ; 
        }
        if(mem[n]!=-1) return mem[n] ; 
        return mem[n] = n * findFac(n - 1 , mem) ; 
    }
    public static void toh(int n , int A , int C , int B ,int num ){
        num++ ; 
        if(n==0) return   ; 
        toh(n-1, A , B , C  , num) ; 
        System.out.println("Moving disc --> " + n + " from " + A + " to " + C + " Step --> " + num) ; 
        toh(n-1,B,C ,A , num ) ; 
    }
    public static void allSubs(String s , int ind , String asf){
        if(ind == s.length()){
            System.out.println("String is --> " + asf) ; 
            return   ; 
        }
        allSubs(s, ind + 1, asf + s.charAt(ind));
        allSubs(s, ind + 1, asf);
    }
    public static void main(String[]args){
        toh(3 , 10 , 30 , 20 , 0 ) ; 
        int [] arr = { 21 , 3 , 300 , 98 , 789} ;
        allSubs("abc" , 0 , "") ; 
    }
}
