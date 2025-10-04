import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
        class TreeNode{
        int data  ; 
        ArrayList<TreeNode>child ; 
        TreeNode(){} ; 
        TreeNode(int data){
            this.data = data ;
            this.child = new ArrayList<>() ;  
        }
        } ; 

public class Rough {
    public static int size(TreeNode root){
            int sz = 0 ; 
            for(TreeNode i : root.child){
                sz+=size(i) ; 
            } 
            return sz+1 ; 
    }
    public static int max(TreeNode root){
        int mx = 0 ; 
        for(TreeNode i : root.child){
            mx = Math.max(mx , max(i)) ; 
        }
        return Math.max(mx , root.data) ; 
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode() ; 
        int[]treedata = {10 , 20 , 30 , -1 , 40 , -1 , 50 ,-1 , -1 , 60 , 70 , -1 , 90  } ; 
        Stack<TreeNode> st = new Stack<>() ; 
        for(int i = 0 ;  i  < treedata.length ; i++ ){
            int val = treedata[i] ; 
            // System.out.print(val);
            if(val != -1){
                TreeNode nn = new TreeNode(val) ; 
                if(st.size() == 0){
                    root = nn ; 
                }
                else{
                    // System.out.print( "int the else -->   " + val);
                    st.peek().child.add(nn) ; 
                }
                st.push(nn) ; 
            }
            else{
                st.pop() ; 
            }
            
        }

        LinkedList<TreeNode>que = new LinkedList<>() ; 
        que.addLast(root) ; 
        while(que.size()!=0){
            TreeNode nod = que.removeFirst() ; 
            System.out.print("Parent Node --> "+ nod.data + " Child Node -->");
            for(TreeNode ch : nod.child){
                System.out.print(ch.data + " , ");
                que.addLast(ch);
            }
            System.out.println();
        }
        System.out.println(max(root));
        System.out.println(size(root));
        // ------------------- 1. ARRAY -------------------
        int[] arr = {5, 2, 8, 1, 3};
        Arrays.sort(arr); // Sorting array
        System.out.println("Array: " + Arrays.toString(arr));

        // ------------------- 2. ARRAYLIST -------------------
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 3));
        Collections.sort(list); // Natural order
        System.out.println("ArrayList (sorted): " + list);

        // Custom Comparator (descending order)
        list.sort((a, b) -> b - a);
        System.out.println("ArrayList (custom sort desc): " + list);

        // ------------------- 3. STACK -------------------
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack pop: " + stack.pop()); // LIFO
        System.out.println("Stack peek: " + stack.peek());

        // ------------------- 4. QUEUE -------------------
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println("Queue poll: " + queue.poll()); // FIFO
        System.out.println("Queue peek: " + queue.peek());

        // ------------------- 5. PRIORITY QUEUE -------------------
        // Min-Heap (default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(5);
        minHeap.offer(1);
        minHeap.offer(3);
        System.out.println("Min-Heap poll: " + minHeap.poll());

        // Max-Heap (using Comparator)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.offer(5);
        maxHeap.offer(1);
        maxHeap.offer(3);
        System.out.println("Max-Heap poll: " + maxHeap.poll());

        // ------------------- 6. HASHSET -------------------
        HashSet<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("apple"); // duplicate ignored
        System.out.println("HashSet: " + set);

        // ------------------- 7. HASHMAP -------------------
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 28);

        System.out.println("HashMap: " + map);
        System.out.println("Value for Bob: " + map.get("Bob"));

        // Sorting HashMap by Key using TreeMap
        TreeMap<String, Integer> sortedByKey = new TreeMap<>(map);
        System.out.println("HashMap sorted by key (TreeMap): " + sortedByKey);

        // Sorting HashMap by Value
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((a, b) -> a.getValue() - b.getValue());
        System.out.println("HashMap entries sorted by value: " + entryList);

        // ------------------- 8. TREEMAP -------------------
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        System.out.println("TreeMap (sorted by key): " + treeMap);

        // Custom Comparator for TreeMap (descending order)
        TreeMap<Integer, String> treeMapDesc = new TreeMap<>((a, b) -> b - a);
        treeMapDesc.putAll(treeMap);
        System.out.println("TreeMap (custom comparator desc): " + treeMapDesc);

         // 9. HashSet
        Set<String> hashSet = new HashSet<>(Arrays.asList("banana", "apple", "cherry"));
        List<String> sortedHashSet = new ArrayList<>(hashSet);
        sortedHashSet.sort((a, b) -> a.compareTo(b)); // alphabetical
        System.out.println("HashSet Sorted: " + sortedHashSet);

        // 10. TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>((a, b) -> b - a); // descending order
        treeSet.addAll(Arrays.asList(5, 1, 3));
        System.out.println("TreeSet Descending: " + treeSet);
    }
}
