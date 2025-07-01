package basics;
public class class15 {
    public static void diag(int [][] mat){
        int n  =  mat.length ; 
        int m = mat[0].length ; 
        int row = 0 , col = 0 ;
        while(row<n && row>=0 &&  col<m && col>=0){
            int rt = row , ct = col ;
            while(rt<n && ct<m){
                System.out.print(mat[rt][ct]);
                rt++;
                ct++;
            }
            System.out.println();
            col++;
        }
    }
    public static void toggle(String s){
        int n = s.length() ; 
        String ans = "" ; 
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i)<='z' && s.charAt(i)>='a') ans+=s.charAt(i).toUpperCase() ;
        }
    }
    public static void main(String[] args) {
        int [][] mat = {
            {1,2,3,4},
            {1,2,3,4},
            {1,2,3,4},
            {1,2,3,4}
        };
        diag(mat);
    }
}
