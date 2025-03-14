import java.util.* ;
public class q4 {
    public static int[][] Sorti(int [][] Mat){
        int n = Mat.length ; 
        int m = Mat[0].length ; 
        int [] arr = new int [n*m] ; 
        for(int i = 0 ; i < n ; i++ ){
            for(int j = 0 ; j < m ; j++){
                arr[m*i+j]=Mat[i][j] ; 
            }
        }
        Arrays.sort(arr) ; 
        for(int i = 0 ; i < n*m; i++){
            int x = i/m ; 
            int y = i%m ; 
            Mat[x][y] = arr[i]  ; 
        }

        return Mat ;
    }
    public static void main(String[] args) {
        System.out.println("Hello");
        int[][]Mat={
        {2,3,4,1},{6,5,7,8},{9,11,10,12},{13,14,16,15}
    };
    int n = Mat.length ; 
    int m = Mat[0].length ;
    Sorti(Mat) ; 

    for(int i = 0 ; i < n ; i++ ){
            for(int j = 0 ; j < m ; j++){
                System.out.print(Mat[i][j]+" , ");
            }
            System.out.println();
        }
    }
    }


