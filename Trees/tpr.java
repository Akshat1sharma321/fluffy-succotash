import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class TreeNode{
    int data ; 
    ArrayList<TreeNode>child ; 
    TreeNode(int data){
        this.data = data ; 
        this.child = new ArrayList<>() ; 
    }
}
public class tpr {
    public static void display(TreeNode root){
        System.out.print(root.data + "-->");
        for(TreeNode ch : root.child){
            System.out.print(ch.data + ",");
        }
        System.out.println(".");
        for(TreeNode ch : root.child){
            display(ch);
        }
    }
    public static int size(TreeNode root){
        int cnt  = 0 ; 
        for(TreeNode i : root.child){
            cnt+=size(i) ; 
        }
        return cnt + 1 ;
    }
    // public static int maxi(TreeNode root){
    //     int maxim = Integer.MIN_VALUE ; 
    //     for(TreeNode i : root.child){
    //         maxim = Math.max(i.data, maxi(i)) ;
    //     }
    //    return Math.max(root.data, maxim) ;    
    // }
    
    public static int maxi(TreeNode root) {
        int maxim = Integer.MIN_VALUE;
        for (TreeNode i : root.child) {
            maxim = Math.max(maxim, maxi(i));
        }
        return Math.max(maxim, root.data);
    }
    public static int height(TreeNode root){
        int ht = 0 ; 
        if(root==null) return -1 ; 
        ht = -1  ; 
        for(TreeNode i : root.child){
            ht = Math.max(ht, height(i)) ; 
        }
        return ht + 1 ; 
    }
    public static void et(TreeNode root){
        System.out.println("Preorder -->" + root.data);
        for(TreeNode i : root.child){
            System.out.println("Moving from parent " + root.data + " to " + i.data);
            et(i);
            System.out.println("Moving from child " + i.data + " to " + root.data);
        }
        System.out.println("Postorder -->" + root.data);
    }
    public static void levelorder(TreeNode root){
        // if(root== null) return  ; 
        LinkedList<TreeNode>q = new LinkedList<>() ; 
        q.addLast(root);
        while(q.size()>0){
            TreeNode front = q.removeFirst() ; 
            System.out.print(front.data + " , ");
            for(TreeNode i : front.child){
                q.addLast(i);
            }
        }
    }
    public static void linewise(TreeNode root){
        // if(root==null)return ; 
        LinkedList<TreeNode>q = new LinkedList<>() ; 
        q.addLast(root);
        int level = 0 ; 
        TreeNode temp = null ; 
        q.addLast(temp);
        while (q.size()>0) {
            TreeNode front = q.removeFirst() ; 
            if(front == null){
                System.out.println(" Level " + level + ".end" );
                level=level+1 ;
                if(q.size()>0){
                    q.addLast(temp);
                }
            }
            else{
                System.out.print(front.data + " , ");
                for(TreeNode i : front.child){
                    q.addLast(i);
                }
            }
        }
    }
    //Method 2 of the same manner 
    /* public static void linewise(TreeNode root) {
        // if(root==null)return ;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        int level = 0;
        TreeNode temp = null;
        q.addLast(temp);
        while (q.size() > 1) {
            TreeNode front = q.removeFirst();
            if (front == null) {
                System.out.println(" Level " + level + ".end");
                level = level + 1;
                    q.addLast(temp);
            } else {
                System.out.print(front.data + " , ");
                for (TreeNode i : front.child) {
                    q.addLast(i);
                }
            }
        }
    } */
   public static void linewisecnt(TreeNode root){
    LinkedList<TreeNode>q = new LinkedList<>() ; 
    q.addLast(root);
    while(q.size()>0){
        int cnt  = q.size() ;
        while(cnt-->0){
            TreeNode front = q.removeFirst() ; 
            System.out.print(front.data + " , ");
            for(TreeNode i : front.child){
                q.addLast(i);
            }
        }
        System.out.println();
    }
   }
    public static void linewiseQpc(TreeNode root){
        LinkedList<TreeNode>pq = new LinkedList<>() ; 
        LinkedList<TreeNode>cq = new LinkedList<>() ; 
        int level = 0 ; 
        pq.addLast(root);
        while(pq.size()>0){
            TreeNode front = pq.removeFirst() ; 
            System.out.print(front.data + " , ") ; 
            for(TreeNode i : front.child){
                cq.addLast(i) ; 
            }
            if(pq.size()==0 && cq.size() > 0 ){
                System.out.println(" Level : " + level +  " .end ");
                level++ ; 
                pq = cq ; 
                cq = new LinkedList<>()  ; 
            }
        }
    }
   public static void ZigZagTraversal(TreeNode root){
    int  cnt = 1 ; 
    LinkedList<TreeNode>q = new LinkedList<>() ; 
    q.addLast(root);
    while(q.size()>0){
        int sz = q.size() ;
        while (sz-->0) {
            TreeNode front = q.removeFirst() ; 
            System.out.print(front.data + " , ");
            //Error is that I am reversing the level but the child while reversing are getting damaged thay are not getting reverssed properly .
            if(cnt%2==0){
                for(TreeNode i : front.child){
                    q.addLast(i);
                }
            }
            else{
                for(int i = front.child.size()-1 ; i>=0 ; i--){
                    q.addLast(front.child.get(i));
                }
            }
        }
        System.out.println();
        cnt++ ;
    }
   }
   public static void ZigZagCorr(TreeNode root){
    Stack<TreeNode>ms = new Stack<>() ; 
    Stack<TreeNode>cs = new Stack<>() ; 
    int level = 1 ; 
    ms.push(root) ; 
    while(ms.size()>0){
        TreeNode front = ms.pop() ; 
        System.out.print(front.data + " , ");
        if(level%2==1){
            for(int i = 0 ; i < front.child.size() ; i++){
                cs.push(front.child.get(i)) ; 
            }
        }
        else{
            for(int i = front.child.size() -1 ; i>= 0 ; i--){
                cs.push(front.child.get(i));
            }
        }

        if(ms.size()==0 && cs.size()>0){
            System.out.println();
            ms = cs ; 
            cs = new Stack<>() ; 
            level++ ; 
        }
    }
   } 
   //Mirror of the generic tree 
   public static TreeNode mirror(TreeNode root){
    int i = 0 ; 
    int j = root.child.size() - 1 ; 
    while(i<=j){
        TreeNode childAti = mirror(root.child.get(i)) ; 
        TreeNode childAtj = mirror(root.child.get(j)) ; 
        root.child.set(i, childAtj) ; 
        root.child.set(j, childAti) ; 
        i++ ; 
        j-- ;
    }
    return root ; 
   }
   //Remove Leaf Nodes
   public static TreeNode rln(TreeNode root){
    
    for(int i = root.child.size() - 1 ; i >=0 ; i--){
        TreeNode childe = root.child.get(i) ;
        if(childe.child.size()==0){
            root.child.remove(i) ; 
        }
    }
    for (TreeNode i : root.child) {
        rln(i);
    }
    return root ; 
   }
   //Linearise the list 
   public static TreeNode linearise(TreeNode root){
    for(TreeNode i  : root.child){
        linearise(i) ; 
    }
    while (root.child.size() > 1 ) {
        TreeNode last = root.child.remove(root.child.size() - 1) ; 
        TreeNode seclasttail = getTail(root.child.get(root.child.size()-1)) ; 
        seclasttail.child.add(last) ; 
    }
    return root ;
   }
   public static TreeNode getTail(TreeNode root){
    TreeNode temp = root ; 
    while(temp.child.size()>0){
        temp = temp.child.get(0) ; 
    }
    return temp ;
   }
   //Linearise part 2 optimised 
   public static TreeNode linearise2(TreeNode root){
    if(root.child.size()==0)return root ; 
    TreeNode lastChildTail = linearise2(root.child.get(root.child.size())) ; 
    while(root.child.size()>1){
        TreeNode lastChil = root.child.remove(root.child.size()-1) ;
        TreeNode secLast = root.child.get(root.child.size()-1) ; 
        TreeNode secLastTail =linearise2(secLast) ; 
        secLastTail.child.add(lastChil) ; 
    }
    return lastChildTail ; 
   }
   //Find In Generic Tree
   public static boolean find(TreeNode root ,int val){
    if(root.data==val){
        return true ; 
    }
    for(TreeNode i : root.child){
        if(find(i, val)==true)return true;
    }
    return false ;
   }
   //Node to root path
   public static ArrayList<Integer> ntr(TreeNode root , int target){
    if(root.data== target){
        ArrayList<Integer>bans = new ArrayList<>() ; 
        bans.add(root.data) ; 
        return bans ; 
    }
    for(TreeNode i : root.child){
        ArrayList<Integer>subPath = ntr(i, target) ; 
        if(subPath.size()>0){
            subPath.add(i.data) ; 
            return subPath ; 
        }
    }
    return new ArrayList<>() ; 
   }
   //Find lowest common Ancesstor
   public static Integer lca(TreeNode root , int tar1 , int tar2){
    ArrayList<Integer>ntr1 = ntr(root, tar1) ; 
    ArrayList<Integer>ntr2 = ntr(root, tar2) ; 
    if(ntr1.size()==0 || ntr2.size()==0){
        System.out.println("No LCA");
        return 0 ; 
    }
    int i = ntr1.size() -1 ; 
    int j = ntr2.size() - 1 ; 
    while(i>=0 && j>=0 && ntr1.get(i)==ntr2.get(j)){
        i--;
        j--;
    }
    j++;
    return ntr2.get(j) ;
   }
   //Is Symmettric
   public static boolean isMirror(TreeNode n1 , TreeNode n2){
    if(n1.child.size()!=n2.child.size() || n1.data!=n2.data){
        return false ; 
    }
    for(int i  = 0 ; i <= n1.child.size()-1 ;i++){
        TreeNode one = n1.child.get(i) ; 
        TreeNode two = n2.child.get(n1.child.size()-i) ;
        if(isMirror(one, two)==false){
            return false  ; 
        }
    }
    return true ; 
   }
   public static boolean isSymmetric(TreeNode root){
    return isMirror(root, root) ; 
   }
   public static void main(String[] args) {
        int []arr = {10,20,80,-1,-1,30,50,-1,60,-1,-1,40,90,-1,100,120,-1,130,-1,-1,110} ; 
        Stack<TreeNode>st = new Stack<>(); 
        TreeNode root = null ;
        for(int i = 0 ; i < arr.length ; i++){
            int num = arr[i] ; 
            if(num==-1){
                st.pop() ; 
            }
            else{
                TreeNode ne = new TreeNode(num) ; 
                if(st.size()==0){
                    root = ne ; 
                }
                else{
                    st.peek().child.add(ne) ; 
                }
                st.push(ne) ; 
            } 
        }
        
        // display(root);
        // System.out.println(size(root));
        // System.out.println(maxi(root));
        // System.out.println(height(root));
        // et(root);
        // levelorder(root);
        // System.out.println();
        // linewise(root);
        // System.out.println();
        // linewiseQpc(root);
        // System.out.println();
        // linewisecnt(root);
        // System.out.println();
        // ZigZagCorr(root);
        // mirror(root) ; 
        // rln(root) ;
        linearise(root) ;
        display(root);
    }
}
