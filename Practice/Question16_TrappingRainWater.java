public class Question16_TrappingRainWater {
    public int trap_B(int[] height) {
        int n = height.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(height[i - 1], lmax[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(height[i + 1], rmax[i + 1]);
        }
        int totWat = 0;
        for (int i = 1; i < n; i++) {
            totWat += Math.max(0, Math.min(lmax[i], rmax[i]) - height[i]);
        }
        return totWat;
    }
    //Optimised
    public int trap(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int lmax = height[i];
        int rmax = height[j];
        int maxW = 0;
        while (i < j) {
            if (lmax <= rmax) {
                maxW += lmax - height[i];
                i++;
                lmax = Math.max(lmax, height[i]);
            } else {
                maxW += rmax - height[j];
                j--;
                rmax = Math.max(rmax, height[j]);
            }
        }
        return maxW;

    }
}
