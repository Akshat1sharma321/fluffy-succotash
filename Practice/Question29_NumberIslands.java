public class Question29_NumberIslands {
    public void dfs(int idx, boolean[] visited, char[][] grid, int[][] dirs) {
        int n = grid.length;
        int m = grid[0].length;
        int x = idx / m;
        int y = idx % m;
        visited[idx] = true;
        for (int[] direc : dirs) {
            int row = x + direc[0];
            int col = y + direc[1];
            if (row >= 0 && row < n && col >= 0 && col < m && visited[row * m + col] != true && grid[row][col] == '1') {
                dfs(row * m + col, visited, grid, dirs);
            }
        }

    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        boolean[] visited = new boolean[n * m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i * m + j] == false && grid[i][j] == '1') {
                    count++;
                    dfs(i * m + j, visited, grid, dirs);
                }
            }
        }
        return count;
    }
}
