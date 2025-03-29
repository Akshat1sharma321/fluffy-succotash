import java.util.*;
public class class6 {
    public static ArrayList<String>allMazePaths(int sr , int sc , int dr , int dc){
        if(sr>dr || sc>dc){
             ArrayList<String>base=new ArrayList<>();
             return base ;
        }
        if(sr==dr && sc==dc){
            ArrayList<String>basee=new ArrayList<>();
            basee.add("");
            return basee;
        }
        ArrayList<String>ans=new ArrayList<>();
        ArrayList<String>afterHori = allMazePaths(sr, sc+1, dr, dc);
        ArrayList<String>afterVer = allMazePaths(sr+1, sc, dr, dc);
        for(String s:afterHori){
            ans.add(s+"h");
        }
        for(String s:afterVer){
            ans.add(s+"v");
        }
        return ans;
    }
    public static ArrayList<String>allMazePathsWithJumps(int sr,int sc ,int dr , int dc){
        if(sc==dc && sr==dr){
            ArrayList<String>ans = new ArrayList<>() ; 
            ans.add("");
            return ans ;
        }
        ArrayList<String>paths=new ArrayList<>();
        for(int jumps = 1 ; jumps <= dc-sc ; jumps++){
            ArrayList<String>horj = allMazePathsWithJumps(sr, sc+jumps, dr, dc);
            for(String s : horj){
                paths.add("h"+jumps+s);
            }
        }
        for(int jumps = 1 ; jumps <= dr-sr ; jumps++){
            ArrayList<String>verj = allMazePathsWithJumps(sr+jumps, sc, dr, dc);
            for(String s : verj){
                paths.add("v"+jumps+s);
            }
        }
        for(int jumps = 1 ; jumps <= Math.min(dr-sr,dc-sc) ; jumps++){
            ArrayList<String>diaj = allMazePathsWithJumps(sr+jumps, sc+jumps, dr, dc);
            for(String s : diaj){
                paths.add("d"+jumps+s);
            }
        }
        return paths ;
    }
    public static void sus(String str , String sub){
        if(str.length()==0){
            System.out.println(sub);
            return ;
        }
        char firstch = str.charAt(0);
        String rem = str.substring(1);
        sus(rem, sub);
        sus(rem, sub+firstch);
    }
    public static void main(String[] args) {
        System.out.println("hello");
        ArrayList<String>ans = allMazePathsWithJumps(0, 0, 2, 2);
        System.out.println(ans);
    }
} 
