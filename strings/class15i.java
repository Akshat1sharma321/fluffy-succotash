package strings;

import java.util.*;

public class class15i {
    public static void compress(String s){
        if(s.length()==0)System.out.println("Empty");
        String ans = "" ; 
        ans += s.charAt(0) ;
         int cnt  = 1 ;
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                ans+=cnt+"" ;
                cnt=1;
                ans+=s.charAt(i);
            }
            else cnt++ ;
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        System.out.println("Hello"); 
    Scanner scn = new Scanner(System.in) ; 
    String str = scn.next() ;
    compress(str);
    }
   
    
}
