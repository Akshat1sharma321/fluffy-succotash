import java.util.HashMap;

public class class1 {
public static void main(String[] args) {
    HashMap<String,Integer>map = new HashMap<>() ; 
    map.put("India",143) ; 
    map.put("USA",30) ; 
    map.put("China",140) ; 
    System.out.println(map);
}    
}

class Solution1 {
    // Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String s) {
        // Your code here
        HashMap<Character,Integer>mpp = new HashMap<>() ; 
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i) ; 
            if(mpp.containsKey(ch)==false){
                mpp.put(ch,1) ; 
            }
            else{
                int old = mpp.get(ch) ; 
                mpp.put(ch,old+1) ; 
            }
        }
        int cnt  = 0 ; 
        char max = 'a' ;
        for(int i = 0 ; i < s.length(); i++){
            char ch  = s.charAt(i) ; 
            if(mpp.get(ch) >cnt){
                cnt = mpp.get(ch) ; 
                max = ch ; 
            }
            else if(mpp.get(ch)==cnt && ch<max){
                max = ch ;
            }
        }
        return max; 
    }
}

class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer>m = new HashMap<>() ; 
        for(int i = 0  ;i < nums.length ; i++){
            if(m.containsKey(nums[i])==false){
                m.put(nums[i],1) ; 
            }
            else{
                int old = m.get(nums[i]) ;
                m.put(nums[i],old+1) ; 
            }
        }
        int cnt = 0  ; 
        for(int i = 0 ; i < nums.length ; i++){
             if(m.get(nums[i])>cnt){
                cnt = m.get(nums[i]) ; 
             }
        }
        int t = 0 ; 
        for(int e : nums){
            if(cnt==m.get(e)){
                t++;
            }
        }
 return t ; 
    }
}
