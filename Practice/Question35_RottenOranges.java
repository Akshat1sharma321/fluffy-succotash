import java.util.LinkedList; 
import java.util.Queue; 
public class Question35_RottenOranges {
    class Solution {
        public int orangesRotting(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            // int freshOranges = 0;
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 2) {
                        q.offer(i * m + j);
                    }
                }
            }
            int[][] dirs = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };
            int level = 0;
            while (q.size() > 0) {
                int sz = q.size();
                while (sz-- > 0) {
                    int idx = q.poll();
                    int x = idx / m;
                    int y = idx % m;
                    for (int[] direc : dirs) {
                        int row = x + direc[0];
                        int col = y + direc[1];
                        if (row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1) {
                            q.offer(row * m + col);
                            grid[row][col] = 2;
                        }
                    }
                }
                level++;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1)
                        return -1;
                }
            }
            return level == 0 ? 0 : level - 1;
        }
    }
}
