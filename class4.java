import java.util.*;
public class class4{
public static void main(String[] args) {
    // int a = 0 ; 
    // int b  = 1 ; 
    // int c =  0;
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    // if(n<=1){
    //     System.out.println(n);
    // }
    // else{
    //     for(int i = 2 ; i <= n ; i++){
    //         c = a + b;
    //         a = b;
    //         b = c;
          
    //     }
    //       System.out.println(c);
    // }
    // int cnt  = 0 ;
    // while(n!=0){
    //     n/=10;
    //     cnt++;
    // }
    
    // int sum = 0 ;
    // while(n!=0){
    //     sum+=n%10;
    //     n/=10;
    // }
    // int rev = 0 ;
    int newn=0; 
    int rem  = 0 ; 
    // while(n!=0){
    //     rem=n%10;
    //     rev=rev*10+rem;
    //     n/=10;
    // }
    int pos = 1;
    while(n!=0){
        rem = n % 10;
        newn+=pos*Math.pow(10,rem-1);
        pos++;
        n/=10;
    }
    
    System.out.println(newn);
}
}