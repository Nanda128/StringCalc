import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to StringCalc!");
        // This program does not include Division functionality as the assignment requires only +,-, and *.
        System.out.println("\n");
        System.out.println("Enter your Expression here!");
        String expression = sc.nextLine();
        // Check if the input expression is empty
        if (expression.trim().isEmpty()) {
            System.out.println("Error: Expression cannot be empty!");
            sc.close();
            return;
        }
        Calculator calculator = new Calculator();
        try {
            double result;
            result = calculator.evaluate(expression);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
