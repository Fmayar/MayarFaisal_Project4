import java.util.Scanner;

public class ValidationUtil {
    public static String promptRequired(Scanner scanner, String label) {
        while (true) {
            System.out.print(label + ": ");
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("ERROR: " + label + " is required and cannot be blank. Please try again.");
        }
    }

    public static String promptOptional(Scanner scanner, String label) {
        System.out.print(label + " (optional, press Enter to skip): ");
        return scanner.nextLine().trim();
    }

    public static String promptDate(Scanner scanner, String label) {
        while (true) {
            System.out.print(label + " (YYYY-MM-DD): ");
            String input = scanner.nextLine().trim();

            if (input.matches("\\d{4}-\\d{2}-\\d{2}")) {
                return input;
            }

            System.out.println("ERROR: " + label + " must use YYYY-MM-DD format. Example: 2026-05-12");
        }
    }

    public static String promptFromList(Scanner scanner, String label, String[] allowedValues) {
        while (true) {
            System.out.print(label + " " + java.util.Arrays.toString(allowedValues) + ": ");
            String input = scanner.nextLine().trim();

            for (String value : allowedValues) {
                if (value.equalsIgnoreCase(input)) {
                    return value;
                }
            }

            System.out.println("ERROR: Invalid " + label + ". Please choose one of the listed values.");
        }
    }
}
