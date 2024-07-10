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


        // method: perform arithmetic operations
        doMath();

        // handle special values
        handleSpecialValues();

        // demonstrate rounding modes
        demoRoundingModes();

        // demonstrate overflow
        demoOverflow();

        // demonstrate underflow
        demoUnderflow();
    }

    // convert decimal to IEEE 754 32-bit **single-precision** binary
    public static String convertTo754(float number) {
        int bits = Float.floatToIntBits(number);
        StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(bits));
        while (binaryString.length() < 32) {
            binaryString.insert(0, "0");
        }
        return binaryString.toString();
    }

    // perform arithmetic operations and show IEEE 754 results
    public static void doMath() {
        float num1 = 0.1f;
        float num2 = 0.2f;
        float sum = num1 + num2;
        float division = 1.0f / 3.0f;

        System.out.println("0.1 + 0.2 = " + sum);
        System.out.println("IEEE 754 of 0.1 + 0.2: " + Integer.toBinaryString(Float.floatToIntBits(sum)));

        System.out.println("1.0 / 3.0 = " + division);
        System.out.println("IEEE 754 of 1.0 / 3.0: " + Integer.toBinaryString(Float.floatToIntBits(division)));

        // explain discrepancies
        System.out.println("Floating-point arithmetic can lead to precision issues due to binary representation.");
    }

    // generate and handle special values
    public static void handleSpecialValues() {
        float posInfinity = Float.POSITIVE_INFINITY;
        float negInfinity = Float.NEGATIVE_INFINITY;
        float nanValue = Float.NaN;

        System.out.println("positive infinity: " + posInfinity);
        System.out.println("negative infinity: " + negInfinity);
        System.out.println("NaN: " + nanValue);
        System.out.println("is NaN equal to itself? " + (nanValue != nanValue));
    }

    // experiment with different rounding modes
    public static void demoRoundingModes() {
        BigDecimal number = new BigDecimal("2.675");

        System.out.println("rounding half_up: " + number.setScale(2, RoundingMode.HALF_UP));
        System.out.println("rounding half_down: " + number.setScale(2, RoundingMode.HALF_DOWN));
        System.out.println("rounding half_even: " + number.setScale(2, RoundingMode.HALF_EVEN));
        System.out.println("rounding up: " + number.setScale(2, RoundingMode.UP));
        System.out.println("rounding down: " + number.setScale(2, RoundingMode.DOWN));
    }

    // demonstrate overflow scenario
    public static void demoOverflow() {
        float overflowValue = Float.MAX_VALUE * 2;
        System.out.println("overflow: " + overflowValue);
    }

    // demonstrate underflow scenario
    public static void demoUnderflow() {
        float underflowValue = Float.MIN_VALUE / 2;
        System.out.println("underflow: " + underflowValue);
    }
}
