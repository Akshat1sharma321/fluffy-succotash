import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

class DSU{
    int [] par  ; 
    int [] size ; 
    DSU(int n){
        par = new int[n] ; 
        size = new int[n] ; 
        for(int i  = 0 ;  i < n  ; i++){
            par[i] =  i ; 
            size[i] =  1 ;
        }
    }
    int findPar(int u){
        if(par[u]==u) return u ; 
        else return par[u] = findPar(par[u]) ; 
    }
    void merge(int u , int v){
         u  = findPar(u) ; 
         v = findPar(v) ; 
         if( u == v) return  ; 
        if(size[u] < size[v]){
            par[u] = v ;  
            size[v]+=size[u] ; 
        }else{
            par[v] = u ; 
            size[u]+=size[v] ; 
        }
    }

}

public class graphy {
    public static void dfs(ArrayList<Integer>[]adj , int node , int[] visited){
        visited[node] = 1 ; 
        for(int i : adj[node]){
            if(visited[i]==0){
                dfs(adj , i , visited) ; 
            }
        }
    }
    
    public static boolean dfsCycle(ArrayList<Integer>[] adj, int par  , int node, int[] visited) {
        visited[node] = 1;
        for (int i : adj[node]) {
            if(i == par) continue  ; 
            else if(visited[i]==1)  return true  ; 
            else if (visited[i] == 0) {
                if(dfsCycle(adj, par , i, visited)==true) return true ;
            }
        }
        return false  ; 
    }

    public static void bfs(ArrayList<Integer>[] adj , int node , int [] visited){
        visited[node] = 1 ; 
        Queue<int []>q= new LinkedList<>() ; 
        int level = 0 ;  
        q.add(new int[]{-1,node}) ; 
        while(q.size()>0){
            int sz = q.size() ; 
            while(sz-->0){
                int[] curr = q.poll() ; 
                int par = curr[0] ; 
                // par = par ; 
                int u = curr[1] ; 
                for(int n : adj[u]){
                    if(visited[n]==0){
                        q.add(new int []{u , n}) ; 
                        visited[n] = 1 ; 
                    }
                }
            }
            level++  ;
        }
      
    }


    public static void topoDFS(ArrayList<Integer>[]adj , ArrayList<Integer>ans , int node , int [] visited ){
        visited[node] = 1 ; 
        for(int n : adj[node]){
            if(visited[n]==0){
                topoDFS(adj, ans, n, visited);
            }
        }
        ans.add(node) ; 
    }

    public static void topoBFS(ArrayList<Integer>[]adj){
        int [] indeg = new int [adj.length] ; 
        for(int i  = 0 ; i < adj.length ; i++){
            for(int n : adj[i]){
                indeg[n]++ ; 
            }
        }
        Queue<Integer>q = new LinkedList<>() ; 
        for(int i  =  0 ; i  < adj.length ; i++){
            if(indeg[i]==0)q.add(i) ; 
        }
        ArrayList<Integer>ans = new ArrayList<>() ; 
        while(q.size()>0){
            int curr = q.poll() ; 
            ans.add(curr) ; 
            for(int n : adj[curr]){
                indeg[n]-- ; 
                if(indeg[n]==0){
                    q.add(n) ; 
                }
            }
        }
    }
    public static  void main(String[]args){
        System.out.println("Hello");
       
    }
}
