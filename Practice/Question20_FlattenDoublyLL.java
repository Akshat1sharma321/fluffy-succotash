public class Question20_FlattenDoublyLL {
    // public Node flatten(Node head) {
    //     Node temp = head;
    //     while (temp != null) {
    //         if (temp.child == null) {
    //             temp = temp.next;
    //             continue;
    //         } else {
    //             Node ch = temp.child;
    //             Node tail = ch;
    //             while (tail.next != null) {
    //                 tail = tail.next;
    //             }
    //             tail.next = temp.next;
    //             if (temp.next != null) {
    //                 temp.next.prev = tail;
    //             }
    //             temp.next = temp.child;
    //             temp.child.prev = temp;
    //             temp.child = null;
    //         }
    //     }
    //     return head;
    // }
}
