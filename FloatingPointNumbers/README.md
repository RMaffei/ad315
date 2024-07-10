# BaseConverter #

This FloatingPointDemo is a Java-based application designed to demonstrate arithmetric with IEEE 754 floating-point numbers. This program deals with conversion and demonstrates the nuances of rounding modes, overflow, and underflow contexts. 

## Features ##

Convert Decimal to IEEE 754 Format: Enter a decimal number and see its IEEE 754 32-bit binary representation.

Arithmetic Operations: Perform arithmetic operations on the input number and display results in both decimal and IEEE 754 formats.

Special Values Handling: Generate and handle positive infinity, negative infinity, and NaN (Not a Number).

Rounding Modes: Demonstrate different rounding modes using BigDecimal.

Overflow and Underflow: Illustrate overflow and underflow scenarios using the input number.

## How to Use ##

Clone the repository
```
svn checkout https://github.com/RMaffei/ad315/FloatingPointNumbers/FloatingPointDemo.git.
```
Navigate to the cloned directory
	```
	cd FloatingPointDemo
	```

Compile the program
	```
	javac FloatingPointDemo.java
	```

Run the program
	```
	java FloatingPointDemo
	```

## Test Cases ##
1. 45.67 
01000010001101110101001001101101
01000010101101110101001001101101
01000001111100111010011111111101

2. -123.456
11000010111101101110100101111001
11000011011101101110100101111001
11000010001001000100110011001101

3. 98765.4321
01000110001100111010011001100101
98765.43
98765.43
98765.43
98765.44
98765.43


Test Case #3: Hexadecimal to Binary
1. 0.000000123456789
00111001111001100100001111101000
00111010011011001001011000010110
00111001011001011000101111101011

2. 1.0e38
01111111011110011001100110011010
01111111100000000000000000000000

3. 1.0e-45
00000000000000000000000000000001
00000000000000000000000000000000

