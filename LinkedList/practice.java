class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
class LinkedList{
    Node head ; 
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class Solution {
    ListNode ohead  ;
    ListNode otail ; 
    ListNode thead ; 
    ListNode ttail ;
    public void addFirst(ListNode node){
        if(thead==null ){
            thead = node ; 
            ttail = node ; 
        }
        else{
            node.next = thead ; 
            thead = node ; 
        }
    }
    public  int getSize(ListNode head){
        ListNode temp = head ; 
        int cnt  = 0 ; 
        while(temp!=null){
            cnt++ ; 
            temp=temp.next ; 
        }
        return cnt ; 
    }
    public ListNode revKgrp(ListNode head,int k ){
        ohead = null ; 
        otail = null ; 
        ttail = null ;
        thead = null ; 
        int size = getSize(head) ; 
        ListNode curr = head ;
        while(size>=k){
            int K = k ; 
            while(K-->0){
               ListNode agla = curr.next ; 
               curr.next = null ; 
               addFirst(curr);
               curr = agla ; 
               size-- ;  
            }
            if(ohead==null){
                ohead =thead ; 
                otail = ttail ; 
            }
            else{
                otail.next = thead ; 
                otail = ttail ;
            }
            thead = null ; 
            ttail = null ; 
        }

        otail.next = curr ; 
        return ohead ; 
    }

    public ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode rev(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode mid = getMid(head);
        ListNode h2 = mid.next;
        mid.next = null;
        h2 = rev(h2);
        ListNode ptr1 = head;
        ListNode ptr2 = h2;
        ListNode temp = dummy;
        while (ptr2 != null) {
            temp.next = ptr1;
            ptr1 = ptr1.next;
            temp = temp.next;
            temp.next = ptr2;
            ptr2 = ptr2.next;
            temp = temp.next;
        }
        if (ptr1 != null) {
            temp.next = ptr1;
        }
        head = dummy.next;
    }

    public void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }
    public void undoReorder(ListNode head){
        ListNode oddDumm = new ListNode(-1) ; 
        ListNode evenDumm = new ListNode(-1) ; 
        ListNode oddPtr = oddDumm ; 
        ListNode evenPtr = evenDumm ; 
        int cnt  = 0 ; 
        ListNode curr = head ; 
        while(curr!=null){
            ListNode agla = curr.next ; 
            curr.next = null ; 
            if(cnt%2==0){
                evenPtr.next = curr ; 
                evenPtr = evenPtr.next ; 
            }else{
                oddPtr.next = curr ; 
                oddPtr = oddPtr.next  ; 
            }
            cnt++ ; 
            curr = agla ; 
        }
        ListNode ogOdHead = oddDumm.next ; 
        oddDumm.next = null ;
        ogOdHead = rev(ogOdHead);
        evenPtr.next = ogOdHead ; 
        head = evenDumm.next  ; 
    }
}
public class practice {
    public void display(Node head){
        Node temp = head ;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next ; 
        }
    }
    public Node reverse(Node head){
        Node curr = head ; 
        Node og = head ; 
        Node prev = null ; 
        while(curr!=null){
            Node agla = curr.next ; 
            curr.next = prev ; 
            prev = curr ; 
            curr = agla ; 
        }
        return prev; 
    }
    public Node getkNode(Node head,int k){
        Node slow = head ; 
        Node fast = head ;
        while(k-->0){
            if(fast==null){
                return null ; 
            }
            fast=fast.next ; 
        } 
        while(fast!=null){
            fast=fast.next ; 
            slow = slow.next ;
        }
        return slow ; 


    }
    public static void main(String[] args) {
        System.out.println("Hello");
        Node head1 = new Node(1) ; 
        Node n1 = new Node(0) ;
        Node n22 = new Node(2) ; 
        ListNode ls = new ListNode(5) ;
        ListNode n4 = new ListNode(4,ls) ; 
        ListNode n3 = new ListNode(3,n4)  ;
        ListNode n2 = new ListNode(2,n3) ; 
        ListNode head = new ListNode(1,n2) ;
        Solution s = new Solution() ;
        // s.display(head); 
        // s.reorderList(head);
        // System.out.println();
        // s.display(head);
        // s.undoReorder(head);
        System.out.println();
        head = s.revKgrp(head,2);
        s.display(head);
        

        // head1.next = n1 ; 
        // n1.next = n22 ; 
        // practice p = new practice() ; 
        // p.display(head1) ;
        // System.out.println();
        // head1 = p.reverse(head1) ;
        // p.display(head1); 

    }
}
