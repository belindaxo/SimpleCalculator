import java.util.Scanner;
import java.util.ArrayList;

public class Calculator {
    private ArrayList<LogEntry> operationLog;
    private Scanner scanner;

    public Calculator() {
        operationLog = new ArrayList<>();
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        processOperations();
    }

    private void processOperations() {
        String operation = "";

        while (true) {
            System.out.println("Select an option (plus, minus, multiply, divide, or quit):");
            operation = scanner.next();
            System.out.println("You selected: " + operation);

            if (operation.equals("quit")) {
                break;
            }

            int result = processOperation(operation);
            System.out.println("That equals: " + result);
        }

        System.out.println("Operation log: " + operationLog);
    }

    private int processOperation(String operation) {
        int result = 0;

        System.out.println("Please enter the first number to " + operation);
        int first = scanner.nextInt();
        System.out.println("Please enter the second number to " + operation);
        int second = scanner.nextInt();

        if (operation.equals("plus")) {
            result = first + second;
        } else if (operation.equals("minus")) {
            result = first - second;
        } else if (operation.equals("multiply")) {
            result = first * second;
        } else if (operation.equals("divide")) {
            if (first % second != 0) {
                System.out.println("Error, " + first + " is not divisible by " + second + ".");
            } else {
                result = first / second;
            }
        }

        logResult(operation, first, second, result);

        return result;
    }

    private void logResult(String operation, int first, int second, int result) {
        LogEntry logEntry = new LogEntry();
        logEntry.setOperation(operation);
        logEntry.addOperand(first);
        logEntry.addOperand(second);
        logEntry.setResult(result);
        operationLog.add(logEntry);
    }


    public static void main(String[] args) {
        new Calculator();

    }




}
