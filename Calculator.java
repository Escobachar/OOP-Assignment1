import java.util.Scanner;

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
        test5 = test5.reduce();
        System.out.println(test2.toString());
        System.out.println(test1.toString());
        int i = 4;
        //c.start();
    }
}
