import java.util.StringTokenizer;

public class PracSong {
    public static void main(String[] args) {
        String[] lyrics = { 
                "Main itni gambhir baat kar raha hun",
                "Aur aapne beech mein hasna shuru kardiya",
                "Aap kaisi ladki hai Kammo ji",
                "Tumhe kaisi lagti hun ",
                "                        " , 
                "Kedi duniya to aai hai tu dasja ",
                "Ni kedi duniya to aai hai tu dasja ",
                "Te ethe ki labdi eh mainu dasja ",
                "Ni ethe ki labdi eh mainu dasja"
        };
        System.out.println("Awwkshat");
        int cnt  = 0  ; 
        try {
            
            for (String line : lyrics) {
                StringTokenizer lyrical = new StringTokenizer(line , " ") ; 
                while(lyrical.hasMoreTokens()){
                Thread.sleep(200);
                if (cnt >= 4) {
                    Thread.sleep(85);
                }
                System.out.print(lyrical.nextToken() + " ");

                }
                if (cnt == 1) {
                    Thread.sleep(90);
                }
                if(cnt==2){
                    Thread.sleep(4000) ; 
                }

                if (cnt == 3) {
                    Thread.sleep(500);
                }

                
                System.out.println();
                cnt++ ; 
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        System.out.println("Work Done =  F.S ~ Fiendish Swag ");
    }
}
