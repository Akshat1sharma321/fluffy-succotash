import java.util.ArrayList;

class Edge {
    int u;
    int v;
    int w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return "{" + this.u + " -> " + this.v + ": " + this.w + "}";
    }
}
class Solution {
    public void isVisit(int r , int c , char[][]grid , boolean[][]vis , int n , int m){
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}} ; 
        vis[r][c] = true ; 
        for(int [] dir : dirs){
            int x = dir[0] + r;
            int y = dir[1] + c ; 
            if(  x>=0 && y>=0 && x<n && y<m && !vis[x][y] && grid[x][y]=='1'){
                isVisit(x,y,grid,vis,n,m);
            }
        }
    }
    public int numIslands(char[][] grid) {
       int n = grid.length ; 
       int m = grid[0].length ; 
       boolean [][] vis = new boolean [n][m] ; 
       int count  = 0 ; 
        for(int i = 0 ; i < n ; i++){
            for(int j =  0 ; j < m ; j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    isVisit(i,j,grid,vis , n,m) ; 
                    count++ ; 
                }
            }
        }
        return count ; 
    }
}
class Questions {
    // hasPath =====================================
    public static boolean hasPath_rec(int src, int des, ArrayList<Edge>[] graph, boolean[] vis) {
        if (src == des) {
            return true;
        }

        vis[src] = true;

        boolean hasPath = false;

        for (Edge e : graph[src]) {
            int nbr = e.v;
            if (vis[nbr] == false) {
                hasPath = hasPath || hasPath_rec(nbr, des, graph, vis);
            }
        }

        // vis[src] = false; // not necessory as undirected
        return hasPath;
    }

    public static boolean hasPath(int src, int des, ArrayList<Edge>[] graph, int N) {
        boolean[] vis = new boolean[N];
        return hasPath_rec(src, des, graph, vis);
    }

    //Printing Shortest Path

    public static int shortestPath(int src , int des , ArrayList<Edge>[] graph , boolean[] vis ){
        int distance  = 0 ; 
        if(src==des){
            Edge e = graph[src].get(des) ; 
            return distance +  e.w ; 
        }
        vis[src]=true ;
        for(Edge ch : graph[src]){
            distance = Math.min(distance, shortestPath(ch.u, des, graph, vis)) ;
        }
        vis[src] = false ; 
        return distance ; 
    }
    //Printing Longest Path
    //Printing kth longest path 
    //Printing ceil-floor path of given target 
    //get connected component 
    ArrayList<Integer> getcon(int src , ArrayList<Edge>[] graph, int N , boolean[]vis ,ArrayList<Integer>arr){
        vis[src]=true;
        for(Edge i : graph[src]){
            int ch = i.v ; 
            if(!vis[ch]){
                arr.add(ch) ; 
                getcon(src, graph, N, vis, arr) ; 
            }
        }
        vis[src] = false ; 
        return arr ; 
    }
    ArrayList<ArrayList<Integer>> getConnectedComponents(ArrayList<Edge>[] graph, int N) {
        boolean [] vis  = new boolean[N] ; 
        ArrayList<ArrayList<Integer>>ans = new ArrayList<ArrayList<Integer>>() ; 
        for(int i )
    }

    // Print all paths between source and dest
    // ======================================
    public static void allPaths(int src, int des, ArrayList<Edge>[] graph, String psf, boolean[] vis) {
        if (src == des) {
            System.out.println(psf);
            return;
        }
        vis[src] = true;

        for (Edge e : graph[src]) {
            int nbr = e.v;
            if (!vis[nbr]) {
                allPaths(nbr, des, graph, psf + "->" + nbr, vis);
            }
        }

        vis[src] = false;
    }

    public static void printAllPaths(int src, int des, ArrayList<Edge>[] graph, int N) {
        allPaths(src, des, graph, "" + src, new boolean[N]);
    }

    // Graph construction utils
    // =====================================================
    public static void displayGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Edges on vertex " + i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print(e + ",");
            }
            System.out.println();
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        graph[u].add(new Edge(u, v, w));
        graph[v].add(new Edge(v, u, w));
    }

    public static void main(String[] args) {
        int N = 8;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 1, 2, 11);
        addEdge(graph, 1, 3, 7);
        addEdge(graph, 1, 4, 12);
        addEdge(graph, 2, 4, 9);
        addEdge(graph, 2, 5, 3);
        addEdge(graph, 5, 6, 6);
        addEdge(graph, 5, 7, 5);
        addEdge(graph, 6, 7, 4);

        // displayGraph(graph);
        // System.out.println(hasPath(0,7, graph, N));
        printAllPaths(0, 7, graph, N);
    }
}