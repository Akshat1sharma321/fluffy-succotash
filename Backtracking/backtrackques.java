import java.util.ArrayList;

public class backtrackques {
    public static void floodfill(int row, int col, int n, int m, int mat[][], boolean[][] visited, String asf) {
        if (row == n - 1 && col == m - 1) {
            System.out.println(asf);
            return;
        }
        if (row < 0 || col < 0 || row >= n || col >= m || visited[row][col] == true || mat[row][col] == 1) {
            return;
        }
        visited[row][col] = true;
        int[] r = { 0, -1, 0, 1 };
        int[] c = { -1, 0, 1, 0 };
        char[] mo = { 'l', 'u', 'r', 'd' };
        for (int i = 0; i < 4; i++) {
            int ncol = c[i];
            int nrow = r[i];
            char mov = mo[i];
            floodfill(row + nrow, col + ncol, n, m, mat, visited, asf + mov);
        }
        visited[row][col] = false;
    }

    public static void targetSum(int idx, int[] nums, int sum, String asf) {
        if (idx == nums.length) {
            if (sum == 0) {
                System.out.println(asf);
            }
            return;
        }
        targetSum(idx + 1, nums, sum - nums[idx], asf + nums[idx] + " ");
        targetSum(idx + 1, nums, sum, asf);
    }

    public static void nqueens(int row, int n, boolean[][] placed) {
        if (row == n) {
            printMat(placed);
            System.out.println();
            return;
        }
        for (int col = 0; col < n; col++) {
            if (check(row, col, placed) == true) {
                placed[row][col] = true;
                nqueens(row + 1, n, placed);
                placed[row][col] = false;
            }
        }
    }

