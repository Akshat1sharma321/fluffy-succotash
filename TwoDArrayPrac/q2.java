package TwoDArrayPrac;
import java.util.*;
public class q2 {
    static boolean FindSaddle(int[][]arr,int n ,int m){
        for(int i = 0 ; i < n ; i++){
            int row_min = arr[i][0] , col_id = 0 ;
            for(int j = 1 ; j < m ; j++){
                if(row_min>arr[i][j]){
                    row_min= arr[i][j] ; 
                    col_id = j ;
                }
            }
            int k ;
            for( k= 0 ; k < n ; k++){
                if(row_min<arr[k][col_id]){
                    break ; 
                }
            }
            if(k==n){
                System.out.println("Saddle Point is : " + row_min) ;
                return true ; 
            }
        }
        return false ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ; 
        System.out.println("Enter the number of row : ") ; 
        int n = sc.nextInt() ; 
        System.out.println(("Enter the columns : "));
        int m  = sc.nextInt() ; 
        System.out.println("Enter the matrix");
        int [][] arr = new int[n][m] ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                arr[i][j]=sc.nextInt();
            }
        }


        if(FindSaddle(arr,n,m)==false ){
            System.out.println("No Saddle Point") ;
        }

    }
}
