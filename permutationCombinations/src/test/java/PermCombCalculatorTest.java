import org.junit.Test;
import static org.junit.Assert.*;

public class PermCombCalculatorTest {

    @Test
    public void testCalculatePermutations() {
        assertEquals(504, PermCombCalculator.calcPermutations(7, 3));
        assertEquals(20, PermCombCalculator.calcPermutations(5, 2));
        assertEquals(6720, PermCombCalculator.calcPermutations(8, 5));
    }

    @Test
    public void testCalculateCombinations() {
        assertEquals(35, PermCombCalculator.calcCombinations(7, 3));
        assertEquals(10, PermCombCalculator.calcCombinations(5, 2));
        assertEquals(56, PermCombCalculator.calcCombinations(8, 5));
    }

    @Test
    public void testEdgeCases() {
        // Edge Case 1: n = 0, r = 0
        assertEquals(1, PermCombCalculator.calcPermutations(0, 0));
        assertEquals(1, PermCombCalculator.calcCombinations(0, 0));

        // Edge Case 2: n = 5, r = 0
        assertEquals(1, PermCombCalculator.calcPermutations(5, 0));

        assertEquals(1, PermCombCalculator.calcCombinations(5, 0));

        // Edge Case 3: n = 5, r = 5
        assertEquals(120, PermCombCalculator.calcPermutations(5, 5));
        assertEquals(1, PermCombCalculator.calcCombinations(5, 5));

        // Edge Case 4: n = 1, r = 1
        assertEquals(1, PermCombCalculator.calcPermutations(1, 1));
        assertEquals(1, PermCombCalculator.calcCombinations(1, 1));

        // Edge Case 5: n = 10, r = 10
        assertEquals(3628800, PermCombCalculator.calcPermutations(10, 10));
        assertEquals(1, PermCombCalculator.calcCombinations(10, 10));

        // Edge Case 6: n = 10, r = 11 (invalid case, should handle gracefully)
        try {
            PermCombCalculator.calcPermutations(10, 11);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
        try {
            PermCombCalculator.calcCombinations(10, 11);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
