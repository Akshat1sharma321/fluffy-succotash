import java.util.ArrayList;

public class pracrec {
    public static void toh(int n, int a, int b, int c) {
        if (n == 0)
            return;
        toh(n - 1, a, c, b);
        System.out.println("moving disc " + n + " from " + a + " to " + c);
        toh(n - 1, b, c, a);
    }

    public static int mtn(int idx, int arr[]) {
        if (idx == arr.length) {
            return Integer.MIN_VALUE;
        }
        int as = mtn(idx + 1, arr);
        return Math.max(arr[idx], as);
    }

    public static int li(int idx, int arr[], int tar) {
        if (idx == arr.length) {
            return -1;
        }
        int lin = li(idx + 1, arr, tar);
        if (lin == -1 && arr[idx] == tar) {
            return idx;
        } else {
            return lin;
        }
    }

    public static int[] pai(int idx, int arr[], int tar, int asf) {
        if (idx == arr.length) {
            int base[] = new int[asf];
            return base;
        }
        int[] ans;
        if (arr[idx] == tar) {
            ans = pai(idx + 1, arr, tar, asf + 1);
        } else
            ans = pai(idx + 1, arr, tar, asf);
        if (arr[idx] == tar) {
            ans[asf] = idx;
        }
        return ans;
    }

    public static ArrayList<String> subs(String s) {
        if (s.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }
        char ch = s.charAt(0);
        String rem = s.substring(1);
        ArrayList<String> smal = subs(rem);
        ArrayList<String> ans = new ArrayList<>();
        for (String ss : smal) {
            ans.add(ch + ss);
        }
        for (String ss : smal) {
            ans.add(ss);
        }
        return ans;

    }

    public static ArrayList<String> allmet(int n) {
        if (n == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        if (n < 0) {
            ArrayList<String> ne = new ArrayList<>();
            return ne;
        }
        ArrayList<String> one = allmet(n - 1);
        ArrayList<String> two = allmet(n - 2);
        ArrayList<String> three = allmet(n - 3);
        ArrayList<String> ans = new ArrayList<>();
        for (String ss : one) {
            ans.add("1" + ss);
        }
        for (String ss : two) {
            ans.add("2" + ss);
        }
        for (String ss : three) {
            ans.add("3" + ss);
        }
        return ans;
    }

    public static ArrayList<String> printallmaze(int sc, int sr, int fc, int fr) {
        if (sc == fc && sr == fr) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        if (sc > fc || sr > fr) {
            ArrayList<String> ans = new ArrayList<>();
            return ans;
        }
        ArrayList<String> ver = printallmaze(sc, sr + 1, fc, fr);
        ArrayList<String> hor = printallmaze(sc + 1, sr, fc, fr);
        ArrayList<String> ans = new ArrayList<>();
        for (String pt : ver) {
            ans.add("v" + pt);
        }
        for (String pt : hor) {
            ans.add("h" + pt);
        }
        return ans;
    }

    public static void perm(String s, String a) {
        if (s.length() == 0) {
            System.out.println(a);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            String rem = left + right;
            perm(rem, a + ch);
        }
    }

    public static ArrayList<String> allMazePathsWithJump(int sc, int sr, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        if (sr > dr || sc > dc) {
            ArrayList<String> emp = new ArrayList<>();
            return emp;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= (dc - sc); i++) {
            ArrayList<String> hori = allMazePathsWithJump(sc + i, sr, dr, dc);
            for (String x : hori) {
                ans.add("h" + i + x);
            }
        }
        for (int i = 1; i <= (dr - sr); i++) {
            ArrayList<String> veri = allMazePathsWithJump(sc, sr + i, dr, dc);
            for (String x : veri) {
                ans.add("v" + i + x);
            }
        }
        for (int i = 1; i <= Math.min((dc - sc), (dr - sr)); i++) {
            ArrayList<String> zig = allMazePathsWithJump(sc + i, sr + i, dr, dc);
            for (String x : zig) {
                ans.add("z" + i + x);
            }
        }
        return ans;
    }

    public static void rosubs(String s, String asf) {
        if (s.length() == 0) {
            System.out.print(asf + " ");
            return;
        }
        char ch = s.charAt(0);
        String rem = s.substring(1);
        rosubs(rem, asf + ch);
        rosubs(rem, asf);
    }

    static String arr[] = { ",,.", "abc", "def" };

    public static void printKbc(String s, String asf) {
        if (s.length() == 0) {
            System.out.print(asf + "  ");
            return;
        }
        String letter = arr[s.charAt(0) - '0'];
        String rem = s.substring(1);
        for (int i = 0; i < letter.length(); i++) {
            char ch = letter.charAt(i);
            printKbc(rem, asf + ch);
        }
    }

    public static void rosteps(int n, String asf) {
        if (n == 0) {
            System.out.println(asf + " ");
            return;
        }
        if (n < 0) {
            return;
        }
        rosteps(n - 1, asf + "1");
        rosteps(n - 2, asf + "2");
        rosteps(n - 3, asf + "3");
    }

    public static void roallmaze(int r, int c, int dr, int dc, String asf) {
        if (r == dr && c == dc) {
            System.out.println(asf);
            return;
        }
        if (r > dr || c > dc) {
            return;
        }
        roallmaze(r + 1, c, dr, dc, asf + "v");
        roallmaze(r, c + 1, dr, dc, asf + "h");
    }

    public static void roallmazepathwithjumps(int r, int c, int dr, int dc, String asf) {
        if (r == dr && c == dc) {
            System.out.print(asf + " ");
            return;
        }
        for (int i = 1; i <= dr - r; i++) {
            roallmazepathwithjumps(r + i, c, dr, dc, asf + "v" + i);
        }
        for (int i = 1; i <= dc - c; i++) {
            roallmazepathwithjumps(r, c + i, dr, dc, asf + "h" + i);
        }
        for (int i = 1; i <= Math.min((dr - r), (dc - c)); i++) {
            roallmazepathwithjumps(r + i, c + i, dr, dc, asf + "z" + i);
        }
    }

    public static void printEncodings(String num, String asf) {
        if (num.length() == 0) {
            System.out.print(asf + " ");
            return;
        }
        int dig = num.charAt(0) - '0';
        char ch = (char) ('a' + (dig - 1));
        String rem  = num.substring(1) ; 
        printEncodings(rem, asf + ch);
        if(num.length()>=2){
            String t  = num.substring(0, 2) ; 
            int n = Integer.parseInt(t) ;
            if(n<=26){
                char cha = (char)('a' + n - 1 );
                String rem2 = num.substring(2) ; 
                printEncodings(rem2 , asf + cha);  
            }
        }

    }

    public static int maxSumPath(int sr  , int sc  ,  int dr  , int dc  ,  int arr[][] ){
        if(sr==dr-1 && sc == dc-1){
            return arr[sr][sc] ; 
        }
        if(sr >= dr || sc >=dc){
            return Integer.MIN_VALUE ; 
        }
        int vert = maxSumPath(sr + 1 , sc, dr, dc, arr ) ; 
        int hori = maxSumPath(sr , sc + 1 , dr, dc, arr);
        int maxSum  =  arr[sr][sc]+ Math.max(vert, hori) ; 
        return maxSum ; 
    }
    public static void main(String[] args) {
        // char a = 2 + 'a' - 1; 
        int arr[][] = {{1,-5,4,10,11},{4,-11,13,3,49},{-19,16,5,14,12},{-14,8,15,19,6}} ; 
        int ans  = maxSumPath(0, 0, 4, 5, arr) ;
        System.out.print(ans) ;
        
    }
}
