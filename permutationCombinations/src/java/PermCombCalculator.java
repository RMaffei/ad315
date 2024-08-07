public class PermCombCalculator {

    public static long factorial(int number) {
        if (number < 0) throw new IllegalArgumentException("Number must be non-negative.");
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static long calcPermutations(int n, int r) {
        if (r > n) throw new IllegalArgumentException("r must be less than or equal to n.");
        return factorial(n) / factorial(n - r);
    }

    public static long calcCombinations(int n, int r) {
        if (r > n) throw new IllegalArgumentException("r must be less than or equal to n.");
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Welcome to the Permutations and Combinations Calculator");

        while (true) {
            System.out.print("Enter the total number of items (n): ");
            int n = scanner.nextInt();
            System.out.print("Enter the number of items to choose (r): ");
            int r = scanner.nextInt();

            if (n < 0 || r < 0 || r > n) {
                System.out.println("Invalid input. Please make sure that 0 <= r <= n and both are non-negative.");
                continue;
            }

            long permutations = calcPermutations(n, r);
            long combinations = calcCombinations(n, r);

            System.out.println("\nResults:");
            System.out.println("Permutations P(" + n + ", " + r + ") = " + permutations);
            System.out.println("Combinations C(" + n + ", " + r + ") = " + combinations + "\n");

            System.out.print("Do you want to calculate again? (yes/no): ");
            scanner.nextLine();
            String again = scanner.nextLine().trim().toLowerCase();
            if (!again.equals("yes")) {
                System.out.println("Thank you for using the calculator. Goodbye!");
                break;
            }
        }

        scanner.close();
    }
}
