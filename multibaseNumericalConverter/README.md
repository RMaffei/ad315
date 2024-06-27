# BaseConverter

BaseConverter is a simple Java program that allows users to input a number and convert between different numerical bases, ranging from 2-16. The program uses a terminal interface to accept input from users and output the converted number. Users can perform multiple conversions until they choose to exit the program. 

## Features ##

Convert numbers between bases 2-16
Terminal interface for users
Allows multiple conversions in a single session

## How to Use ##

Clone the repository
```
svn checkout https://github.com/RMaffei/ad315/trunk/multibaseNumericalConverter.
```
Navigate to the cloned directory
```
cd multibaseNumericalConverter
```

Compile the program
```
javac BaseConverter.java
```

Run the program
```
java baseConverter
```
## Test Cases ##

### 1. Test Case: Binary to Decimal ###
  - Input:
    - Number: ‘1010’
    - Input base: ‘2’
    - Convert base: ‘10’
  - Expected output: ‘10’

### 2. Test Case: Decimal to Hexadecimal ###
  - Input: 
    - Number: ‘255’
    - Input Base: ‘10’
    - Convert base: ‘16’
  - Expected output: ‘FF’

### 3. Test Case: Hexadecimal to Binary ###
  - Input: 
    - Number: ‘0’
    - Input base: ‘2’
    - Convert base: ‘16’
  - Expected Output: ‘0’

## Edge Test Cases ##

### 1. Edge Case: Smallest Value in Base-2 ###
  - Input: 
    - Number: ‘0’
    - Input base: ‘16’
    - Convert base: ‘10’
  - Expected Output: ‘0’

### 2. Edge Case: Largest Value in Base-16 ###
  - Input:
    - Number: ‘FFFFFFFF’
    - Input base: ‘6’
    - Convert base: ‘10’
  - Expected Output: ‘4294967295’

### 3. Edge Case: Single Digit for Many Bases ###
  - Input:
    - Number: ‘1’
    - Input base: ‘2’
    - Convert base: ‘8’
  - Expected Output: ‘1’
