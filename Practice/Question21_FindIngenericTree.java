
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

public class Question21_FindIngenericTree {
    public static boolean find(Node root , int tar){
        if(root.data == tar) return true  ; 
        Boolean isPresent  = false ; 
        for(Node ch : root.child){
            isPresent = find(ch, tar) ; 
            if(isPresent == true) return true  ; 
        }
        return isPresent ; 
    }
    public static void removeLeaf(Node root) {
        int sz = root.child.size();
        for (int i = sz - 1; i >= 0; i--) {
            Node ch = root.child.get(i);
            if (ch.child.size() == 0) {
                root.child.remove(i);
            }
        }
        for (int i = sz - 1; i >= 0; i--) {
            removeLeaf(root.child.get(i));
        }
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
        System.out.println(find(root, 9));

    }
}


