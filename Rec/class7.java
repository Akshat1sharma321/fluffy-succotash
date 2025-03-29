public class class7 {
    public static void printAllMazePaths(int row , int col , int dr , int dc , String psf){
        if(row==dr && col==dc){
            System.out.print(psf+" , ");
        }
        
        for(int jump = 1 ; jump <= dc - col ; jump++){
            printAllMazePaths(row, col+jump, dr, dc, psf+"h"+jump);
        }
        for(int jump = 1 ; jump <= dr - row ; jump++){
            printAllMazePaths(row+jump, col, dr, dc, psf+"v"+jump);
        }
        for(int jump = 1 ; jump <= Math.min(dc - col , dr -row) ; jump++){
            printAllMazePaths(row+jump, col+jump, dr, dc, psf+"d"+jump);
        }
    }
    public static void printEncoding(String s , String asf){
        if(s.length()==0){
            System.out.println(asf);
            return ;
        }
        if(s.charAt(0)=='0')return ;
        char fc = s.charAt(0);
        String rem = s.substring(1);
        char cchar = (char)('a'+(fc-1));
        printEncoding(rem,asf+cchar); 
        if(s.length()>=2){
            String tc = s.substring(0,2);
            int ttc = Integer.parseInt(tc) ;
            if(ttc<=26){
                cchar=(char)('a'+(ttc-1));
                rem=s.substring(2);
                printEncoding(s, asf+cchar);
            }
        }

    }
    public static void perm(String str , String asf){
        if(str.length()==0){
            System.out.println(asf);
            return ;
        }
        for(int i = 0 ; i < str.length() ; i++){
            char ch =  str.charAt(i) ; 
            String fs = str.substring(0, i);
            String rs = str.substring(i+1);
            String r = fs + rs ; 
            perm(r, asf+ch);
        }
    }
    public static int maxSumPath(int row , int col  , int n , int m  , int [][] matrix ){
        if(row==n-1 && col==m-1){
            return matrix[row][col] ;
        }
        if(row>=n || col >=m){
            return Integer.MIN_VALUE ; 
        }
        int maxSumforh = maxSumPath(row+1, col, n, m, matrix) ;
        int maxSumforv = maxSumPath(row, col+1, n, m, matrix);
        return matrix[row][col]+ Math.max(maxSumforh,maxSumforv);
    }
    public static void main(String[] args) {
        System.out.println("Hello");
        // printAllMazePaths(0, 0, 4, 4, "");
        // printEncoding("1234", "");
        // perm("abc", "");
        int [][]mat = {{1,-5,4,10,11},{4,-11,13,3,49},{-19,16,5,14,12},{-14,8,15,19,6}};
        int ans  = maxSumPath(0, 0, 4, 5, mat);
        System.out.println(ans);
    }
}
