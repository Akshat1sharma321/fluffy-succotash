import java.util.ArrayList;

class pizzaHut{
    int total = 0 ; 
    int item = 0 ; 
    ArrayList<String>list = new ArrayList<>() ; 
    public void pizzaType(String pizzaType){
        if(pizzaType.equals("veg")){
            total+=300 ; 
        }
        else{
            total+=400;
        }
    }
}
public class miniproj {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
