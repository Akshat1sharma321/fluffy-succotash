import java.util.Stack;
public class Question1_DuplicateParantehsis {
    public static Boolean dup_par(String s){
        Stack<Character> st = new Stack<>() ; 
        int n = s.length() ; 
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i) ; 
            if(ch == ')'){
                if(st.peek()=='('){
                    return true ; 
                }else{
                    while (st.peek()!='(') {
                         st.pop() ; 
                    }
                    st.pop() ; 
                }
            }
            else{
                st.push(ch) ; 
            }
        }
        return false  ; 
    }
    public static void main(String [] args){
        String s  = "((a + b) + (b + c))" ; 
        System.out.println(dup_par(s));
    }
}
