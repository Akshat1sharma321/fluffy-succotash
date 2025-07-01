import java.util.ArrayList;
import java.util.Stack;

class Node{
    int data ; 
    ArrayList<Node>children ;
    public Node(){} 
    public Node(int data){
        this.data = data ; 
        this.children = new ArrayList<>() ; 
    }

};
public class Basics {
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
    public static int sizee(Node roote){
        int size = 0 ;
        for(Node nn : roote.children){
            size+= sizee(nn);    
        } 
        return size + 1 ; 
    }
    public static int height(Node tree){
        int ht  = 0 ; 
        for(Node child : tree.children){
            ht = Math.max(ht, height(child))  ;
        }
        return ht + 1 ; 
    }
    public static void eulertraversal(Node roote){
        System.out.print("Preorder-->" + roote.data);
        for(Node nn : roote.children){
            System.out.println("Taking edge from :" + roote.data + "to" + nn.data);
            eulertraversal(nn);
            System.out.println("Taking edge from :" + nn.data + "to" + roote.data); 
        }
        System.out.print("Postorder-->"+roote.data);
    }
    public static void main(String[] args) {
        Stack<Node>st = new Stack<>() ; 
        Node roote = null; 
        int []arr = {10,20,80,-1,-1,30,50,-1,60,-1,-1,40,90,-1,100,120,-1,130,-1,-1,110,-1,-1,-1} ; 
        for(int val : arr){
            if(val==-1)st.pop() ; 
            else{
                Node nn = new Node(val) ; 
                if(st.size()==0){
                    roote = nn ; 
                }
                else{
                    st.peek().children.add(nn) ; 
                }
                st.push(nn) ; 
            }
        }
       
        displaydata(roote) ; 
        System.out.println("Size of tree is " + sizee(roote)) ;
        System.out.println("Height of tree is " + height(roote)) ;
        eulertraversal(roote);
    }
}
