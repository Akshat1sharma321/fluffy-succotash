import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;

class Node {
    int data;
    ArrayList<Node> child;

    Node() {
    };

    Node(int data) {
        this.data = data;
        this.child = new ArrayList<>();
    }
}

public class Question19_Linearise {
    public static Node gettail(Node root){
        Node temp = root ; 
        while(temp.child.size() > 0){
            temp = temp.child.get(0) ; 
        }
        return temp ;  
    }
    public static Node linearise(Node root){
        for(Node i : root.child){
            linearise(i) ; 
        }
        while (root.child.size() > 1) {
            Node lastNode = root.child.remove(root.child.size() - 1) ; 
            Node secondLast = root.child.get(root.child.size() - 1) ; 
            Node tail = gettail(secondLast) ; 
            tail.child.add(lastNode) ; 
        }
        return root ; 
    }
    public static void traverse(Node root) {
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);
        que.addLast(null);
        while (que.size() > 1) {
            Node curr = que.removeFirst();
            if (curr == null) {
                System.out.println();
                que.addLast(null);
            } else {
                System.out.print(curr.data + " , ");
                for (Node i : curr.child) {
                    que.addLast(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node();
        int[] treedata = { 10, 20, 50, 140, -1, -1, -1, 30, 60, -1, 70, 110, -1, 120, -1, -1, 80, -1, -1, 40, 90, -1,
                100, 130 };
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < treedata.length; i++) {
            int val = treedata[i];
            if (val != -1) {
                Node nn = new Node(val);
                if (st.size() == 0) {
                    root = nn;
                } else {
                    st.peek().child.add(nn);
                }
                st.push(nn);
            } else {
                st.pop();
            }
        }
        traverse(root);
        System.out.println();
        linearise(root) ; 
        traverse(root);

    }

}
