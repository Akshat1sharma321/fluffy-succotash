import java.util.ArrayList;
public class Question33_ImplementTOPO {
    public static void topo_dfs(ArrayList<Integer>[]graph , boolean [] vis , ArrayList<Integer>topo ,  int src ){
        vis[src] = true ; 
        for(int e  : graph[src]){
            if(vis[e]==false){
                topo_dfs(graph , vis , topo , e) ; 
            }
        }
        topo.add(src) ; 
    }
    public static void main(String[] args) {
        int[][]adj = {{5,11},{11,2},{7,8},{8,9},{3,10},{5,7},{7,3},{5,8},{11,10},{11,9}} ; 
        int v = 12 ; 
        ArrayList<Integer>[]graph = new ArrayList[v] ; 
        for(int i = 0  ; i  < v ; i++){
            graph[i] = new ArrayList<>() ; 
        }
        for(int[] e : adj){
            int u = e[0] ; 
            int t = e[1] ; 
            graph[u].add(t) ; 
        }
        for(int i = 0 ;  i < v ; i++){
            System.out.print(i + "--> ");
            for(int ver : graph[i]){
                System.out.print(ver + " , ");
            }
            System.out.println();
        }
        ArrayList<Integer>top = new ArrayList<>() ; 
        boolean [] vis = new boolean[v] ; 
        for(int i = 0  ; i < v ; i++){
            if(vis[i]!=true){
                topo_dfs(graph, vis, top, i);
            }
        }
        int st = 0 ; 
        int en = top.size() -1 ; 
        while(st<en){
            int temp = top.get(st) ; 
            top.set(st, top.get(en)) ; 
            top.set(en ,temp) ; 
            st++ ;
            en-- ; 
        }
        System.out.println("==== TopoDFS =====");
        for(int i : top){
            System.out.print(i + "--> ");
        }
        
    }
}
