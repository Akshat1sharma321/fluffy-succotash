import java.util.* ; 
public class c1 {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ; 
        for(int i = 0 ; i < 4 ; i++){
            int data = sc.nextInt() ; 
            Node in  = new Node(data) ; 
        }
         System.out.println("hello");
         sc.close() ; 
    }
}

 class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
