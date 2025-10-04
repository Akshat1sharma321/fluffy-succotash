import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.LinkedList;
import java.util.List;
// import java.util.Map;
// import java.util.Queue;
// import java.util.Set;
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Question23_GetKleveldown {
    /**
 * Definition for a binary tree node.
 * 
 */
class Solution {
    public ArrayList<TreeNode> ntr(TreeNode root , TreeNode target){
        if(root == null) return new ArrayList<TreeNode>() ; 
        if(root.equals(target)){
            ArrayList<TreeNode>ans  = new ArrayList<>()  ; 
            ans.add(root) ; 
            return ans  ; 
        }
        ArrayList<TreeNode>l = ntr(root.left, target) ; 
        if(l.size()!=0) {
            l.add(root) ; 
            return l  ; 
        }
        ArrayList<TreeNode>r = ntr(root.right , target) ; 
        if(r.size()!=0){
            r.add(root) ; 
            return r ; 
        }
        return new ArrayList<>() ; 
    }
    public void getKlev(TreeNode root , TreeNode blocker , int k ,  ArrayList<Integer> res){
        if(root == null || k < 0) return  ; 
        if(root.equals(blocker)) return  ; 
        if(k == 0){
            res.add(root.val) ; 
            return  ; 
        }
        getKlev(root.left , blocker , k -1 , res) ; 
        getKlev(root.right , blocker , k - 1 , res) ; 
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> arr = ntr(root, target) ;
        ArrayList<Integer> res = new ArrayList<>()  ;  
        for(int i = 0  ; i < arr.size() ; i++){
            TreeNode curr = arr.get(i) ; 
            TreeNode blocker = i == 0 ? null : arr.get(i-1) ; 
            getKlev(curr , blocker , k - i , res ) ; 
        }
        return res ; 
    }
}
///Approach 2nd
/// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */
// class Solution {
//     public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//         HashMap<TreeNode , TreeNode > parent  = new HashMap<>() ; 
//         buildParent(null , parent , root) ;
//         Queue<TreeNode>q = new LinkedList<>()  ; 
//         Set<TreeNode>visited  = new HashSet<>() ; 
//         q.offer(target) ; 
//         int dist = 0  ; 
//         visited.add(target) ; 
//         while(q.size()!=0){
            
//             int sz = q.size()  ;
//             if(dist==k){
//                 break ; 
//             }
//             for(int i = 0 ; i < sz ; i++){
//             TreeNode curr = q.poll() ; 
//             if(curr.left !=null && visited.add(curr.left)){
//                 q.offer(curr.left) ; 
//             }
//             if(curr.right != null && visited.add(curr.right)){
//                 q.offer(curr.right) ; 
//             }
//             if(parent.get(curr)!=null && visited.add(parent.get(curr))){
//                 q.offer(parent.get(curr)) ; 
//             } 
//             }
//             dist++ ; 
//         }

//         List<Integer>ans = new ArrayList<>() ; 
//         while(q.size()!=0){
//             ans.add(q.poll().val) ; 
//         }
//         return ans ; 
//     }
//     public void buildParent(TreeNode par , Map<TreeNode , TreeNode> parent , TreeNode child){
//         if(child == null) return  ; 
//         parent.put(child, par) ; 
//         buildParent(child , parent , child.left) ; 
//         buildParent(child , parent , child.right) ; 
//     }
}
