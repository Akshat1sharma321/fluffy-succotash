package basics;
import java.util.* ; 
public class class12 {
 public static void spi(int[][]arr1){
int sr = 0 ; 
int scl = 0 ; 
int er = arr1.length -1 ; 
int ec = arr1[0].length -1 ;

while(sr<=er && scl<=ec){
    for(int i = sr ; i <= er ; i++ ){
        System.out.print(arr1[i][scl] + " , ");
    }
    scl++;

    for(int i = scl ; i <= ec ; i++ ){
        System.out.print(arr1[er][i] + " , ");
    }
    er--;

    for(int i = er ; i >=sr  ; i-- ){
        System.out.print(arr1[i][ec] + " , ");
    }
    ec--;

    for(int i = ec ; i >=scl  ; i-- ){
        System.out.print(arr1[sr][i] + " , ");
    }
    sr++;

    System.out.println();
}
 }

public static void tra(int[][]arr1){
    int n = arr1.length ; 
    int m  = arr1[0].length  ;

    for(int i = 0 ;  i  < n ; i++){
        for(int j = i  ; j   < m ; j++){
            int temp = arr1[i][j] ; 
            arr1[i][j] = arr1[j][i] ; 
            arr1[j][i] = temp ; 
        }
    }
}

public static void rota(int[][]arr1){
   int n = arr1.length -1 ; 
    int m  = arr1[0].length-1  ;  
    for(int i =  0 ;  i < n ; i++){
    for(int  j = i ; j < m  ;j++ ){
        int temp = arr1[i][j] ; 
        
        arr1[j][n-i]=temp;
    }
    }
}

 public static void main(String[] args) {



int [][] arr1 = {
        {11,22,4,45,110},
        {33,9,7,5,89},
        {66,77,6,55,99},
        {13,1,43,88,44},
        {13,1,43,88,44}
    } ; 
    int n = arr1.length ; 
    int m  = arr1.length  ;

// spi(arr1);
rota(arr1);
for(int i = 0 ;  i  < n ; i++){
        for(int j = 0  ; j   < m ; j++){
            System.out.print(arr1[i][j]+" , "); 
        }
        System.out.println();
    }



}
}
