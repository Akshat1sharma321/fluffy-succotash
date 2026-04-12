
import java.util.*;

class Edge {
    int u;
    int v;
    int w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

public class dijikstra {
    public static class Pair {
        int par;
        int vtx;
        int wsf;

        Pair(int par, int vtx, int wsf) {
            this.par = par;
            this.vtx = vtx;
            this.wsf = wsf;
        }
    }

    public static int[] diji(ArrayList<Edge>[] graph, int N, int src) {
        int[] dis = new int[N];
        int[] par = new int[N];
        Arrays.fill(dis, (int) 1e8);
        Arrays.fill(par, -1);
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> {
            return a.wsf - b.wsf;
        });
        dis[src]= 0 ; 
        pq.add(new Pair(-1, 0, 0));
        while (pq.size() > 0) {
            Pair curr = pq.poll();
            int parent = curr.par;
            int vtx = curr.vtx;
            int wsf = curr.wsf;
            if (dis[vtx] < wsf)
                continue;
            if (parent != -1) {
                par[vtx] = parent;
            }
            for (Edge e : graph[vtx]) {
                int v = e.v;
                int w = e.w;
                if (dis[v] > wsf + w) {
                    dis[v] = wsf + w;
                    pq.add(new Pair(vtx, v, wsf + w));
                }
            }
        }
        // for(int  i : par){
        //     System.out.print(i + " --->");
        // }
        // System.out.println();
        return dis;
    }

    public static void main(String[] args) {
        // int[][] edges = { { 0, 6, 9 }, { 6, 2, 11 }, { 1, 2, -1 }, { 0, 1, 8 }, { 2, 3, 5 }, { 3, 4, 9 }, { 3, 5, 13 },
        //         { 4, 5, 7 }, { 5, 7, 41 }, { 7, 8, 53 } };
        int[][] edges = { {0,1,2} , {0,2,4} , {1,3,1} , {2,3,-3}};
        int N = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[N];
        for(int i  = 0 ; i  < N ; i++){
            graph[i] = new ArrayList<>() ; 
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            addEdge(graph, u, v, w);
        }
        int [] distance  = diji(graph, N, 0) ; 
        for(int i  : distance){
            System.out.print(i + "---> ");
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        graph[u].add(new Edge(u, v, w));
        // graph[v].add(new Edge(u, v, w));
    }

    public static boolean checkPalin(String s , int l , int r){
        boolean one_removed = false ; 
        while(l<=r){
            if(s.charAt(l)==s.charAt(r)){
                l++ ; 
                r-- ; 
            }else if(one_removed == false){
                if(l!=r){
                    if((s.charAt(l+1)==s.charAt(r)) ||( s.charAt(r-1)==s.charAt(l))){
                        one_removed = true ; 
                        l++ ; 
                        r-- ; 
                        continue ; 
                    }
                    else return false  ; 
                }
            }else return false  ; 
        }
        return true ; 
    }

    public static void displayGraph() {

    }

}
