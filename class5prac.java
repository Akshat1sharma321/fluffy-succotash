import java.util.*;

public class class5prac {
    public static void pat1(int n) {
        int totLine = n;
        int currline = 1;
        int star = 1;
        while (currline <= totLine) {
            for (int i = 0; i < star; i++) {
                System.out.print("* ");
            }
            System.out.println();
            star++;
            currline++;
        }
    }

    public static void pat2(int n) {
        int totLine = n;
        int currline = 1;
        int star = n;
        while (currline <= totLine) {
            for (int i = 0; i < star; i++) {
                System.out.print("* ");
            }
            System.out.println();
            star--;
            currline++;
        }
    }

    public static void pat3(int n) {
        int totLine = n;
        int currline = 1;
        int star = 1;
        int spaces = n - 1;
        while (currline <= totLine) {
            for (int i = 0; i < spaces; i++) {
                System.out.print("  ");
            }
            for (int i = 0; i < star; i++) {
                System.out.print("* ");
            }
            System.out.println();
            star++;
            spaces--;
            currline++;
        }
    }

    public static void pat4(int n) {
        int totLine = n;
        int currline = 1;
        int star = n;
        int space = 0;
        while (currline <= totLine) {
            for (int i = 0; i < space; i++) {
                System.out.print("  ");
            }
            for (int i = 0; i < star; i++) {
                System.out.print("* ");
            }
            System.out.println();
            space++;
            star--;
            currline++;
        }
    }

    public static void pat5(int n) {
        int totLine = 2 * n + 1;
        int currline = 1;
        int star = 1;
        int space = n;
        while (currline <= totLine) {
            for (int i = 0; i < space; i++) {
                System.out.print("  ");
            }
            for (int i = 0; i < star; i++) {
                System.out.print("* ");
            }
            System.out.println();
            if (currline <= n) {
                space--;
                star += 2;
            } else {
                space++;
                star -= 2;
            }
            currline++;
        }
    }

    public static void pat6(int n) {
        int totLine = n;
        int currline = 1;
        int star = n / 2 + 1;
        int space = 1;
        while (currline <= totLine) {
            for (int i = 0; i < star; i++) {
                System.out.print("* ");
            }
            for (int i = 0; i < space; i++) {
                System.out.print("  ");
            }
            for (int i = 0; i < star; i++) {
                System.out.print("* ");
            }
            System.out.println();
            if (currline <= n / 2) {
                space += 2;
                star--;
            } else {
                space -= 2;
                star++;
            }
            currline++;
        }
    }

    public static void pat7(int n) {
        int totLine = n;
        int currline = 1;
        // int star = 1;
        int space = 0;
        while (currline <= totLine) {
            for (int i = 0; i < space; i++) {
                System.out.print("  ");
            }

            System.out.print("* ");

            System.out.println();
            space++;
            currline++;
        }
    }

    public static void pat7i(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("  ");
            }
            System.out.println("* ");
        }
    }

    public static void pat7ii(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
    }

    public static void pat8(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
    }

    public static void pat8i(int n) {
        int totl = n;
        int currl = 1;
        int space = n - 1;
        while (currl <= totl) {
            for (int i = 0; i < space; i++) {
                System.out.print("  ");
            }
            System.out.println("* ");
            space--;
            currl++;
        }

    }

    public static void pat9(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j == n - 1) || (i == j)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
    }

    public static void pat10i(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i + j) % 2 == 0) && (i + j) > 0 && (i + j) <= n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
    }

    public static void pat10(int n) {
        int osps = n / 2;
        int ispc = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < osps; j++) {
                System.out.print("  ");
            }
            System.out.print("* ");
            for (int j = 0; j < ispc; j++) {
                System.out.print("  ");
            }
            if (i > 0 && i < n - 1) {
                System.out.print("* ");

            }
            System.out.println();
            if (i < n / 2) {
                ispc += 2;
                osps--;
            } else {
                ispc -= 2;
                osps++;
            }

        }

    }

    public static void pat11(int n) {
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(cnt);
                cnt++;
            }
            System.out.println();
        }

    }

    public static void pat12(int n) {
        int a = 0;
        int b = 1;
        // int c = a + b;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                System.out.print(a + "\t");
                int c = a + b;
                a = b;
                b = c;
            }
            System.out.println();

        }
        System.out.println();
    }

    public static void pat13(int n) {
        int space = n;
        int star = 1;
        int startNum = 1;
        int totl = 2 * n + 1;
        int currl = 1;
        while (currl <= totl) {
            int num = startNum;
            for (int i = 0; i < space; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < star; i++) {
                System.out.print(num);
                if (i < star / 2)
                    num++;
                else
                    num--;
            }
            System.out.println();
            if (currl <= n) {
                space--;
                star += 2;
                startNum++;
            } else {
                space++;
                star -= 2;
                startNum--;
            }
            currl++;
        }
    }

    public static void pat14(int n) {
    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < n  ; j++){
            if(j<=i) System.out.print("* ");
            else System.out.print("  ");
        }
        if(i<n-1){
             System.out.println();
        }
       
    }
    int star = 1 ;
    int space = n -1 ; 
    int currline = 1 ; 
    int totl = n ;
    while(currline<=totl){
       for(int i = 0 ; i < space ; i++){
        System.out.print("  ");
       } 
       for(int i = 0 ; i < star ; i++){
        System.out.print("* ");
       }
       System.out.println();
       star++;
       space--;
       currline++;
    }
    }
     public static void pat14i(int n) {
    int space = 2 * n - 3 ; 
    int star = 1 ;
    int currl = 1 ; 
    int totl = n ; 
    while(currl <= totl){
        for(int i = 1 ; i <= star ; i++){
            System.out.print(i);
        }
        for(int i = 0 ; i < space ; i++){
            System.out.print(" ");
        }

         if(currl==totl)star--;

        for(int i = star ; i >=1  ; i--){
            System.out.print(i);
        }
        System.out.println();
       
        space-=2;
        star++;
        currl++;
    }
    
    }
    
     public static void pat15(int n) {
    int currl = 1 ;
    int totl  = n ; 
    int space = 0 ; 
    int star = n ; 
    while(currl<=totl){
        for(int i = 0 ; i < space ; i++){
            System.out.print("  ");
        }
        for(int i = 0 ; i < star ; i++){
            if(currl>1 && currl<=n/2){
                if(i==0 || i==star-1){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            else{
                System.out.print("* ");
            }
            
        }
        System.out.println();
        if(currl<=n/2){
            space++;
            star-=2;
        }
        else{
            space--;
            star+=2;
        }

        currl++;
    }
    }
    
    public static void pat16(int n ){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(j==0 || j==n-1){
                    System.out.print("* ");
                }
                else if(i>=n/2 && (i==j || i+j==n-1)){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
                
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no for pattern:");
        int n = sc.nextInt();
        pat16(n);
    }
}
