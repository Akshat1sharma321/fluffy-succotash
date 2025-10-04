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

   

public class Question22_LCA {
    public  static ArrayList<Node> ntr(Node root , int tar){
        if(root.data == tar){
            ArrayList<Node> bans = new ArrayList<>() ; 
            bans.add(root) ; 
            return bans ; 
        }
        for(Node ch : root.child){
            ArrayList<Node>ans  = ntr(ch, tar) ; 
            if(ans.size()>0){
                ans.add(ch) ; 
                return ans ; 
            }
        }
        return new ArrayList<>() ; 
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
    public static Node LCA(Node root , int tar1 , int tar2){
        ArrayList<Node> ans1 = ntr(root, tar1) ; 
        ArrayList<Node> ans2 = ntr(root, tar2) ; 
        if(ans1.size() == 0 || ans2.size() == 0) return null ;
        int i = ans1.size() ; 
        int j = ans2.size() ; 
        while (i >= 0 && j >=0 && ans1.get(i) == ans2.get(j)) {
            i-- ; 
            j-- ; 
        }
        j++ ; 
        return ans2.get(j)  ; 
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

    }
}
