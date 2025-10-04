import java.util.ArrayList;

public class Question32_CountSub {
    class Solution {
    public void dfs(ArrayList<Integer> comp , boolean[] vis , int idx , int[][] grid2){
        vis[idx] = true ; 
        comp.add(idx) ;
        int n = grid2.length ; 
        int m = grid2[0].length ; 
        int x = idx/m ; 
        int y = idx%m ; 
        int [][] dirs = {{0,-1} ,{-1,0} ,{0,1},{1,0}} ; 
        for(int [] direc : dirs){
            int row = x + direc[0] ; 
            int col = y + direc[1] ; 
            if(row >= 0 && row < n && col >= 0 && col < m && grid2[row][col]==1 && vis[row*m + col]==false){
                dfs(comp , vis , row*m + col , grid2) ; 
            }
        }
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        ArrayList<ArrayList<Integer>>check = new ArrayList<>()  ; 
        int n = grid2.length ; 
        int m = grid2[0].length ; 
        boolean [] vis = new boolean[n*m] ; 
        for(int i =  0 ; i  <  n ;  i ++){
            for(int j = 0  ; j < m  ; j++){
                if(grid2[i][j] == 1 && vis[i*m + j] == false){
                    ArrayList<Integer>comp = new ArrayList<>() ; 
                    dfs(comp ,  vis , i*m + j , grid2 ) ; 
                    check.add(comp) ; 
                }
            }
        }
        System.out.println(check) ; 
        int no = 0 ;  
        for(ArrayList <Integer> subs : check){
            boolean yes = true ; 
            for(int i : subs){
                int x = i/m ; 
                int y = i%m ; 
                if(grid1[x][y]!=1){
                    yes = false ; 
                    break ; 
                }
              
            }
              if(yes) no++  ;
        } 
        return no ; 
    }
}
}
