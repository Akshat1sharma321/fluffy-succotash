import java.util.* ; 

public class class8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ; 
        int n  = sc.nextInt();
        int[]a = new int[n] ; 
        for(int i = 0 ; i < n ; i++){
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        // int m = sc.nextInt();
        // int[] b = new int[m] ;
        // for(int i = 0 ; i < m ; i++){
        //     b[i] = sc.nextInt();
        // }
        // int[] c = new int [n];
        // c = inverse(a);
        // sub(a);
        int res = find(a, k) ; 
        System.out.println(res);
        // for(int i = 0 ; i < a.length ; i++){
        //     System.out.print(a[i]+" ");
        // }
    }

    public static int[] sub(int[] a, int[] b){
    int n  = a.length ; 
    int m = b.length ; 

    int[] c = new int[n];
    int j = n - 1  ; 
    int i = m - 1  ; 
    int k = n -1 ; 
    int borrow = 0 ; 
    while(k>=0){
        int diff = a[j] - borrow ;
        if(i>=0){
            diff-=b[i] ; 

        }
        if(diff<0){
            diff+=10;
            borrow = 1 ;
        }
        else{
            borrow = 0 ;
        }
        c[k]=diff ; 
        k--;
        i-- ; 
        j-- ; 

    }
    return c ;
}
    public static void rev(int[] arr  , int i , int j ){
      int n =  arr.length ; 
    //   int i = 0 ; 
    //   int j = n -  1  ; 
      while(j>=1){
        int temp = arr[j] ; 
        arr[j] = arr[i] ; 
        arr[i] = temp ; 
        i++ ;
        j-- ;
      }
    }
    public static void rot(int[] arr , int k){
      int n =  arr.length ; 
      k = k % n ; 
      int i = n - 1 ;
      
     while(k>0){
        int temp = arr[i] ;
        while(i>0){
            arr[i]=arr[i-1];

        }
        arr[0]=temp;
        k--;
     }
    }

    public static void rot3(int[] arr , int k ){
      int n =  arr.length ; 
      k = k % n ; 
      if(k<0)k+=n ; 
      rev(arr,0 , n -1 );
      rev(arr,0,k-1);
      rev(arr,k,n-1);
      
    }
    public static int [] inverse(int[] arr){
      int n  = arr.length ; 
      int [] temp = new int[n] ;
      int i = 0 ; 
      while(i<n){
        int dig = i ; 
        int pos = arr[i] ;
        temp[pos]=dig;
        i++;
      }
      return temp;
    }
     public static void sub(int[] arr){
      int n  = arr.length ; 
      for(int i = 0 ;  i < n ; i++){
        for(int j = i ; j < n ; j++){
            for(int k = i ; k <= j ; k++){
                System.out.print(arr[k]+" ");
            }
            System.out.println();
        }
      }
      
    }

    public static int find(int[] arr ,  int tar){
      int n  = arr.length ; 
      int count  = 0 ; 
      for(int i = 0 ; i < n ; i++){
        int sum = 0 ; 
        for(int j = i ; j < n ; j++){
         sum+=arr[j] ; 
         if(sum == tar){
          count++ ;  
          // sum = 0 ; 
         }
        }
      }
      return count  ;
    }
}

