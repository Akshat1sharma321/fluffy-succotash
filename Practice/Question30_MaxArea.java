public class Question30_MaxArea {
    public int dfs(boolean[] visited, int[][] grid, int index) {
        int x = index / grid[0].length;
        int m = grid[0].length;
        int y = index % grid[0].length;
        visited[index] = true;
        int ar = 1;
        int[][] dirs = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
        for (int[] direc : dirs) {
            int row = x + direc[0];
            int col = y + direc[1];
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1
                    && visited[row * m + col] == false) {
                ar += dfs(visited, grid, row * m + col);
            }
        }
        return ar;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max_area = 0;
        boolean[] visited = new boolean[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i * m + j] == false) {
                    int area = 0;
                    area = dfs(visited, grid, i * m + j);
                    max_area = Math.max(area, max_area);
                }
            }
        }
        return max_area;
    }
}
