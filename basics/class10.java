package basics;
public class class10 {
    public static int binarySearch(int [] arr , int target){
        int low = 0 ; 
         int  high = arr.length ; 
         int l = 0; 
         int r = 0 ;
         while(low<=high){
            int mid = (low + high) / 2 ; 
            if(arr[mid]==target){
                return mid ; 
            }
            else if(arr[mid]<target){
                low = mid + 1 ; 
                l = arr[mid] ;
            }
            else{
                high = mid - 1 ; 
                r = arr[mid] ;
            }
           
         }
         System.out.println("low" + l);
         System.out.println("high" + r);
          return -1;
    }
    public static void main(String[] args) {
        int [] arr = {2 , 5 , 8 , 16 , 29 , 56} ;
        int target = 25 ; 
        int index = binarySearch(arr , target) ;
        System.out.println("index "+index);
    }
    
}
