
import java.util.*;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

class treeNode {
    int val;
    ArrayList<treeNode> child;

    treeNode(int val) {
        this.val = val;
        this.child = new ArrayList<>();
    }
}

public class treesPractice {
    treesPractice() {
    }

    class Node {
        int val;
        Node right;
        Node left;

        Node(int val) {
            this.val = val;
        }
    }

    private Node node;

    public void populate(Scanner scanner) {
        System.out.println("Enter the root node");
        int val = scanner.nextInt();
        node = new Node(val);
        populate(scanner, node);
    }

    private void populate(Scanner scanner, Node root) {
        System.out.println("Do you want to enter the value of left child ?");
        Boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value of left child");
            int lc = scanner.nextInt();
            root.left = new Node(lc);
            populate(scanner, root.left);
        }
        System.out.println("Do you want to enter the value of right child ?");
        Boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value of right child");
            int lc = scanner.nextInt();
            root.right = new Node(lc);
            populate(scanner, root.right);
        }
    }

    public void display() {
        System.out.println(node.val + "");
        display(node);
    }

    private void display(Node root) {
        if (root == null)
            return;
        String res = (root.left != null) ? root.left.val + "---> "
                : "null" + root.val + "<---" + ((root.right != null) ? root.right.val + "" : "null");
        System.out.println(res);
        display(root.left);
        display(root.right);
    }

    public void displayTree(treeNode root) {
        System.out.println("Par--->" + root.val);
        for (treeNode r : root.child) {
            System.out.print(" ---> " + r.val);
        }
        System.out.println();
        for (treeNode r : root.child) {
            displayTree(r);
        }
    }
    
    // public static void ZigZagTraversal(TreeNode root) {
    //     int cnt = 1;
    //     LinkedList<TreeNode> q = new LinkedList<>();
    //     q.addLast(root);
    //     while (q.size() > 0) {
    //         int sz = q.size();
    //         while (sz-- > 0) {
    //             TreeNode front = q.removeFirst();
    //             System.out.print(front.data + " , ");
    //             // Error is that I am reversing the level but the child while reversing are
    //             // getting damaged thay are not getting reverssed properly .
    //             if (cnt % 2 == 0) {
    //                 for (TreeNode i : front.child) {
    //                     q.addLast(i);
    //                 }
    //             } else {
    //                 for (int i = front.child.size() - 1; i >= 0; i--) {
    //                     q.addLast(front.child.get(i));
    //                 }
    //             }
    //         }
    //         System.out.println();
    //         cnt++;
    //     }
    // }

    // public static void ZigZagCorr(TreeNode root) {
    //     Stack<TreeNode> ms = new Stack<>();
    //     Stack<TreeNode> cs = new Stack<>();
    //     int level = 1;
    //     ms.push(root);
    //     while (ms.size() > 0) {
    //         TreeNode front = ms.pop();
    //         System.out.print(front.data + " , ");
    //         if (level % 2 == 1) {
    //             for (int i = 0; i < front.child.size(); i++) {
    //                 cs.push(front.child.get(i));
    //             }
    //         } else {
    //             for (int i = front.child.size() - 1; i >= 0; i--) {
    //                 cs.push(front.child.get(i));
    //             }
    //         }

    //         if (ms.size() == 0 && cs.size() > 0) {
    //             System.out.println();
    //             ms = cs;
    //             cs = new Stack<>();
    //             level++;
    //         }
    //     }
    // }

    public void zigzagTraversal(treeNode root) {
        Queue<treeNode> q = new LinkedList<>();
        q.add(root) ; 
        int level =  0  ; 
        System.out.println("Traversal of the tree ---");
        while(q.size()>0){
            int sz = q.size() ; 
            while (sz-->0) {
                if(level%2==0){
                treeNode curr = q.poll() ; 
                for(treeNode c : curr.child){

                    }
                }else{
                    treeNode curr = q.poll();
                    for (int i  = curr.child.size() - 1 ; i>=0 ; i--) {
                        treeNode c = curr.child.get(i) ; 

                    }
                }
                
            }
            level++ ; 
        }
    }
    public static void removeleafNodes(treeNode root){
        for(treeNode r : root.child){
            removeleafNodes(r);
        }
        for(int i = 0 ; i  < root.child.size() ; i++){
            treeNode child = root.child.get(i) ; 
            if(child.child.size()==0){
                root.child.remove(i) ; 
            }
        }
    }

    public static void removeleafNodes(treeNode root) {

        for (int i = 0; i < root.child.size(); i++) {
            treeNode child = root.child.get(i);
            if (child.child.size() == 0) {
                root.child.remove(i);
            }
        }
        for (treeNode r : root.child) {
            removeleafNodes(r);
        }
        
    }
    public static void main(String[] args) {
        treesPractice tree = new treesPractice();
        // Scanner sc = new Scanner(System.in) ;
        // tree.populate(sc);
        // tree.display();
        int[] arr = { 10, 20, 80, -1, -1, 30, 50, -1, 60, -1, -1, 40, 90, -1, 100, 120, -1, 130, -1, -1, -1, 110, -1 };
        Stack<treeNode> st = new Stack<>();
        treeNode root = null;
        for (int i : arr) {
            if (i == -1)
                st.pop();
            else {
                treeNode nn = new treeNode(i);
                if (root == null)
                    root = nn;
                else if (st.size() > 0)
                    st.peek().child.add(nn);
                st.add(nn);
            }
        }

        tree.displayTree(root);

    }

}
