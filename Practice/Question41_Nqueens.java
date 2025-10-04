import java.util.ArrayList;
import java.util.List;

public class Question41_Nqueens {
     public boolean canbeplace(int row , int col ,int n , boolean[][]vis){
        int [][] dirs = {{0 , 1} , {0 , -1} , {1 , 0} , {-1 , 0} , {-1, 1} , {1 , 1}  , {1 , -1} ,{-1 , -1}} ; 
        for( int rad = 1 ; rad < n ; rad++){
            for(int[]dir : dirs){
                int x = row + dir[0]*rad ; 
                int y = col + dir[1]*rad ; 
                if(x >= 0 && x < n && y>=0 && y< n && vis[x][y] == true){
                    return false ; 
                }
            }
        }
        return true ; 
    }
    public void solve(int n , int col , List<List<String>> res , boolean [][] vis){
        if(col == n){
            construct(res , vis , n) ; 
            return  ; 
        }

        for(int r = 0 ; r < n ; r++){
            if(canbeplace(r , col , n, vis)){
                vis[r][col] = true ; 
                solve(n , col +1 , res , vis) ; 
                vis[r][col] = false ; 
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        boolean[][] vis  = new boolean[n][n] ; 
        List<List<String>> res = new ArrayList<List<String>>() ; 
        solve(n , 0  , res , vis) ; 
        return res; 
    }
    public void construct(List<List<String>>res , boolean[][] vis, int n ){
        List<String>board= new ArrayList<>() ; 
        for(int i = 0  ; i < n ; i++){
            StringBuilder sb = new StringBuilder() ;
            for(int j =  0  ; j < n ; j++){
                if(vis[i][j]==true){
                    sb.append('Q') ;
                }else sb.append('.') ; 
            }
            board.add(sb.toString()) ; 
        }
        res.add(board) ; 
    }
}
