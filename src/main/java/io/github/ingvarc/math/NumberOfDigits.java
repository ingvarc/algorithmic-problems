package io.github.ingvarc.math;

/**
 * Different ways of getting the number of digits in a POSITIVE number.
 */
public class NumberOfDigits {

    private NumberOfDigits() {}

    /**
     * Validates the number to be positive.
     *
     * @param number any number to be validated
     * @throws IllegalArgumentException if the number is negative
     */
    private static void validateNumber(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("The number should be positive.");
        }
    }

    /**
     * Counts the number of the digits in the given number using division strategy.
     *
     * @param number any positive number
     * @return the number of the digits
     */
    public static int countDigitsUsingDivision(long number) {
        validateNumber(number);
        int length = 0;
        while (number != 0) {
            number /= 10;
            length++;
        }
        return length > 0 ? length : 1;
    }

    /**
     * Counts the number of the digits in the given number using multiplication strategy.
     *
     * @param number any positive number
     * @return the number of the digits
     */
    public static int countDigitsUsingMultiplication(long number) {
        validateNumber(number);
        int length = 0;
        long temp = 1;
        while (temp <= number && temp > 0) {
            length++;
            temp *= 10;
        }
        return length > 0 ? length : 1;
    }

    /**
     * Counts the number of the digits in the given number using {@link Long#toString(long)}.
     *
     * @param number any positive number
     * @return the number of the digits
     */
    public static int countDigitsConvertingToString(long number) {
        validateNumber(number);
        return Long.toString(number).length();
    }

    /**
     * Counts the number of the digits in the given number using common logarithm.
     *
     * @param number any positive number
     * @return the number of the digits
     */
    public static int countDigitsUsingCommonLogarithm(long number) {
        validateNumber(number);
        return (int) (number == 0 ? 1 : Math.log10(number) + 1);
    }

    /**
     * Counts the number of the digits in the given number using bitwise operations.
     *
     * @param number any positive number
     * @return the number of the digits
     */
    public static int countDigitsUsingBitwiseShifts(long number) {
        validateNumber(number);
        int length = 0;
        long temp = 1;
        while (temp <= number && temp > 0) {
            length++;
            temp = (temp << 3) + (temp << 1);
        }
        return length > 0 ? length : 1;
    }

    /**
     * Counts the number of the digits in the given number. Uses division by powers of two and recursion.
     *
     * @param number any positive number
     * @return the number of the digits
     */
    public static int countDigitsUsingDivisionByPowerOfTwo(long number) {
        validateNumber(number);
        int length = 0;
        if (number >= 100000000) {
            length += 8;
            number /= 100000000;
        }
        if (number >= 10000) {
            length += 4;
            number /= 10000;
        }
        if (number >= 100) {
            length += 2;
            number /= 100;
        }
        if (number >= 10) {
            length += 1;
            number /= 10;
        }
        return length > 0 ? length + countDigitsUsingDivisionByPowerOfTwo(number) : 1;
    }
}