import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue ;
public class Question36_CourseScheduletwo {
     public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[]graph = new ArrayList[numCourses] ; 
        for(int i  = 0  ; i  < numCourses ; i++) graph[i] = new ArrayList<>()  ; 
        int[]indeg = new int[numCourses] ; 
        for(int [] e  : prerequisites){
            int v = e[0] ; 
            int u = e[1] ; 
            graph[u].add(v) ; 
            indeg[v]++ ; 
        }
        Queue<Integer>q = new LinkedList<>() ;  
        for(int i =  0  ; i   < numCourses ; i++){
            if(indeg[i]==0) q.offer(i) ; 
        }
        ArrayList<Integer>an = new ArrayList<>() ; 
        while(q.size()>0){
            int src = q.poll() ; 
            an.add(src)  ; 
            for(int nbr : graph[src]){
                indeg[nbr]-- ; 
                if(indeg[nbr] == 0) q.offer(nbr) ; 
            }
        }
        int [] ans = new int [numCourses] ; 
        for(int i = 0 ; i < an.size() ; i++) ans[i] = an.get(i) ;  
        if(an.size()<numCourses) return new int[]{} ;
        else return ans ; 

    }
}
