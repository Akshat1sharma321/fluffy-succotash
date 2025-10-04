public class Question42_NumberQueens {
    public int totQueens(boolean[] rowvis, boolean[] colvis, boolean[] diagvis, boolean[] adiagvis, int n, int col) {
        if (col == n)
            return 1;
        int tot = 0;
        for (int i = 0; i < n; i++) {
            if (!rowvis[i] && !colvis[col] && !diagvis[i - col + n - 1] && !adiagvis[i + col]) {
                rowvis[i] = true;
                colvis[col] = true;
                diagvis[i - col + n - 1] = true;
                adiagvis[i + col] = true;
                tot += totQueens(rowvis, colvis, diagvis, adiagvis, n, col + 1);
                rowvis[i] = false;
                colvis[col] = false;
                diagvis[i - col + n - 1] = false;
                adiagvis[i + col] = false;

            }
        }
        return tot;
    }

    public int totalNQueens(int n) {
        boolean[] rowvis = new boolean[n];
        boolean[] colvis = new boolean[n];
        boolean[] diagvis = new boolean[n + n - 1];
        boolean[] adiagvis = new boolean[n + n - 1];
        return totQueens(rowvis, colvis, diagvis, adiagvis, n, 0);
    }
}
