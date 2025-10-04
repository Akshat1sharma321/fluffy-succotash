import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}  
public class Question25_TimetoBurnTree {
    public static void buildParent(Node par , Node child , Map<Node , Node>parent){
        if(child==null) return  ; 
        parent.put(child, par) ; 
        buildParent(child , child.left , parent) ; 
        buildParent(child , child.right , parent) ; 
    }
    public static Boolean find(Node root , int target , Node ans[]){
        if(root == null)  return false ; 
        if(root.data == target){
            ans[0] = root ; 
            return true ; 
        }
        Boolean left = find(root.left , target , ans) ; 
        Boolean right  = find(root.right , target , ans) ; 
        return left || right ; 
        
    }
    public static int minTime(Node root, int target) {
        Node [] an = new Node[1] ; 
        find(root, target , an) ; 
        Node tar = an[0] ; 
        // code here
        Map<Node , Node> parent = new HashMap<>() ; 
        buildParent(null , root , parent) ; 
        Queue<Node> q  = new LinkedList<>() ; 
        Set<Node>visited = new HashSet<>() ; 
        q.offer(tar)  ; 
        visited.add(tar) ; 
        int dist = 0  ; 
        while(q.size()!=0){
            int sz = q.size() ; 
            for(int i = 0  ; i < sz ; i++){
              Node curr = q.poll() ; 
              if(curr.left != null && visited.add(curr.left)){
                  q.offer(curr.left) ; 
              }
              if(curr.right !=null && visited.add(curr.right)){
                  q.offer(curr.right) ; 
              }
              if(parent.get(curr)!=null && visited.add(parent.get(curr))){
                  q.offer(parent.get(curr)) ; 
              }
            }
            dist++ ; 
        }
        return dist - 1 ; 
    }
}
