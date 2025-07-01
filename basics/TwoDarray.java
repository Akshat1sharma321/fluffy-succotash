package basics;
public class TwoDarray {
  public static void main(String[] args){
    int [][] arr1 = {
        {11,22,4,45,110},
        {33,9,7,5,89},
        {66,77,6,55,99},
        {13,1,43,88,44}
    } ; 
    int [][] arr2 = {
        {5,-2},
        {4,5},
        {11,9}
    } ;
    int r1 = arr1.length ; 
    int c1 = arr1[0].length ; 
    int r2 = arr2.length ; 
    int c2 = arr2[0].length ;
    // if(c1!=r2) System.out.println("cant mul");
    // int [][] ans = new int [r1][c2] ;
    // for(int i = 0 ; i < r1 ; i++){
    //     for(int j = 0 ; j < c2 ; j++){
    //         for(int k = 0 ; k < r2 ; k++){
    //             ans[i][j]+=arr1[i][k]*arr2[k][j];
    //         }
    //     }
    // }
    int flag = 0 ;
    for(int i = 0 ; i < c1 ; i++){
        if(flag == 1){
           for(int j = r1-1 ; j >= 0 ; j--){
            System.out.print(arr1[j][i]+" ");
        } 
        flag = 0 ;
        }
        else{
           for(int j = 0 ; j < r1 ; j++){
            System.out.print(arr1[j][i]+" ");
        } 
        flag = 1;
        }
        
        System.out.println();
    }
  }
}
