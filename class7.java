import java.util.*;
public class class7 {
    public static int sp(int arr[] ){
        int n  =  arr.length ;
        int max = Integer.MIN_VALUE ;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(min>arr[i])min=arr[i];
            if(max<arr[i])max=arr[i];
        }
        return (max-min) ;
     }
     public static void pat(int arr[]){
        int n = arr.length ;
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < n ; i++ ){
            if(max<arr[i])max=arr[i];
        }
        // int totl = max ; 
        int currl = max  ; 
        int ht = max;
        while(currl>=1){
            for(int i = 0 ; i < n ; i++){
                if(arr[i]>=currl)System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
            currl--;
            
        }
     }
     public static int ls(int arr[],int t){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i]==t)return i ;
        }
        return -1;
     }
    public static void getArr(int arr[],int n){
        Scanner sc  = new Scanner(System.in) ;
for(int i = 0 ; i < n ; i++){
    int inp = sc.nextInt() ; 
    arr[i] = inp ;
}
    }
    public static int[] addT(int arr1[] , int arr2[]){
        int n  =  arr1.length ; 
        int m = arr2.length ; 
        int z = Math.max(n,m)+1;
        int []res = new int[z];
        int i = n - 1; 
        int j = m - 1; 
        int r = z - 1 ; 
        while(r>=0){
            int sum  = 0 ; 
            int carry = 0 ;
            if(i>=0){
                sum+=arr1[i];
                i--;
            }
            if(j>=0){
                sum+=arr2[j];
                j--;
            }
            if(sum>9){
                sum%=10;
                carry=1;
            }
            else{
                carry=0;
            }
            sum+=carry;
            res[r]=sum;
            r--;
        }
        return res ; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ; 
        System.out.println("Enter the size");
        int n  = sc.nextInt() ; 
        int arr1[] = new int[n] ; 
        getArr(arr1,n) ;
        int n1  = sc.nextInt() ; 
        int arr2[] = new int[n] ; 
        getArr(arr1,n1) ;
        int [] res = addT(arr1,arr2) ;
        for(int i : res){
            System.out.print(i+" ");
        }
        
        // int tar = sc.nextInt() ; 
        // int id= ls(arr,tar) ;
        // System.out.println("idx :"+id) ; 
        
    }
    
}
