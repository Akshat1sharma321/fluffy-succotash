import java.util.*;
public class class5pat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int totl = n ; 
        // int currl = 1 ; 
        // int star = n ; 
        // while(currl<=totl){
        //     for(int i = 0 ; i  < star ; i++){
        //         System.out.print("* /t");
        //     }
        //     System.out.println();
        //     currl++;
        //     star++;
        // }
        // int totl = n ; 
        // int currl = 1 ; 
        // int star = n ; 
        //   while(currl<=totl){
        //     for(int i = 0 ; i  < star ; i++){
        //         System.out.print("* \t");
        //     }
        //     System.out.println();
        //     currl++;
        //     star--;
        // }
        // int totl = n ; 
        // int currl = 1 ; 
        // int star = 1 ; 
        // int spaces= n -1 ;
        //   while(currl<=totl){
        //     for(int i = 0 ; i < spaces ; i++){
        //         System.out.print(" ");
        //     }
        //     for(int i = 0 ; i  < star ; i++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        //     spaces--;
        //     currl++;
        //     star++;
        // }
        // int totl = n ; 
        // int currl = 1 ; 
        // int star = n ; 
        // int spaces= 0 ;
        //   while(currl<=totl){
        //     for(int i = 0 ; i < spaces ; i++){
        //         System.out.print(" ");
        //     }
        //     for(int i = 0 ; i  < star ; i++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        //     spaces++;
        //     currl++;
        //     star--;
        // }
        int totl = 2*n - 1 ; 
        int currl = 1 ; 
        int star = 1 ; 
        int spaces= n;
          while(currl<=totl){
            while(star<=totl){
            for(int i = 0 ; i < spaces ; i++){
                System.out.print(" ");
            }
            for(int i = 0 ; i  < star ; i++){
                System.out.print("*");
            }
            System.out.println();
            spaces--;
            currl++;
            star+=2;
            }
            for(int i = 0 ; i < spaces ; i++){
                System.out.print(" ");
            }
            for(int i = 0 ; i  < star ; i++){
                System.out.print("*");
            }
            System.out.println();
            spaces++;
            currl++;
            star-=2;

            
        }
    }
}
