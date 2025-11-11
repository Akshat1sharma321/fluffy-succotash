public class Question51_MergeSoprt {
    
    public static void mergeSort(int low , int high , int [] arr){
        if(low >= high) return  ; 
        int mid  = (low + high) / 2 ; 
        mergeSort(low , mid , arr) ; 
        mergeSort(mid + 1, high , arr) ; 
        mergeit(low , mid , high , arr) ;
        // System.out.println(arr) ;  
    }
    public static void mergeit(int low , int mid , int high , int [] arr){
        int [] ans = new int[high - low + 1] ;
        int i =  low , j = mid + 1 , k = 0 ; 
        while(i <= mid && j <= high){
            if(arr[i]<arr[j]){
                ans[k++] = arr[i++] ; 
            }else ans[k++] = arr[j++]  ; 
        }
        while(i <= mid) ans[k++] = arr[i++] ; 
        while(j <= high ) ans[k++] = arr[j++] ;
        for(int in  = 0  ; in < ans.length ; in++){
            arr[low + in] = ans[in] ; 
        }
        // return ans  ;  
    }
    public  static void main(String[]args){
      int [] arr = { 3 , 2 , 1 ,  4 , 5  , 90 , 43 , 9} ; 
      for (int i : arr) {
          System.out.print(i + " , ");
      }
      System.out.println();
      mergeSort(0 , arr.length - 1, arr) ;  
      for(int i : arr){
        System.out.print(i + " , ");
      }
    }  
}
