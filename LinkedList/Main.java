class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    Node head;
    Node tail;
    int size;

    public void addLast(int data) {
        Node last = new Node(data);
        if(head==null){
            head= last ; 
            tail = last ;
        }else{
            tail.next = last ; 
            tail= last ; 
        }
        size++ ; 
    }
    public void addFirst(int data){
        Node firs = new Node(data) ; 
        if(tail==null){
            tail = firs ; 
            head = firs ; 
        }else{
            firs.next = head ; 
            head = firs ; 
        }
        size++;
        
    }
    public void display(Node head){
        Node temp = head ; 
        while(temp!=null){
            System.out.print(temp.data + "--> ");
            temp=temp.next ; 
        }
    }
    public void removeLast(){
        if(size==1){
            tail=null;
            head=null ;
        }
        Node temp = head ; 
        while(temp.next.next!=null){
            temp=temp.next ; 
        }
        tail=temp ; 
        size-- ;
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(23);
        for (int i = 1; i <= 4; i++) {
            ll.addFirst(i);
        }

        System.out.println(ll.head.data);
        System.out.println(ll.head.next.data);
        System.out.println(ll.head.next.next.data);
        System.out.println(ll.head.next.next.next.data);
ll.display(ll.head);
        System.out.println(ll.size);
    }
}