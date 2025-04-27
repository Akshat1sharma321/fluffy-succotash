import java.util.ArrayList;
import java.util.List;

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

    public static void printCoinChangeCombination(int[] coins, int tar, int idx, String asf) {
        // pcc(0 , tar , "" , coins) ;
        if (tar == 0) {
            System.out.println(asf);
            return;
        }
        if (tar < 0)
            return;
        for (int i = idx; i < coins.length; i++) {
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

    public static void pcc(int idx, int target, String asf, int[] coins) {
        if (idx == coins.length) {
            if (target == 0) {
                System.out.println(asf);
            }
            return;
        }
        pcc(idx + 1, target - coins[idx], asf + coins[idx] + " ", coins);
        pcc(idx + 1, target, asf, coins);
    }

    public static int friendsProblem(int n) {
        // Basically we are making one element single and then trying to make the paors
        // of it if we have 3 elements then if we start with 1st friend either it can be
        // single or in pair for single there is only one option but for pair it can ha
        // have pair with 2 or 3 and thus total pairs would be n-1 and if we go to 4
        // elements then we can have 3 pairs and each of two elemnts can be in 2 ways
        // .....
        if (n <= 1)
            return 1;
        return friendsProblem(n - 1) + (n - 1) * friendsProblem(n - 2);
    }

    public static int josephus(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int smallerans = josephus(n - 1, k);
        int ans = (smallerans + k) % n;
        System.out.println("Person saafe --" + ans);
        return ans;
    }

    public static void solveSudoku(char[][] board) {
        ArrayList<int[]> emptyPlaces = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    emptyPlaces.add(new int[] { i, j });
                }
            }
        }
        fillSudoku(0, emptyPlaces, board);
    }

    public static boolean fillSudoku(int idx, ArrayList<int[]> emptyPlaces, char[][] board) {
        if (idx == emptyPlaces.size()) {
            return true;
        }
        int row = emptyPlaces.get(idx)[0];
        int col = emptyPlaces.get(idx)[1];

        for (char num = '1'; num <= '9'; num++) {
            if (canplace(row, col, emptyPlaces, board, num)) {
                board[row][col] = num;
                boolean isSolved = fillSudoku(idx + 1, emptyPlaces, board);
                if (isSolved == true) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    public static boolean canplace(int row, int col, ArrayList<int[]> emptyPlaces, char[][] board, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num)
                return false;
        }
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == num)
                return false;
        }
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    public int totalNQueens(int n) {
        int m = n;
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[n];
        boolean[] diags = new boolean[n + m - 1];
        boolean[] adiags = new boolean[n + m - 1];
        int ans = totSol(0, n, rows, cols, diags, adiags);
        return ans;
    }

    public int totSol(int row, int n, boolean[] rows, boolean[] cols, boolean[] diags, boolean[] adiags) {
        if (row == n)
            return 1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cols[i] == false && rows[row] == false && diags[row - i + n - 1] == false && adiags[row + i] == false) {
                cols[i] = true;
                rows[row] = true;
                diags[row - i + n - 1] = true;
                adiags[row + i] = true;
                cnt += totSol(row + 1, n, rows, cols, diags, adiags);
                cols[i] = false;
                rows[row] = false;
                diags[row - i + n - 1] = false;
                adiags[row + i] = false;
            }
        }

        return cnt;
    }

    public int setKthbittrue(int num, int k) {
        int mask = (1 << k);
        int newNum = num | mask;
        return newNum;
    }

    public int setKthbitfalse(int num, int k) {
        int mask = ~(1 << k);
        int newNum = num & mask;
        return newNum;
    }

    public boolean check(int n, int col, int row, int colVis, int diagVis, int adiagVis) {
        if ((colVis & (1 << col)) > 0)
            return false;
        else if ((diagVis & (1 << row - col + n - 1)) > 0)
            return false;
        else if ((adiagVis & (1 << row + col)) > 0)
            return false;
        else
            return true;
    }

    public int toNqueens(int n, int row, int colVis, int diagVis, int adiagVis) {
        if (row == n)
            return 1;
        int cnt = 0;
        for (int col = 0; col < n; col++) {
            if (check(n, col, row, colVis, diagVis, adiagVis)) {
                colVis = setKthbittrue(colVis, col);
                diagVis = setKthbittrue(diagVis, row - col + n - 1);
                adiagVis = setKthbittrue(adiagVis, col + row);
                cnt += toNqueens(n, row + 1, colVis, diagVis, adiagVis);
                colVis = setKthbitfalse(colVis, col);
                diagVis = setKthbitfalse(diagVis, row - col + n - 1);
                adiagVis = setKthbitfalse(adiagVis, col + row);
            }
        }
        return cnt;
    }

    public void totQueens(int n) {
        int colVis = 0, diagVis = 0, adiagVis = 0, row = 0;
        System.out.println(toNqueens(n, row, colVis, diagVis, adiagVis));
    }

    public int generateAllParenthesis(int n) {
        int cnt = 0;
        String asf = "";
        gen(n, asf, 0, 0);
        return cnt;
    }

    public void gen(int n, String asf, int ob, int cb) {
        if (ob == n) {
            while (cb < ob) {
                asf += ")";
                cb++;
            }
            System.out.println(asf);
            return;
        }
        if (ob < n) {
            gen(n, asf + "(", ob + 1, cb);
        }
        if (cb < ob) {
            gen(n, asf + ")", ob, cb + 1);
        }
    }

    public boolean w(char[][] board, String word, int row, int col, boolean[][] vis, int idx) {
        if (word.length() == idx) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || vis[row][col] == true
                || board[row][col] != word.charAt(idx)) {
            return false;
        }
        boolean wordFound = false;
        vis[row][col] = true;
        int[][] dr = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
        for (int i = 0; i < 4; i++) {
            int nrow = row + dr[i][0];
            int ncol = col + dr[i][1];
            // if (nrow >= 0 && ncol >= 0 && nrow < board.length && ncol < board[0].length
            // && vis[nrow][ncol] != true) {
            wordFound = wordFound || w(board, word, nrow, ncol, vis, idx + 1);
            // }
        }
        vis[row][col] = false;
        return wordFound;
    }

    public void gen(int n, int ob, int cb, String asf, List<String> ans) {
        if (ob == n) {
            while (cb < ob) {
                asf += ")";
                cb++;
            }
            ans.add(asf);
            return;
        }
        if (ob < n) {
            gen(n, ob + 1, cb, asf + "(", ans);
        }
        if (cb < ob) {
            gen(n, ob, cb + 1, asf + ")", ans);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        gen(n, 0, 0, "", ans);
        return ans;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        boolean ans = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    ans = ans || w(board, word, i, j, vis, 0);
                }
            }
        }
        return ans;
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

        // System.out.println(josephus(5,3));
        // char[][] board = {
        // { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
        // { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
        // { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
        // { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
        // { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
        // { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
        // { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
        // { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
        // { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        // };
        // solveSudoku(board);

        System.out.println(1 << 3);
        backtrackques a = new backtrackques();
        a.generateAllParenthesis(3);

    }
}