import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class FloatingPointDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // convert decimal to IEEE 754 format
        System.out.print("Enter a decimal number: ");
        float decimalInput = scanner.nextFloat();
        String ieee754Format = convertTo754(decimalInput);
        System.out.println("IEEE 754 representation: " + ieee754Format);

        // perform operations on the entered number
        doMath(decimalInput);
        handleSpecialValues(decimalInput);
        demoRoundingModes(decimalInput);
        demoOverflow(decimalInput);
        demoUnderflow(decimalInput);
    }

    // convert decimal to IEEE 754 32-bit single-precision binary
    public static String convertTo754(float number) {
        int bits = Float.floatToIntBits(number);
        StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(bits));
        while (binaryString.length() < 32) {
            binaryString.insert(0, "0");
        }
        return binaryString.toString();
    }

    // perform arithmetic operations and show IEEE 754 results
    public static void doMath(float number) {
        float sum = number + number; // example: adding the number to itself
        float division = number / 3.0f;

        System.out.println(number + " + " + number + " = " + sum);
        System.out.println("IEEE 754 of " + number + " + " + number + ": " + Integer.toBinaryString(Float.floatToIntBits(sum)));

        System.out.println(number + " / 3.0 = " + division);
        System.out.println("IEEE 754 of " + number + " / 3.0: " + Integer.toBinaryString(Float.floatToIntBits(division)));

        // explain discrepancies
        System.out.println("doing math with floating-point #s can lead to precision issues due to binary representation.");
    }

    // generate and handle special values
    public static void handleSpecialValues(float number) {
        float posInfinity = Float.POSITIVE_INFINITY;
        float negInfinity = Float.NEGATIVE_INFINITY;
        float nanValue = Float.NaN;
        System.out.println("positive infinity: " + posInfinity);
        System.out.println("negative infinity: " + negInfinity);
        System.out.println("NaN: " + nanValue);
        System.out.println("is NaN not equal to itself? " + (nanValue != nanValue));
    }

    // experiment with different rounding modes
    public static void demoRoundingModes(float number) {
        BigDecimal bigDecimalNumber = new BigDecimal(number);
        System.out.println("rounding half_up: " + bigDecimalNumber.setScale(2, RoundingMode.HALF_UP));
        System.out.println("rounding half_down: " + bigDecimalNumber.setScale(2, RoundingMode.HALF_DOWN));
        System.out.println("rounding half_even: " + bigDecimalNumber.setScale(2, RoundingMode.HALF_EVEN));
        System.out.println("rounding up: " + bigDecimalNumber.setScale(2, RoundingMode.UP));
        System.out.println("rounding down: " + bigDecimalNumber.setScale(2, RoundingMode.DOWN));
    }

    // demonstrate overflow scenario
    public static void demoOverflow(float number) {
        float overflowValue = number * Float.MAX_VALUE;
        System.out.println("overflow: " + overflowValue);
    }

    // demonstrate underflow scenario
    public static void demoUnderflow(float number) {
        float underflowValue = number * Float.MIN_VALUE;
        System.out.println("underflow: " + underflowValue);
    }
}