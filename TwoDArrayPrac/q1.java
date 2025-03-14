public class q1 {
    //Diagonal Traversal 
    class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length , m = mat[0].length ; 
        int[]ans=new int[n*m] ; 
        if(n==0||m==0)return new int[0] ;
        int row = 0 , col = 0 ,i = 0 ;
        boolean up = true ; 
        while(row<n && col<m){
            //if we are going up 
            //Agar ham last wale column par aagaye to hame niche wali row me jaana haia warna hame agle column me jaana hai similarly row ke case me ...
            if(up){
                while(row>0 && col<m-1){
                    ans[i++]=mat[row][col];
                    row--;
                    col++;
                }
                ans[i++]=mat[row][col];
                if(col==m-1)row++;
                else col++ ;
                // up=!up;
            }
            else{
                while(row<n -1 && col>0){
                    ans[i++]=mat[row][col];
                    row++;
                    col--;
                }
                ans[i++]=mat[row][col];
                if(row==n-1)col++;
                else row++;
            }
            up=!up;
            //if weare going down
        }
        return ans ; 
    }
}
//Dry run for 1 2 3 4 5 6 7 8 9
// n = 3  , m = 3 , ans of size 9 , not null , row = 0 , col = 0 , i = 0 
//ans = 1 , 2 , 4 , 7 , 5 ,3 , 6 , 8 , 9
// up = 1 -> 0 -> 1 -> 0 -> 1 -> 0
//i = 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
// row = 0 -> 1 -> 2 -> 1 -> 0 -> 1 -> 2 -> 3
// col = 0 -> 1 -> 0 -> 1 -> 2 -> 1 -> 2
}
