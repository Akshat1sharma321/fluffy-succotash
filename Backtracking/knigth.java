public class knigth {
    public static void knightsTour(int[][] chess, int movenumber, int row, int col) {
        int n = chess.length;
        if (row < 0 || col < 0 || col >= n || row >= n || chess[row][col] != 0) {
            return;
        }
        if (movenumber == n * n + 1 ) {
            printChess(chess);
            System.out.println();
            return;
        }
        
        chess[row][col] = movenumber;
        int[][] dirs = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 1, -2 }, { 2, -1 } };
        for (int[] dir : dirs) {
            int ncol = dir[1];
            int nrow = dir[0];
            knightsTour(chess, movenumber + 1, row + nrow, col + ncol);
        }
        chess[row][col] = 0;
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

    public static void main(String[] args) {
        int[][] chess = new int[8][8];
        knightsTour(chess, 1, 0, 0);
    }
}