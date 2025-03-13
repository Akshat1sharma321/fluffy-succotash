package TwoDArrayPrac;

public class q3 {
    int[][] rotateMatrix(int M, int N, int Mat[][]) {
        // code here
        //Dekho bhai isme ham pehle first element jo 2nd row ka first hai usse prev me store kara denge uske baad ham pehli row me traverse karenge jisse uske element ek ek shift hojayenge and then uske baad ham row++ kardenge then last col me shifting starting karenge then uske baad ham col ke siize ko ek kam kardenge then usne uske baad ham last row me jayenge traversal ke liye wahaan par ham shifhting karenge uske baad ham row ka size ek minus kardenge uske baad first col me jayenge and shifting karenge agar 3 x 3 hua to iske baad break hojayega ....
        int row  = 0 , col = 0 ; 
        while(row< M&& col<N){
            if(row+1==M || col+1 ==N) break ;
            int prev = Mat[row+1][col] ;
            for(int i = col ; i < N ;i++){
                int curr = Mat[row][i] ;
                Mat[row][i]=prev ;
                prev = curr ;
            }
            row++;
            for(int i = row ; i<M ; i++){
                int curr = Mat[i][N-1] ;
                Mat[i][N-1] = prev ;
                prev = curr ;
            }
            N--;
            for(int i = N-1;i>=col;i--){
                int curr = Mat[M-1][i];
                Mat[M-1][i]=prev ;
                prev= curr;
            }
            M--;
            for(int i = M-1 ; i>=row ; i--){
                int curr = Mat[i][col];
                Mat[i][col]=prev;
                prev=curr;
            }
            col++;
            
        }
        return Mat ; 
    }
}
