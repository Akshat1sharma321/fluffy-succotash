public class pract {
  public static void shellRotate(int n, int m, int s, int k, int[][] matrix) {
    // Write your code here
        int sr = 0 , sc = 0 , er = n - 1 , ec = m - 1 ; 
        for(int i = 0 ; i < s ; i++){
            sr++;
            sc++;
            er--;
            ec--;
        }
        int totrot = er*ec - 1 ; 
        if(k<0) k = k + totrot+1;
        for(int j = 0 ;  j < k ; j++){
            int temp = matrix[sc][sr] ; 
            int temp1 = 0 ;
            matrix[sc][sr]=matrix[sc][sr+1];
            for(int i = sc ; i <= ec ;i++){
                temp1=matrix[sr][i] ;
                matrix[sr][i] = temp ;
                temp = temp1 ;
            }
            for(int i = sr ; i <= er ; i++){
                temp1 = matrix[i][ec] ; 
                matrix[i][ec] = temp ; 
                temp = temp1 ; 
            }
            for(int i = ec ; i >= sc ; i--){
                temp1 = matrix[er][i] ; 
                matrix[er][i] = temp ; 
                temp = temp1 ; 
            }
            for(int i = er ; i >= sr; i--){
                temp1 = matrix[i][sc] ; 
                matrix[i][sc] = temp ; 
                temp = temp1 ; 
            }
            
        }

    }

    public static void main(String[] args) {
        int[][]mat = {
           { 11  , 12 , 13 , 14 , 15 , 16 , 17 },
{21 ,22 ,23 ,24 ,25 ,26  , 27 },
{31 ,32, 33 ,34 ,35, 36, 37}, 
{41 ,42, 43 ,44, 45, 46, 47 },
{51 ,52, 53 ,54 ,55, 56 ,57 }
        };
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 7 ; j++){
                System.out.print(mat[i][j]+" ");

            }
            System.out.println();
        }
        System.out.println();
        shellRotate(5, 7, 2, 3, mat);
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 7 ; j++){
                System.out.print(mat[i][j]+" ");

            }
            System.out.println();
        }
    }

}

