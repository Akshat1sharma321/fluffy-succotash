import java.util.ArrayList;

public class Question28_ConnectedComponent {
    class Solution {
    public void dfs(int src , ArrayList<Integer> curr , ArrayList<Integer>[]graph , boolean[] visited){
        visited[src]= true ;
        curr.add(src) ; 
        for(int nbr : graph[src]){
            if(visited[nbr]==false){
                dfs(nbr , curr , graph , visited) ; 
            }
        }
    }
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[V] ; 
        for(int i = 0  ;  i   <  V ; i ++){
            graph[i] = new  ArrayList<>() ; 
        }
        for(int i = 0  ; i < edges.length ; i++){
                int u = edges[i][0] ; 
                int v = edges[i][1] ; 
                graph[u].add(v) ; 
                graph[v].add(u) ; 
            }
        boolean [] visited = new boolean[V] ; 
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>() ; 
        for(int i  = 0  ; i < V  ; i++){
            ArrayList<Integer>curr = new ArrayList<>() ; 
            if(visited[i]==false){
                dfs(i , curr , graph ,visited) ; 
            }
            if(curr.size()>0)
            ans.add(curr) ; 
        }
        return ans  ; 
    }
}
}
