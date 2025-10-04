import java.util.ArrayList;
class Edge{
    int u  ; 
    int v ; 
    int w ; 
    Edge(){}
    Edge(int u , int v , int w){
        this.u = u  ; 
        this.v = v ; 
        this.w = w ; 
    }
}
public class Question27_PrintAllPaths {
    static int min = Integer.MIN_VALUE ; 
    public static void printpath(boolean [] visited ,  int des , int src , String psf , ArrayList<Edge>[] graph , int curr){
       if(src == des){
        System.out.println(psf);
        if(min<curr){
            min=curr ; 
        }
        return  ; 
       } 
       visited[src] = true ; 
       for(Edge e : graph[src]){
        int nbr = e.v ; 
        int minwt = e.w ; 
        if(visited[nbr]==false){
            printpath(visited, des, nbr, psf + "--> " + nbr, graph , curr+minwt);
        }
       }
       visited[src]= false ; 
    }
 public static void main(String[] args) {
        int[][] adjMat = new int[8][8];
        int [][] adM = {{0,1,10} , {1,2,11} , {1,3,7} , {1,4,2} , {2,4,9} , {2,5,13} , {5,6,6} , {6,7,4} , {5 , 7 , 15}} ; 
        for(int i = 0 ; i < adM.length ; i++){
            adjMat[adM[i][0]][adM[i][1]] = adM[i][2]; 
            adjMat[adM[i][1]][adM[i][0]] = adM[i][2];
        }
        int n  = adjMat.length ; 
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int[]row : adjMat){
            for(int i : row){
                System.out.print(i + " , ");
            }
            System.out.println();
        }
        for(int i = 0  ; i  <  n ;  i++){
            graph[i] = new ArrayList<>() ; 
        }
        for(int u = 0  ;  u < n ; u++){
            for(int v =  0  ; v < n ; v++){
                if(adjMat[u][v]!=0){
                    graph[u].add(new Edge(u ,v, adjMat[u][v])) ; 
                }
            }
        }
        for(int  i  = 0 ;  i < n  ; i++){
            ArrayList<Edge> row = graph[i] ; 
            System.out.print(i + " --- >");
            for(Edge j : row){
                System.out.print(j.v + " , ");
            }
            System.out.println();
        }
        boolean [] vis = new boolean[n] ;
        printpath(vis, 6, 0, ""+ 0, graph , 0 );
        System.out.println(min);
    }
 
}
