import java.util.* ; 
public class class2 {
    public static int power(int x , int y ){
        if(y==0) return 1  ;
        int smallerans = power(x,y-1);
        int ans  = x*smallerans ; 
        return ans ; 
    }
    public static void pat(int n){
        if(n==0) return ;
        System.out.print(n);
        pat(n-1) ;
        System.out.print(n);
        pat(n-1);
        System.out.print(n);
    }
    public static void hanoi(int n , int A, int B , int C){

    }
    public static int power2(int x , int y ){
        if(y==0) return 1  ;
        int smallerans = power(x,y/2);
        int ans  = smallerans*smallerans ; 
        //donjt write ans = power(x,y/) * power(x,y/2) as it will maske the complexity 0(n) instead of 0(log n )
        if(y%2!=0)ans = ans*x ; 
        return ans ; 
    }
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc  = new Scanner(System.in) ; 
        System.out.println("Enter the no and the power");
        int x = sc.nextInt() ;
        pat(x); 
        // int y = sc.nextInt() ; 
        // int ans  = power2(x, y) ;
        // System.out.println(ans); 
    }
    
}
