class complex{
    int img ; 
    int real ; 
    complex(){
        this.img = 0 ; 
        this.real = 0 ; 
    }
    complex(int real , int img){
        this.real = real ; 
        this.img = img ; 
    }
    public void add(complex b){
        int rs = this.real + b.real ; 
        int is = this.img + b.img ; 
        System.out.println(rs + " + " + is  + "i");
    }
    
    public void mul(complex b) {
       int ft = this.real*b.real + (-1)*(this.img*b.img) ; 
       int st = this.real*b.img + this.img*b.real ; 
        System.out.println(ft + " + " + st + "i");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello") ; 
        complex a1 = new complex(1,2) ; 
        complex b1 = new complex(2,3) ; 
        // a1.add(b1);
        // a1.mul(b1);
        System.out.println(a1);
    }
    
}
