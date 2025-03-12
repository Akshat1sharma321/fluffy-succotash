import java.util.Scanner;

public class class6 {
    public static int fact(int n){
        int ans = 1 ;
        while(n>=1){
            ans*=n;
            n--;
        }
        return ans;
    }
    public static int bina(int n){
        int i = 0 ;
        int ans = 0 ;
        while(n!=0){
            int dig = n%10;
            if(dig==1)ans+=Math.pow(2,i);
            n/=10;
            i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size :::");
        int n = sc.nextInt();
        int [] arr = new int [n];
        for(int i = 0 ; i <n ; i++){
            int inp = sc.nextInt();
            arr[i]=inp;
        }
        int cnt = 0 ;
        for(int i = 0 ; i < n ; i++){
           if(arr[i]>40)cnt++;
        }
        System.out.println("Greater than 40 :"+cnt);
    }
}
