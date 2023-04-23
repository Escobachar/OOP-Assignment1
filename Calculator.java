import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Calculator {
    private final Scanner s;

    public Calculator(){
        s = new Scanner(System.in);
    }


    // public void start(){
    //     System.out.println("Welcome to the Polynomial Calculator!");
    //     int choice = 0;
    //     while (choice != 5){
    //         System.out.println("Please select an operation:");
    //         System.out.println("1. Add two polynomials");
    //         System.out.println("2. Multiply two polynomials");
    //         System.out.println("3. Evaluate a polynomial");
    //         System.out.println("4. Derive a polynomial");
    //         System.out.println("5. Exit");

    //         choice = readInt();
    //         Polynomial p1;
    //         Polynomial p2;
    //         switch (choice) {
    //             case 1 -> {
    //                 System.out.println("Please enter the first polynomial:");
    //                 p1 = Polynomial.build(readLine());
    //                 System.out.println("Please enter the second polynomial:");
    //                 p2 = Polynomial.build(readLine());
    //                 System.out.println("The result is:");
    //                 System.out.println(p1.add(p2));
    //             }
    //             case 2 -> {
    //                 System.out.println("Please enter the first polynomial:");
    //                 p1 = Polynomial.build(readLine());
    //                 System.out.println("Please enter the second polynomial:");
    //                 p2 = Polynomial.build(readLine());
    //                 System.out.println("The result is:");
    //                 System.out.println(p1.mul(p2));
    //             }
    //             case 3 -> {
    //                 System.out.println("Please enter the polynomial:");
    //                 p1 = Polynomial.build(readLine());
    //                 System.out.println("Please enter the value to evaluate at:");
    //                 int val = readInt();
    //                 System.out.println("The result is:");
    //                 System.out.println(p1.evaluate(new IntegerScalar(val)));
    //             }
    //             case 4 -> {
    //                 System.out.println("Please enter the polynomial:");
    //                 p1 = Polynomial.build(readLine());
    //                 System.out.println("The result is:");
    //                 System.out.println(p1.derivative());
    //             }
    //             case 5 -> Sstem.out.println("Goodbye!");
    //             default -> System.out.println("Invalid choice, please try again.");
    //         }
    //     }

    // }

    // public int readInt(){
    //     return IntegerScalar.parseInt(s.nextLine());
    // }

    public String readLine(){
        return s.nextLine();
    }
    public static void main(String[] args){
        Calculator c = new Calculator();
        Scalar test1 = new Rational(-5.0);
        Rational test2 = new Rational(4.5);
        Rational test5 = new Rational(4.0);
        Scalar test3 = (test1.mul(test2)).power(3);
        Scalar test4 = test2.reduce();
        Monomial mono1 = new Monomial(2, test4);
        Monomial mono2 = new Monomial(1, test1);
        Monomial mono3 = new Monomial(0, test5);
        Set<Monomial> monos = new HashSet<Monomial>();
        monos.add(mono1);
        monos.add(mono2);
        Set<Monomial> monos2 = new HashSet<Monomial>();
        monos2.add(mono3);
        Polynomial poly2 = new Polynomial(monos2);
        Polynomial poly1 = new Polynomial(monos);
        Polynomial d = poly1.derivative();
        System.out.println(poly1.toString());
        Polynomial poly3 = Polynomial.build("0 0 0 0 0 0 1");
        System.out.println(poly3.toString());
        int i = 4;
        //c.start();
    }
}
