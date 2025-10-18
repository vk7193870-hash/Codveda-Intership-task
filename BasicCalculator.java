import java.util.Scanner;

class Calculator {

    // Method for addition
    public double add(double a, double b) {
        return a + b;
    }

    // Method for subtraction
    public double subtract(double a, double b) {
        return a - b;
    }

    // Method for multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Method for division (with division by zero check)
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed!");
            return Double.NaN; // Returns "Not a Number"
        }
        return a / b;
    }
}

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("===== Basic Calculator =====");
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.println("Choose operation: (+, -, *, /)");
        char op = sc.next().charAt(0);

        double result = 0;

        switch (op) {
            case '+':
                result = calc.add(num1, num2);
                break;
            case '-':
                result = calc.subtract(num1, num2);
                break;
            case '*':
                result = calc.multiply(num1, num2);
                break;
            case '/':
                result = calc.divide(num1, num2);
                break;
            default:
                System.out.println("Invalid operation! Please choose +, -, *, or /");
                sc.close();
                return;
        }

        if (!Double.isNaN(result)) {
            System.out.println("Result: " + result);
        }

        sc.close();
    }
}
