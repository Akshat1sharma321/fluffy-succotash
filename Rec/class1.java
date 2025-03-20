import java.util.* ;

public class class1 {
    public static int dec(int n){
       if(n==1){
        
        return 1;
       
       }
    //    System.out.print(n+" ");
        return n * dec(n-1) ; 
        //   System.out.print(n+" ");
    }
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc  = new Scanner(System.in) ; 
        int n = sc.nextInt();
        int res = dec(n) ;
        System.out.println(res); 
    }
    
}
