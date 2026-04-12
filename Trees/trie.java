class TrieNode{
    TrieNode[] children ; 
    boolean isEnd ; 
    TrieNode(){
        children  = new TrieNode[26] ; 
        isEnd = false; 
    }
}

public class trie{
    TrieNode root ; 
    public trie(){
        root  = new TrieNode() ; 
    }

    public void insert(String key){
        TrieNode curr = root ; 
        for(char c : key.toCharArray()){
            if(curr.children[c - 'a'] ==null){
                TrieNode ne = new TrieNode() ; 
                curr.children[c - 'a'] = ne ; 
            }
            curr = curr.children[c-'a'] ; 
        }
        curr.isEnd = true ; 
    }
    
    public boolean search(String key){
        TrieNode curr = root ; 
        for(char c :  key.toCharArray()){
            if(curr.children[c-'a']==null) return false  ; 
            curr = curr.children[c - 'a'] ; 
        }
        return curr.isEnd ; 
    }
    public boolean sub(String key){
        TrieNode curr = root ; 
        for(char c : key.toCharArray()){
            if(curr.children[c-'a']==null) return false; 
            curr = curr.children[c-'a'] ; 
        }
        return true  ; 
    }
    public static void main(String[] args) {
        System.out.println("Hello");
        trie node = new trie() ; 
        String [] arr = {"ans" , "ant" , "do" , "dad"} ; 
        for(String s : arr){
            node.insert(s) ; 
        }
        String[]searchKeys = {"do" , "gee" , "bat"} ; 
        for(String s : searchKeys){
            if(node.search(s)){
                System.out.println(s + "--->True");
            }else 
                System.out.println(s + "--->false");
        }
    }
}