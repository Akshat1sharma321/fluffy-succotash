package basics;
import java.util.Scanner;

public class class9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] arr = new int[n];
        // for(int i = 0 ; i < n ; i++){
        //     arr[i] = sc.nextInt();
        // }
        // // int k = sc.nextInt();
        int[]arr={1,2,-3 , -5 ,8 , 10 , -1 , 3};
        System.out.println(psumm(arr));
        
    }
    public static int kdiv(int[] arr , int k ){
        int n = arr.length ; 
        int cnt = 0 ;
        for(int i = 0 ; i < n ; i++){
            int sum  = 0 ;
            for(int j = i ; j < n ; j++){
                sum+=arr[i] ; 
                if(sum%k==0)cnt++;
            }
        }
     return cnt  ; 

    }
    public static int summ(int[] arr){
        int msum = 0 ; 
         int sum = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
           
            sum+=arr[i] ;
            msum=Math.max(sum,msum);
            if(sum<0){
                
                 sum=0;
            }


    }
    return msum ;
    }

     public static int psumm(int[] arr){
        int msum = Integer.MIN_VALUE ; ; 
         int sum = 0 ;
         int st = 0 , en = 0 ,sti = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
           
            sum+=arr[i] ;
            if(sum>msum){
                st = sti ; 
                en = i ;
                msum = sum ;
            }
            // en++;
            msum=Math.max(sum,msum);
            if(sum<0){
                sti = i + 1 ; 
                 sum=0;
            }


    }
    for(int k = st ; k <= en ; k++){
        System.out.print(arr[k]+" ");
    }
    return msum ;
    
}

 public static void ppsumm(int[] arr){
        
    int n = arr.length ; 
    int msum = Integer.MIN_VALUE ; 
    int st = 0 , en = 0 ;
    for(int i =0 ; i < n ; i++){
        // int sum = 0 ;
        for(int j = i ; j < n ; j++){
            int sum = 0 ;
            for(int k = i ; k <= j ; k++){
                sum+=arr[k] ; 
            }
            if(sum>msum){
                msum = sum ;
                st = i ;
                en = j ;
            }
        }
        
    }
    for(int k = st ; k <= en ; k++){
            System.out.print(arr[k]+" ");
        }
}
}