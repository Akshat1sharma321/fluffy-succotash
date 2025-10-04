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

public class Question17_MirrorGenericTree {
    public static void traverse(Node root){
        LinkedList<Node> que = new LinkedList<>() ; 
        que.addLast(root); 
        que.addLast(null);
        while(que.size()>1){
            Node curr = que.removeFirst() ; 
            if(curr == null){
                System.out.println();
                que.addLast(null);
            }
            else{
                System.out.print(curr.data + " , ");
                for(Node i : curr.child){
                    que.addLast(i);
                }
            }
        }
    }
    public static Node mirror(Node root){
        int sz = root.child.size() ; 
        int i = 0 ; 
         int j = sz - 1  ; 
         while(i <= j){
            Node Nodeati = root.child.get(i) ; 
            Node Nodeatj = root.child.get(j) ; 
            Nodeati = mirror(Nodeati) ; 
            Nodeatj = mirror(Nodeatj) ; 
            root.child.set(i, Nodeatj) ; 
            if(i<j)
            root.child.set(j, Nodeati) ; 
            i++ ; 
            j-- ;
         }
        return root ; 
    }
    public static void main(String[] args) {
        Node root = new Node();
        int[] treedata = { 10 , 20 , 50 , 140 , -1 , -1 , -1 , 30 , 60 , -1 , 70 , 110 , -1 , 120 , -1 , -1 ,  80 , -1 , -1 , 40 , 90 , -1 , 100 , 130  };
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
        Node rev = mirror(root) ;   
        System.out.println("Mirror  =====");
        traverse(rev);

    }

}
