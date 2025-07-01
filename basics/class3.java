package basics;
import java.util.*;
public class class3 {
    public static void main(String[] args) {
    //     System.out.println("Testing");
    //     int num = 1 ;
        
    //    while(num<=5){
    //     System.out.println(num++);
    //    }
    // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the numbers : ");
        // for(int i = 0 ; i < 5 ; i++){
        //     int x = sc.nextInt();
        //     if(x%2==0){
        //         System.out.println("Even");
        //     }
        //     else{
        //         System.out.println("odd");
        //     }
        // }
    //     System.out.println("Enter the number for the Table to be displayed");
    //     Scanner sc = new Scanner(System.in);
    //     int x = sc.nextInt();

    // for(int i = 1 ; i <= 10 ; i++){
    //     System.out.println(x*i);
    // }

    //         int fact = 1 ;
//       while(i>0){
//         fact = fact*i;
//         i--;
//       }
// System.out.println(fact);
Scanner sc = new Scanner(System.in);
System.out.println("Enter the number for num");
int x = sc.nextInt();


// if(x==2){
//     System.out.println("prime");
// }


for(int i = 1 ; i <= x ; i++){

int flag = 0 ;  
    for(int j = 2 ; j*j<=i ; j++){
    if(x%j==0){
        flag=1;
        System.out.println(i + " not prime");
        break;
    }
}

if(flag==0){
    System.out.println(i+ "prime");
}


}

    }
}