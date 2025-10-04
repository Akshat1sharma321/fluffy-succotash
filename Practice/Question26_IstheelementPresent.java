import java.util.ArrayList;

class Edge {
    int u;
    int v;
    int w;

    Edge() {
    };

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
};

public class Question26_IstheelementPresent {
    public static Boolean hasPath(int src , int des  ,  ArrayList<Edge>[]graph , boolean[]vis){
        if(src == des) return true  ; 
        vis[src] = true ; 
        boolean hasPatht = false ; 
        for(Edge i : graph[src]){
            int nbr = i.v ; 
            if(vis[nbr]==false){
                 hasPatht = hasPatht || hasPath(nbr, des, graph, vis) ; 
            }
        }
        vis[src] = false ; 
        return hasPatht ; 
    }
    public static void main(String[] args) {
        int[][] adjMat = new int[8][8];
        adjMat[0][1] = 10;
        adjMat[1][0] = 10;
        adjMat[1][2] = 7;
        adjMat[2][1] = 7;
        adjMat[1][3] = 11;
        adjMat[3][1] = 11;
        adjMat[2][4] = 9;
        adjMat[4][2] = 9;
        adjMat[5][6] = 5;
        adjMat[6][5] = 5;
        adjMat[6][7] = 6;
        adjMat[7][6] = 6;
        adjMat[7][5] = 4;
        adjMat[5][7] = 4;
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
        System.out.println(hasPath(0, 9, graph, vis));
    }

}
