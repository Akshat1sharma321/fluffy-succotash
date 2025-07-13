import java.util.ArrayList;
import java.util.Stack;

class Node {
    int data;
    ArrayList<Node> children;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

};

public class Questions {
    public static void displaydata(Node roote) {
        System.out.print(roote.data + "-->");
        for (Node nn : roote.children) {
            System.out.print(nn.data + " , ");
        }
        System.out.println();
        for (Node nnn : roote.children) {
            displaydata(nnn);
        }
    }
    public static void removeLeaf(Node root){
        int sz = root.children.size() ; 
        for (Node child : root.children) {
            removeLeaf(child);
        }
        for(int i = 0 ; i < sz ; i++){
            Node child = root.children.get(i) ; 
            if(child.children.size()==0){
                root.children.remove(i) ; 
            }
        }
        
    }
    public static void main(String[] args) {
        Stack<Node> st = new Stack<>();
        Node roote = null;
        int[] arr = { 10 , 20 , 50 , -1 , -1 , 30 , 70 , -1 , -1 , 40 , 100 };
        for (int val : arr) {
            if (val == -1)
                st.pop();
            else {
                Node nn = new Node(val);
                if (st.size() == 0) {
                    roote = nn;
                } else {
                    st.peek().children.add(nn);
                }
                st.push(nn);
            }
        }

        displaydata(roote);
        removeLeaf(roote);
        System.out.println();
        displaydata(roote);
    }
}