    public static boolean check(int row, int col, boolean[][] placed) {
        int n = placed.length;
        int[][] dirs = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
        for (int rad = 1; rad < n; rad++) {
            for (int[] dir : dirs) {
                int ncol = col + rad * dir[1];
                int nrow = row + rad * dir[0];
                if (ncol < n && ncol >= 0 && nrow < n && nrow >= 0 && placed[nrow][ncol] == true) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printMat(boolean[][] placed) {
        int n = placed.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(placed[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static boolean knightsTour(int[][] chess, int movenumber, int row, int col) {
        int n = chess.length;
        if (row < 0 || col < 0 || col >= n || row >= n || chess[row][col] != 0) {
            return false;
        }
        if (movenumber == n * n) {
            chess[row][col] = movenumber;
            printChess(chess);
            chess[row][col] = 0;
            System.out.println();
            return true;
        }
        

        chess[row][col] = movenumber;
        int[][] dirs = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 1, -2 }, { 2, -1 } };
        for (int[] dir : dirs) {
            int ncol = dir[1];
            int nrow = dir[0];
            if (knightsTour(chess, movenumber + 1, row + nrow, col + ncol))
                return true;
        }
        chess[row][col] = 0;
        return false;
    }
    

    public static void printChess(int[][] placed) {
        int n = placed.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(placed[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static void printCoinChangePermutations(int[] coins, int tar, String asf, boolean[] visited) {
        if (tar == 0) {
            System.out.println(asf);
            return;
        }
        if (tar < 0) {
            return;
        }
        for (int idx = 0; idx < coins.length; idx++) {
            if (visited[idx] == false) {
                visited[idx] = true;
                printCoinChangePermutations(coins, tar - coins[idx], asf + coins[idx] + " ", visited);
                visited[idx] = false;
            }

        }
    }

    public static void printCoinChangePermutationsmul(int[] coins, int tar, String asf) {
        if (tar == 0) {
            System.out.println(asf);
            return;
        }
        if (tar < 0) {
            return;
        }
        for (int idx = 0; idx < coins.length; idx++) {
            printCoinChangePermutationsmul(coins, tar - coins[idx], asf + coins[idx] + " ");
        }
    }

    public static void printCoinChangeCombination(int[]coins , int tar , int idx , String asf){
        // pcc(0 , tar , "" , coins) ;
        if(tar==0){
            System.out.println(asf);
            return ; 
        } 
        if(tar<0)return ; 
        for(int i = idx ; i < coins.length ; i++){
            printCoinChangeCombination(coins, tar - coins[i], i + 1, asf + coins[i]);
        }
    }
    
    public static void printCoinChangeCombinationMultiple(int[] coins, int tar, int idx, String asf) {
        // pcc(0 , tar , "" , coins) ;
        if (tar == 0) {
            System.out.println(asf);
            return;
        }
        if (tar < 0)
            return;
        for (int i = idx; i < coins.length; i++) {
            printCoinChangeCombination(coins, tar - coins[i], i, asf + coins[i]);
        }
    }
    public static void pcc(int idx , int target , String asf , int[]coins) {
        if(idx==coins.length){
            if(target==0){
                 System.out.println(asf);
            }
            return ; 
        }
        pcc(idx+1, target - coins[idx], asf + coins[idx] + " ", coins);
        pcc(idx + 1, target, asf, coins);
    }
    
    public static int friendsProblem(int n){
        //Basically we are making one element single and then trying to make the paors  of it if we have 3 elements then if we start with 1st friend either it can be single or in pair for single  there  is only one option but for pair it can ha have pair with 2 or 3 and thus total pairs would be n-1 and if we go to 4 elements then we can have 3 pairs and each of two elemnts can be in 2 ways .....
        if(n<=1) return 1 ; 
        return friendsProblem(n-1) + (n-1)*friendsProblem(n-2) ; 
    }
    public static int josephus(int n,int k){
        if(n==1){
            return 0 ; 
        }
        int smallerans = josephus(n-1,k);
        int ans = (smallerans+k)%n ; 
        System.out.println("Person saafe --" + ans);
        return ans  ; 
    }

    public static  void solveSudoku(char[][]board){
        ArrayList<int[]>emptyPlaces = new ArrayList<>() ; 
        for(int i = 0  ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                if(board[i][j]=='.'){
                    emptyPlaces.add(new int[]{i,j});
                }
            }
        }
        fillSudoku(0,emptyPlaces,board);
    }
    public static boolean fillSudoku(int idx , ArrayList<int[]> emptyPlaces , char[][]board ){
        if(idx==emptyPlaces.size()){
            return true  ; 
        }
        int row = emptyPlaces.get(idx)[0] ; 
        int col = emptyPlaces.get(idx)[1] ; 

        for(char num = '1' ; num <= '9' ; num++){
            if(canplace(row, col, emptyPlaces, board, num)){
                board[row][col] = num  ;  
                boolean isSolved = fillSudoku(idx + 1, emptyPlaces, board) ; 
                if(isSolved==true){
                    return true ; 
                }
                board[row][col] = '.';
            }
        }
        return false  ; 
    }
    public static  boolean canplace(int row , int col , ArrayList<int[]> emptyPlaces , char[][]board , char num){
        for(int i = 0 ; i < 9 ; i++){
            if(board[row][i]==num) return false ; 
        }
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == num)
                return false;
        }
        int rowStart = (row / 3)*3; 
        int colStart = (col / 3)*3 ; 
        for(int i  = rowStart ; i < rowStart + 3 ; i++){
            for(int j = colStart ; j < colStart + 3 ; j++){
                if(board[i][j]==num) return false ; 
            }
        }

return true ; 
    }
    
    
    public static void main(String[] args) {
        // int[][] chess = new int[8][8];
        // knightsTour(chess, 1, 0, 0);
        // System.out.println("hello");
        // int [][] mat =
        // {{0,0,0,0,0,0},{0,1,0,1,1,0},{0,1,0,1,1,0},{0,0,0,0,0,0},{0,1,0,1,1,0},{0,0,0,1,1,0}}
        // ;
        // int n = mat.length ;
        // int m = mat[0].length ;
        // boolean [][] visited = new boolean [n][m] ;
        // int [] nums = {2,5,3,4,6,8,-4} ;
        // targetSum(0, nums, 8, "");
        // floodfill(0, 0, n, m, mat, visited, "");
        // System.out.println(n);
        // int n = 4;
        // boolean[][] placed = new boolean[n][n];

        // nqueens(0, n , placed );
        // int[] coins = { 2, 4, 6, 5, 3 };
        // boolean[]visited = new boolean[coins.length] ;
        // printCoinChangePermutations(coins, 10, "", visited);
        // printCoinChangePermutationsmul(coins, 10, "");
        // printCoinChangeCombination(coins, 10 , 0 ,"");
        
        System.out.println(josephus(5,3));
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        solveSudoku(board);
    }
}