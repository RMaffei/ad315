import java.util.Scanner;

public class BaseConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String conversionLoop = "y";
        while (conversionLoop.equalsIgnoreCase("y")) {
            // get user's input
            System.out.println("Enter a number: ");
            String number = scanner.nextLine();
            // enter base of number (2-16)
            System.out.println("Enter the base of the number (between 2-16): ");
            int inputBase = scanner.nextInt();
            // enter base to convert (between 2-16)
            System.out.println("Enter the base in which the number should be converted to (between 2-16): ");
            int convBase = scanner.nextInt();
            scanner.nextLine();

            try {
                // convert number from input base to base10
                int decValue = Integer.parseInt(number, inputBase);
                // convert number from base10 to chosen base
                String result = Integer.toString(decValue, convBase).toUpperCase();
                // output result
                System.out.println("The number " + number + " in base " + inputBase + " would be " + result +
                        " in base " + convBase);
            } catch (NumberFormatException e) {
                System.out.println("This number is invalid, please recheck number and bases are correct.");
            }

            // ask if user wants to continue to convert
            System.out.println("Do you want to convert another number? (y/n): ");
            conversionLoop = scanner.nextLine();
        }
        System.out.println("Exiting...");
        scanner.close();
    }
}