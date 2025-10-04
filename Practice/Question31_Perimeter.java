public class Question31_Perimeter {
    public int islandPerimeter(int[][] grid) {
        int one = 0;
        int two = 0;
        int peri = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    one++;
                    for (int[] dir : dirs) {
                        int row = i + dir[0];
                        int col = j + dir[1];
                        if (row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1) {
                            two++;
                        }
                    }
                }
            }
        }
        return 4 * one - two;
    }
}
