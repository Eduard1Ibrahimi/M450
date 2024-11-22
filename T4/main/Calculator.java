package main;

import java.util.Scanner;

public class Calculator {
    public double add(double summand1, double summand2) {
        return summand1 + summand2;
    }

    public double subtract(double minuend, double subtrahend) {
        return minuend - subtrahend;
    }

    public double multiply(double factor1, double factor2) {
        return factor1 * factor2;
    }

    public double divide(double dividend, double divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero.");
        }
        return dividend / divisor;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Calculator!");
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Choose an operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        double result = 0;
        switch (operation) {
            case '+':
                result = calculator.add(num1, num2);
                break;
            case '-':
                result = calculator.subtract(num1, num2);
                break;
            case '*':
                result = calculator.multiply(num1, num2);
                break;
            case '/':
                try {
                    result = calculator.divide(num1, num2);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
                break;
            default:
                System.out.println("Invalid operation!");
                return;
        }

        System.out.println("The result is: " + result);
        scanner.close();
    }
}
