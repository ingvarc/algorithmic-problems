package com.github.ingvarc.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.of;

class NumberOfDigitsTest {

    private static Stream<Arguments> createNumbersWithLength() {
        return Stream.of(
                of(0L, 1),
                of(1L, 1),
                of((long) Integer.MAX_VALUE, 10),
                of(Long.MAX_VALUE, 19));
    }

    @DisplayName("countDigitsByDivision(long);")
    @ParameterizedTest(name = "Digits in \"{0}\" should be {1}")
    @MethodSource("createNumbersWithLength")
    void countDigitsByDivision(long number, int length) {
        assertEquals(NumberOfDigits.countDigitsByDivision(number), length);
        assertThrows(IllegalArgumentException.class, () -> NumberOfDigits.countDigitsByDivision(~number));
    }

    @DisplayName("countDigitsByMultiplication(long);")
    @ParameterizedTest(name = "Digits in \"{0}\" should be {1}")
    @MethodSource("createNumbersWithLength")
    void countDigitsByMultiplication(long number, int length) {
        assertEquals(NumberOfDigits.countDigitsByMultiplication(number), length);
        assertThrows(IllegalArgumentException.class, () -> NumberOfDigits.countDigitsByMultiplication(~number));
    }

    @DisplayName("countDigitsToString(long);")
    @ParameterizedTest(name = "Digits in \"{0}\" should be {1}")
    @MethodSource("createNumbersWithLength")
    void countDigitsToString(long number, int length) {
        assertEquals(NumberOfDigits.countDigitsToString(number), length);
        assertThrows(IllegalArgumentException.class, () -> NumberOfDigits.countDigitsToString(~number));
    }

    @DisplayName("countDigitsLog(long);")
    @ParameterizedTest(name = "Digits in \"{0}\" should be {1}")
    @MethodSource("createNumbersWithLength")
    void countDigitsLog(long number, int length) {
        assertEquals(NumberOfDigits.countDigitsLog(number), length);
        assertThrows(IllegalArgumentException.class, () -> NumberOfDigits.countDigitsLog(~number));
    }

    @DisplayName("countDigitsBitwise(long);")
    @ParameterizedTest(name = "Digits in \"{0}\" should be {1}")
    @MethodSource("createNumbersWithLength")
    void countDigitsBitwise(long number, int length) {
        assertEquals(NumberOfDigits.countDigitsBitwise(number), length);
        assertThrows(IllegalArgumentException.class, () -> NumberOfDigits.countDigitsBitwise(~number));
    }

    @DisplayName("countDigitsByDivisionByPowerOfTwo(long);")
    @ParameterizedTest(name = "Digits in \"{0}\" should be {1}")
    @MethodSource("createNumbersWithLength")
    void countDigitsByDivisionByPowerOfTwo(long number, int length) {
        assertEquals(NumberOfDigits.countDigitsByDivisionByPowerOfTwo(number), length);
        assertThrows(IllegalArgumentException.class, () -> NumberOfDigits.countDigitsByDivisionByPowerOfTwo(~number));
    }
}