import java.util.*;

class queue{
    int iniSize = 4 ; 
    int size ; 
    int[]data ; 
    int front  ; 
    queue(){
        data = new int[iniSize] ; 
        front = 0 ; 
        size = 0 ; 
    }
    void add(int x){
        if(size==data.length){
            int[]nd = new int[2*data.length] ; 
            for(int i = 0 ; i < size ; i++){
                nd[i] = data[(front+i)%size] ; 
            }
            data = nd ; 
            front = 0 ;
        }
        else{
            data[(front+size)%data.length] = x ; 
            size++ ;
        }
    }
    int peek(){
        if (size == 0) {
            return -1;
        }
        return data[front] ;
    }
    int remove(){
        if (size == 0) {
            return -1;
        }
        int ans  = data[front] ; 
        front+=1 ; 
        size-- ;
        return ans ;
       }
    int size(){
        if(size==0){
            return -1 ;
        }
        return size ;
    }
    void display(){
        for(int i = 0 ; i < data.length ; i++){
            System.out.print(data[(front+i)%data.length]+" , ");
        }
    }
}
public class queImple{
    public static void main(String[] args) {
        System.out.println("hello");
        queue que = new queue();

        que.add(2);
        que.add(23);
        que.add(2321);
        que.add(2123);

        que.display();
        System.out.println();
        
        que.add(2213);
        que.add(2213);
        que.display();
    }
}