import java.util.*;
class Stack{
    int i = -1 ;
    int []arr ;
    int ms = 1000 ; 
    public Stack(){
         arr = new int[1000] ;
        i = -1 ; 
    }
    public int peek(){
        if(i!=-1){
            return arr[i] ; 
        }
        return 0 ; 
    }
    
    public int pop() {
        if(i==-1){
            return 0 ;
        }
        
        int pop = arr[i] ; 
        arr[i]=0 ;
        i--; 
        return pop ;
    }
    
    public void push(int num) {
    if(i==ms){
        System.out.println("Error");
        return ; 
    }
        i++;
        arr[i] = num ;
    }
    public int size(){
        return i+1 ;
    }
}

public class q1 {
    public static void main(String[] args) {
        System.out.println("Hello");
        Stack st = new Stack();
        ArrayList<Integer> arr = new ArrayList<>() ; 
        arr.add(89) ; 
        System.out.println(arr);

        st.push(2);
        st.push(23);

        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.size());
    }
}
