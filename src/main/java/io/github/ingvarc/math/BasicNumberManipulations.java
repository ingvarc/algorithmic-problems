package io.github.ingvarc.math;

/**
 * Basic manipulations of POSITIVE numbers.
 */
public class BasicNumberManipulations {

    private BasicNumberManipulations() {}

    /**
     * Validates numbers.
     *
     * @param number any number to be validated
     * @throws IllegalArgumentException if the number is negative
     */
    private static void validateInput(long number) {
            if (number < 0) {
                throw new IllegalArgumentException("The number should be positive.");
            }
    }

    /**
     * Counts the number even digits in the given number.
     *
     * @param number any number
     * @return the number of even digits
     */
    public static int countEvenDigits(long number) {
        validateInput(number);
        int length = 0;
        while (number != 0) {
            long rightDigit = number % 10;
            if (rightDigit != 0 && rightDigit % 2 == 0) {
                length++;
            }
            number /= 10;
        }
        return length;
    }

    /**
     * Checks whether first number contains a sequence of digits of second number.
     *
     * @param firstNum  any positive number to look in
     * @param secondNum any positive number to look for
     * @return true if the sequence of digits of second number is present in the first number, false otherwise
     */
    public static boolean containDigits(long firstNum, long secondNum) {
        validateInput(firstNum);
        validateInput(secondNum);
        int div = 10;
        while (secondNum / div >= 1) {
            div *= 10;
        }
        if (firstNum >= 10) {
            while (firstNum / div >= 1) {
                if (firstNum % div == secondNum) {
                    return true;
                }
                firstNum /= 10;
            }
        }
        return firstNum == secondNum;
    }

    /**
     * Looks for the highest digit in the number.
     *
     * @param number any positive number
     * @return the highest digit in the number
     */
    public static int highestDigit(long number) {
        validateInput(number);
        int highestDigit = 0;
        int rightDigit;
        while (number != 0) {
            rightDigit = (int) number % 10;
            if (rightDigit == 9) {
                return 9;
            }
            if (rightDigit > highestDigit) {
                highestDigit = rightDigit;
            }
            number /= 10;
        }
        return highestDigit;
    }

}
