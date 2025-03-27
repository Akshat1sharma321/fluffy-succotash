import java.util.*;

public class class4 {
    public static ArrayList<String> getS(String s){
        if(s.length()==0){
            ArrayList<String>base=new ArrayList<>() ;
            base.add("");
            return base;
        }
        char firstchar = s.charAt(0) ;
        String remString = s.substring(1);
        ArrayList<String>smallerans = getS(remString) ; 
        ArrayList<String>ans=new ArrayList<>() ; 
        for(String st : smallerans)ans.add(st) ;
        for(String str : smallerans)ans.add(firstchar+str);
        return ans ;
      //socho ki ek length kam ke liye solve kardega
      //assumption - c,b,bc,""
      //expectation - c,b,a,ab,abc,bc,ab,ac,"" 
      //empty arraylist is different from empty string dont confuse ....

    }
    public static ArrayList<String>getKPC(String str){
        if(str.length()==0){
            ArrayList<String>base = new ArrayList<>() ; 
            base.add("");
            return base ; 
        }
        String remString  = str.substring(1);
        int firstdig = str.charAt(0)-'0';
        ArrayList<String>smallerAns = getKPC(remString);
        ArrayList<String>ans =new ArrayList<>() ; 
        String letters = lettersArray[firstdig];
        for(int i = 0 ; i <letters.length() ;i++ ){
            char let = letters.charAt(i) ; 
            for(String s : smallerAns){
                ans.add(let + s);
            }
        }
        return ans ;
    }
    static String[]lettersArray = {",:","<;","abc","def","ghi","jkl","mno","pqr","stu","vwxz"};


    public static ArrayList<String>getAllPaths(int n){
        ArrayList<String>ans = new ArrayList<>();
        ArrayList<String>pathafterone = getAllPaths(n-1);
         ArrayList<String>pathaftertwo = getAllPaths(n-1);
          ArrayList<String>pathafterthree = getAllPaths(n-1);
          for(String path : pathafterone)ans.add('1'+path);
          for(String path : pathaftertwo)ans.add('2'+path);
          for(String path : pathafterthree)ans.add('3'+path);
          return ans ;
          
    }
    public static void main(String[] args) {
        System.out.println("hello");
        ArrayList<String>al = getKPC("134") ;
        System.out.println(al); 
        
       
    }
}
