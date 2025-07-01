import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

class Pair {
    Node node;
    int state;

    public Pair(Node node, int state) {
        this.node = node;
        this.state = state;
    }
}

public class BInarytreecons {
    public static int size(Node root) {
        if (root == null)
            return 0;
        int right = size(root.left);
        int left = size(root.right);
        return right + left + 1;
    }

    public static int sum(Node root) {
        if (root == null)
            return 0;
        int leftSum = sum(root.left);
        int rightSUm = sum(root.right);
        return leftSum + rightSUm + root.data;
    }

    public static int maxOfBinaryTree(Node root) {
        if (root == null)
            return 0;
        int leftmax = maxOfBinaryTree(root.left);
        int rightmax = maxOfBinaryTree(root.right);
        return Math.max(Math.max(leftmax, rightmax), root.data);
    }

    public static void allTraversals(Node root) {

        List<Integer> preorderList = new ArrayList<>();

        List<Integer> postorderList = new ArrayList<>();

        List<Integer> inorderList = new ArrayList<>();

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1)) ; 
        while(st.size()>0){
            Node top = st.peek().node ; 
          if(st.peek().state==1){
            preorderList.add(top.data) ; 
            st.peek().state++ ; 
            if(top.left!=null){
                st.push(new Pair(top.left,1)) ; 
            }
          }  
          else if(st.peek().state ==2){
            inorderList.add(top.data) ; 
            st.peek().state++ ; 
            if(top.left!=null){
                st.push(new Pair(top.left,1)) ; 
            }
          }
          else{
              postorderList.add(top.data);
              st.pop() ; 
          }
        } 

        System.out.println(preorderList);

        System.out.println(postorderList);

        System.out.println(inorderList);

    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        int leftht = height(root.left);
        int rightht = height(root.right);
        return Math.max(leftht, rightht) + 1;
    }

    public static void display(Node root) {
        if (root == null)
            return;
        String currNodeStucture = (root.left == null ? "." : root.left.data) + " <- " + root.data + " -> "
                + (root.right == null ? "." : root.right.data);
        System.out.println(currNodeStucture);
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        Integer[] arr = { 10, 20, 11, null, 15, null, null, 12, 14, null, null, null, 30, null, 13, 16, null, null,
                17, null, null };

        Node root = null;
        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            Integer ele = arr[i];

            Node newNode = null;
            if (ele != null) {
                newNode = new Node(ele);
            }

            if (st.size() == 0) {
                root = newNode;
            } else if (st.peek().state == 1) {
                st.peek().node.left = newNode;
                st.peek().state++;
            } else {
                st.peek().node.right = newNode;
                st.pop();
            }
            if (newNode != null) {
                st.push(new Pair(newNode, 1));
            }

        }
        // display(root);
        allTraversals(root);
    }

}
