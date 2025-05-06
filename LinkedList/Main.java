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
        if (head == null) {
            head = last;
            tail = last;
        } else {
            tail.next = last;
            tail = last;
        }
        size++;
    }

    public void addFirst(int data) {
        Node firs = new Node(data);
        if (tail == null) {
            tail = firs;
            head = firs;
        } else {
            firs.next = head;
            head = firs;
        }
        size++;

    }

    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "--> ");
            temp = temp.next;
        }
    }

    public void removeLast() {
        if (size == 1) {
            tail = null;
            head = null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        tail = temp;
        size--;
    }

    public void removefirst() {
        if (size == 0) {
            System.out.println("empty");
            return  ; 
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
        } else {
            head = head.next;
            size--;
        }

    }
    public Node getNodeAt(int idx){
        Node temp = head ; 
        if(idx>=size){
            return null; 
        }
        if(idx==0) return head ; 
        for(int i = 0 ; i < idx - 1 ; i++){
            temp=temp.next ; 
        }
        return temp ; 
    } 
    public void addNodeAt(int idx , int data){
        if(idx<0 || idx>size){
            return ; 
        }
        if(idx==0){
            addFirst(data);
            return ; 
        }
        else if(idx==size){
            addLast(data);
            return ; 
        }
        Node naya = new Node(data) ; 
        Node prev= getNodeAt(idx-1) ; 
        Node nexton  = prev.next ; 
        prev.next = naya ; 
        naya.next = nexton ; 
        this.size++ ; 
    }
    public void removeAt(int idx){
        if(idx<0 || idx>=size){
            return ; 
        }
        if(idx==0){
            removefirst();
        }
        Node prev= getNodeAt(idx-1) ;
        Node agla = prev.next.next ; 
        prev.next = agla ; 
        size--; 
    }
    public void reverseLink(){
        int i = 0 ; 
        int  j = size -1 ; 
        while(i<=j){
            Node ati = getNodeAt(i) ; 
            Node atj = getNodeAt(j) ; 
            int datai = ati.data ; 
            int dataj = atj.data ;
            ati.data =dataj ; 
            atj.data=datai ; 
            i++ ; 
            j-- ;
        }
    }

}

class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(23);
        for (int i = 1; i <= 4; i++) {
            ll.addFirst(i);
        }
        ll.addNodeAt(3, 1000);
        // ll.removefirst();
        // ll.removefirst();
        // ll.removefirst();
        // ll.removefirst();
        // ll.removefirst();
        // ll.removefirst();
        // System.out.println(ll.head.data);
        // System.out.println(ll.head.next.data);
        // System.out.println(ll.head.next.next.data);
        // System.out.println(ll.head.next.next.next.data);
        ll.display(ll.head);
        System.out.println(ll.size);
    }
}