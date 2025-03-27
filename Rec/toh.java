public class toh {
    public static void  pa(int[]arr,int idx){
        if(idx==arr.length)return ;
        System.out.println(
          arr[idx]
        );
        pa(arr,idx+1);
    }
    public static void  ra(int[]arr,int idx){
        if(idx==arr.length)return ;
        
        ra(arr,idx+1);
        System.out.println(
          arr[idx]
        );
    }
    public static int  fa(int[]arr,int idx,int tar){
        if(idx==arr.length)return -1 ;
        int f = -1 ;
       
         f = fa(arr,idx+1,tar);
         if(arr[idx]==tar) f = idx;
         return f ; 
    }
    
    public static void toha(int n, int A, int B, int C) {
        if(n==0)return ;
        toha(n - 1, A, C, B);
        System.out.println("Move Disc " + n + " From " + A + " to " + C);
        toha(n - 1, B, A, C);
    }

    public static void main(String[] args) {
        toha(3,10,20,30);
        int[]arr={1,2,3,4,5,5,7};
        int ans  = fa(arr, 0 ,9);
System.out.println(ans);
    }
}
