public class class8 {
    public static void floodfill(int row , int col , int n , int m , int[][]mat , boolean[][]visited,String asf){
if(row==n-1 &&col==m-1){
System.out.println(asf);
return ;
}
if(row<0 || col < 0 || row >=n ||col >= m || mat[row][col]==1 || visited[row][col]== true){
    return ; 
}
visited[row][col]=true ; 
floodfill(row-1, col, n, m, mat, visited, asf+"u");
floodfill(row, col-1, n, m, mat, visited, asf+"r");
floodfill(row+1, col, n, m, mat, visited, asf+"d");
floodfill(row, col+1, n, m, mat, visited, asf+"l");
visited[row][col]=false ; 
}

public static  void targetsubsets(int []arr, int idx , int tar , String sub){
    if(idx == arr.length){
if(tar==0){
    System.out.println(sub);
}

    }
    targetsubsets(arr, idx+1, tar-arr[idx], sub+" , ");
    targetsubsets(arr, idx+1, tar, sub);
}

public static void nqueens() {
  void bool check(int row , int col , int[][]visible){
    for(int col = 0 ; col < m ; col++ ){
        if(visible[row][col]=='q')return false ;
    }
    for(int row = 0 ; row < n ; row++ ){
        if(visible[row][col]=='q')return false ;
    }
    for(int col = 0 ; col < m ; col++ ){
        if(visible[row][col]=='q')return false ;
    }
  }  
}
    public static void main(String[] args) {
       int mat[][] = {{0, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0,}, {0, 1, 0, 1, 1, 0}, {0, 0, 0, 1, 1, 0}};
       int  n = mat.length ; 
       int m = mat[0].length ; 
       boolean [][] visited = new boolean[n][m] ; 
       floodfill(0,0,n,m,mat,visited,"");


    }
}
