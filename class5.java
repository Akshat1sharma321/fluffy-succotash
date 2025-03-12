import java.util.* ;
public class class5{
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in) ; 
        // System.out.println("Enter the no :");
        // int n = sc.nextInt() ;
        // int k = sc.nextInt() ;
        // int i = 0 ; 
        // int cnt = 0 ;
        // int temp1 = n ;
        // while(temp1!=0){
        //     cnt++;
        //     temp1/=10;
        // }
        // int temp = n ;
        // k=k%cnt;
        // if(k<0)k=k+n;
        // while(i<k){
        //     n=temp;
        //     int dig = n%10;
        //     n/=10;
        //     temp=n;
        //     temp+=dig*Math.pow(10,cnt-1) ;
        //     i++;

        // }
        // int div = (int)Math.pow(10,k);
        // int ld = n % div;;
        // int sd = n / div ;
        // int ans = ld*(int)Math.pow(10,cnt-k) + sd ;


        // System.out.println("After rotation : "+ans);


        int num1 = sc.nextInt() ; 
        int num2 = sc.nextInt();
        // int gcd = 1 ;
        // for(int i = 1 ; i < num1 ; i++){
        //     if(num1 % i == 0 && num2 % i == 0){
        //         gcd = i;
        //     }
        // }
        // int a = Math.min(num1,num2);
        // why not working with num1%numm2!==0
        while(num2%num1!=0){
            int rem = num1 % num2 ; 
            num1 = num2 ; 
            num2 = rem ; 
        }
        System.out.println("GCD : "+num1);
    //     int lcm = (num1*num2)/gcd;
    //     System.out.println("GCD : "+gcd);
    //     System.out.println("LCM:"+lcm);
    }
}