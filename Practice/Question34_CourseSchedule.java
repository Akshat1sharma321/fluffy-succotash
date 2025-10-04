import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class Question34_CourseSchedule {
     public boolean kahn(ArrayList<Integer>[] graph , int[]indeg , int n ){
        Queue<Integer>q = new LinkedList<>() ; 
        ArrayList<Integer>an = new ArrayList<>() ; 
        for(int i = 0  ;  i < n ; i++){
            if(indeg[i]==0) q.offer(i) ; 
           
        }
        while(q.size() > 0 ){
            int size = q.size() ; 
            while(size-->0){
                int src = q.poll() ; 
                 an.add(src) ; 
                for(int nbr : graph[src]){
                    if(--indeg[nbr] == 0) q.offer(nbr) ; 
                }
            }
        }
        if(an.size()==n) return true ; 
        else return false  ; 
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[]graph = new ArrayList[numCourses] ; 
        for(int i =  0 ; i < numCourses ; i++){
            graph[i] = new ArrayList<>() ; 
        }
        int[]indeg = new int[numCourses] ; 
        for(int i = 0 ; i  < prerequisites.length ; i++){
            int v = prerequisites[i][0] ; 
            int u  = prerequisites[i][1] ; 
            graph[u].add(v) ; 
            indeg[v]++  ; 
        }
        return kahn(graph , indeg , numCourses) ; 
    }
}
