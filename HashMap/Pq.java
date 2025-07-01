import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Pq {
  public static void main(String[] args) {
    PriorityQueue<Integer>pq = new PriorityQueue<>() ; 
    pq.add(10) ; 
    pq.add(1) ; 
    pq.add(4) ; 
    pq.add(-1) ; 
    pq.add(2) ; 
    pq.remove(-1) ; 
    System.out.println(pq);

    PriorityQueue<Integer>mpq = new PriorityQueue<>(Collections.reverseOrder()) ; 
    mpq.add(10);
    mpq.add(1);
    mpq.add(4);
    mpq.add(-1);
    mpq.add(2);
    mpq.remove(-1);
    System.out.println(mpq);
  }  
}

//leetcode 215
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }
}

//Nearly k sorted arrays
class Solution1 {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int j = 0;
        for (int i : arr) {
            pq.add(i);
            if (pq.size() > k) {
                arr[j++] = pq.remove();
            }
        }
        while (pq.size() > 0) {
            arr[j++] = pq.remove();
        }
    }
}
//leetcode 295
class MedianFinder {
    PriorityQueue<Integer> minpq;
    PriorityQueue<Integer> maxpq;

    public MedianFinder() {
        minpq = new PriorityQueue<>();
        maxpq = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (maxpq.size() == 0 || num <= maxpq.peek())
            maxpq.add(num);
        else
            minpq.add(num);

        int ls = maxpq.size();
        int rs = minpq.size();
        if (rs > ls) {
            maxpq.add(minpq.remove());
        } else if (ls - rs > 1) {
            minpq.add(maxpq.remove());
        }
    }

    public double findMedian() {
        int ls = maxpq.size();
        int rs = minpq.size();
        double mid = 0;
        if (ls == rs) {
            mid = maxpq.peek() + minpq.peek();
        } else if (ls - rs == 1) {
            return maxpq.peek();
        }
        return mid / 2;
    }
}