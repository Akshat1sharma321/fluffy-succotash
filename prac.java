import java.util.*;
public class prac {
    public static void pat1(int n){
        int totl = n ; 
        int currl = 1 ; 
        int star = n ;
        int spaces = 1 ;
        while(currl<=totl){
            for(int i = 0 ; i < star ; i++){
                System.out.print("* ");
            }
            for(int i = 0 ; i < spaces ; i++){
                System.out.print("  ");
            }
            for(int i = 0 ; i < star ; i++){
                System.out.print("* ");
            }
            System.out.println();
            if(currl<=n/2){
                star-=1;
            
            spaces+=2;
            }
            else{
                star++;
                spaces-=2;

            }
            
            currl++;
        }
    }
    public static void pat2(int n ){
        int ins = -1 ; 
        int os = n/2 ; 
        for(int i = 0 ; i < n  ; i++){
            for(int k = 0 ; k < os ; k++){
                System.out.print("  ");
            }
            System.out.print("* ");
            for(int j = 0 ; j < ins ; j++){
                System.out.print("  ");
            }
            if(i>0 && i < n-1){
                System.out.print("* ");
            }
            System.out.println();
            if(i<n/2){
                os--;
                ins+=2;
            }
            else{
                os++;
                ins-=2;
            }
        }
    }
    public static void pat3(int n ){
        int a = 0 , b = 1 ;
        for(int i = 0 ; i < n  ; i++){
            for(int j = 0 ; j <= i ; j++){
                System.out.print(a+" ");
                int  c = a+b;
            a=b;
            b=c;

            }
            System.out.println() ;
            
            
        }
    }
    public static void pat4(int n ){
        int totl = 2*n+1;
        int currl = 1  ;
        int spaces = n ;
        int star = 1 ; 
        while(currl<=totl){
            int cnt = currl ;
            for(int i = 0 ; i < spaces ; i++){
                System.out.print("  ");
            }
            for(int i = 0 ; i < star ; i++){
                System.out.print(cnt+" ");
                if(i<=n){
                  cnt++;  
                }
                else{
                    cnt--;
                }
                
            }
            System.out.println();
            if(currl<=n){
                star+=2 ; 
                spaces-- ;
            }
            else{
                star-=2 ; 
                spaces++;
            }
            currl++;

        }
    }
    public static void pat5(int n ){
    int spc = 2 * n - 3 ;
    int st  = 1  ;
    // int currl  = 1 ;
    for(int i = 0 ; i < n ; i++){
        int cnt  = 1  ; 
        for(int j = 0 ; j < st ; j++){
            System.out.print(cnt+" ");   
            cnt++;
        }
        for(int j = 0 ; j < spc ; j++){
            System.out.print("  ");
        }
        if(i==n-1){
            st--;
            cnt--;
        }
        for(int j = 0 ; j < st ; j++){
             cnt--;
            System.out.print(cnt+" ");
           
        }

        
          st++;  
        
        
        spc-=2;
        System.out.println();
        
    }
    
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pat5(n);
    }
}
