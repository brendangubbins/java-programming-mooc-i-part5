
public class MainProgram {

    public static void main(String[] args) {
        // test your class here
        Money a = new Money(10,50);
        Money b = new Money(5,60);

        Money c = a.plus(b);

        System.out.println(a); 
        System.out.println(b);  
        System.out.println(c);  
    }
}
