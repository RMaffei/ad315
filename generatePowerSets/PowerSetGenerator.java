import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PowerSetGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Set<String> inputSet = new HashSet<>();
            System.out.println("Enter items of the given set (type 'done' to finish):");

            while (true) {
                String item = scanner.nextLine();
                if (item.equalsIgnoreCase("done")) {
                    break;
                }
                inputSet.add(item);
            }

            List<Set<String>> powerSet = generatePowerSet(inputSet);
            System.out.println("Power Set: ");
            for (Set<String> subset : powerSet) {
                System.out.println(subset);
            }

            System.out.println("Do you want to enter another set? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }

        scanner.close();
    }

    public static List<Set<String>> generatePowerSet(Set<String> originalSet) {
        List<Set<String>> powerSet = new ArrayList<>();
        powerSet.add(new HashSet<>()); // add the empty set

        for (String item : originalSet) {
            List<Set<String>> newSubsets = new ArrayList<>();
            for (Set<String> subset : powerSet) {
                Set<String> newSubset = new HashSet<>(subset);
                newSubset.add(item);
                newSubsets.add(newSubset);
            }
            powerSet.addAll(newSubsets);
        }

        return powerSet;
    }
}