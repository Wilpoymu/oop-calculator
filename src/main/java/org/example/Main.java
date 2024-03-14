package org.example;

import org.example.objects.Division;
import org.example.objects.Multiplication;
import org.example.objects.Subtraction;
import org.example.objects.Sum;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char validate;

        do {
            double num1 = getInput("Enter first number", scanner);
            double num2 = getInput("Enter second number", scanner);

            String operation = getOperation(scanner);

            switch (operation) {
                case "sum":
                    Sum sum = new Sum(num1, num2);
                    System.out.println("Sum: " + sum.getSum());
                    break;
                case "sub":
                    Subtraction subtraction = new Subtraction(num1, num2);
                    System.out.println("Subtraction: " + subtraction.getSubtraction());
                    break;
                case "mul":
                    Multiplication multiplication = new Multiplication(num1, num2);
                    System.out.println("Multiplication: " + multiplication.getMultiplication());
                    break;
                case "div":
                    Division division = new Division(num1, num2);
                    if (num2 == 0) {
                        System.out.println("Division by zero is not allowed");
                    } else {
                        System.out.println("Division: " + division.getDivision());
                    }
                    break;
                default:
                    System.out.println("Invalid operation");
                    break;
            }

            System.out.println("Do you want to continue? (y/n)");
            validate = scanner.next().charAt(0);
        } while (validate == 'y');

        scanner.close();
    }

    private static double getInput(String prompt, Scanner scanner) {
        double input = 0;
        boolean validInput;

        do {
            validInput = true;
            try {
                System.out.println(prompt);
                input = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                validInput = false;
            }
        } while (!validInput);

        return input;
    }

    private static String getOperation(Scanner scanner) {
        String operation;
        do {
            System.out.println("Enter operation (sum for sum, sub for subtraction, mul for multiplication, div for division)");
            operation = scanner.next();
        } while (!operation.equals("sum") && !operation.equals("sub") && !operation.equals("mul") && !operation.equals("div"));

        return operation;
    }
}
