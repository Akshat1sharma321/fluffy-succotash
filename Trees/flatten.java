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

public class flatten {
    public static Node flattend(Node Root){
        for(Node node : Root.children){
            flattend(node) ; 
        }
        while(Root.children.size()>1){
            Node lastchild = Root.children.remove(Root.children.size()-1) ; 
            Node secondlastchild  = Root.children.get(Root.children.size() -1); 
            Node tail = getTail(secondlastchild); 
            tail.children.add(lastchild) ; 

        }
        return Root ; 
    }
    public static Node getTail(Node Root){
        Node temp = Root ; 
        while(temp.children.size()>0){
            temp = temp.children.get(0) ; 
        }
        return temp ; 
    }
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
    public static boolean find(Node root , int val){
        if(root.data == val){
            return true ; 
        }
        for(Node n : root.children){
            if(find(n,val)==true)return true ; 
        }
        return false ;
    }
    
    public static ArrayList<Node> path(Node root, int val) {
        if (root.data == val) {
            ArrayList<Node> ans = new ArrayList<>() ; 
            ans.add(root) ; 
            return ans ; 
        }
        ArrayList<Node> arr = null ; 
        for (Node n : root.children) {
            ArrayList<Node>a = path(n, val) ;
            if(a.size()!=0){
                a.add(root) ; 
                return a ; 
            }    
        }
        return arr = new ArrayList<>();
    }
    public static boolean isMirror(Node n1, Node n2){
        if(n1.children.size() != n2.children.size() || n1.data != n2.data){
            return false;
        }
        int size = n1.children.size();
        for(int i=0; i<n1.children.size(); i++){
            Node child1 = n1.children.get(i);
            Node child2 = n2.children.get(size - i - 1);

            if(isMirror(child1, child2) == false){
                return false;
            }
        }

        return true;
    }

    // isSymmetric
    public static boolean isSymmetric(Node root) {
        if(isMirror(root.children.get(0), root.children.get(root.children.size()-1))) return true ; 
        for(Node child : root.children){
            if(isMirror(child.children.get(0), child.children.get(child.children.size()-1))) return true ; 
        }
        return false  ;
    }
    public static void main(String[] args) {
        Stack<Node> st = new Stack<>();
        Node roote = null;
        int[] arr = { 10, 20, 80, -1, -1, 30, 50, -1, 60, -1, -1, 40, 90, -1, 100, 120, -1, 130, -1, -1, 110, -1, -1,
                -1 };
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
      System.out.println(find(roote, 110));
      ArrayList<Node>ans  = path(roote, 100) ; 
      for(Node i : ans){
        System.out.print(i.data+" ") ;
      }
    //   System.out.println();
    }
}
