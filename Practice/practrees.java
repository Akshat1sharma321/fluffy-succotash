import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;


class node {
    int data;
    ArrayList<node> children;

    node() {
    }

    node(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
};

public class practrees {
    public static void printtr(node root) {
        System.out.print(root.data + " -> ");
        for (node child : root.children) {
            System.out.print(child.data + " , ");
        }
        System.out.println(" . ");
        for (node child : root.children) {
            printtr(child);
        }
    }

    public static int size(node root) {
        int sz = 0;
        for (node child : root.children) {
            sz += size(child);
        }
        return sz + 1;
    }

    public static int maxi(node root) {
        int maxim = 0;
        for (node child : root.children) {
            maxim = Math.max(maxim, maxi(child));
        }
        return Math.max(maxim, root.data);
    }

    public static int maxht(node root) {
        if (root == null)
            return 0;
        int ht = 0;
        for (node child : root.children) {
            ht = Math.max(ht, maxht(child));
        }
        return ht + 1;
    }

    public static void level(node root) {
        LinkedList<node> q = new LinkedList<>();
        q.addLast(root);
        while(q.size()>0){
            node front  = q.removeFirst() ; 
            System.out.print(front.data + " , ");
            for(node child : front.children){
                q.addLast(child);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        Stack<node> st = new Stack<>();
        node root = null;
        int[] treedata = { 10, 20, 30, -1, -1, 30, 50, -1, 60, -1, -1, 40, 90, -1, 100, 120, -1, 130, -1, -1, 110 };
        for (int i : treedata) {
            if (i == -1) {
                st.pop();
            } else {
                node newno = new node(i);
                if (st.size() == 0)
                    root = newno;
                else
                    st.peek().children.add(newno);
                st.push(newno);
            }

        }
        printtr(root);
        System.out.println("Size of the tree is  : " + size(root));
        System.out.println("Max of the tree is  : " + maxi(root));
        System.out.println("Max height of the tree is  : " + maxht(root));
        level(root);
    }
}
