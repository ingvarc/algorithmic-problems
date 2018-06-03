package io.github.ingvarc.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.github.ingvarc.math.NumberOfDigits.*;
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

    @DisplayName("countDigitsUsingDivision(long);")
    @ParameterizedTest(name = "Digits in \"{0}\" should be {1}")
    @MethodSource("createNumbersWithLength")
    void countDigitsUsingDivisionTest(long number, int length) {
        assertEquals(countDigitsUsingDivision(number), length);
        assertThrows(IllegalArgumentException.class, () -> countDigitsUsingDivision(~number));
    }

    @DisplayName("countDigitsUsingMultiplication(long);")
    @ParameterizedTest(name = "Digits in \"{0}\" should be {1}")
    @MethodSource("createNumbersWithLength")
    void countDigitsUsingMultiplicationTest(long number, int length) {
        assertEquals(countDigitsUsingMultiplication(number), length);
        assertThrows(IllegalArgumentException.class, () -> countDigitsUsingMultiplication(~number));
    }

    @DisplayName("countDigitsConvertingToString(long);")
    @ParameterizedTest(name = "Digits in \"{0}\" should be {1}")
    @MethodSource("createNumbersWithLength")
    void countDigitsConvertingToStringTest(long number, int length) {
        assertEquals(countDigitsConvertingToString(number), length);
        assertThrows(IllegalArgumentException.class, () -> countDigitsConvertingToString(~number));
    }

    @DisplayName("countDigitsUsingCommonLogarithm(long);")
    @ParameterizedTest(name = "Digits in \"{0}\" should be {1}")
    @MethodSource("createNumbersWithLength")
    void countDigitsUsingCommonLogarithmTest(long number, int length) {
        assertEquals(countDigitsUsingCommonLogarithm(number), length);
        assertThrows(IllegalArgumentException.class, () -> countDigitsUsingCommonLogarithm(~number));
    }

    @DisplayName("countDigitsUsingBitwiseShifts(long);")
    @ParameterizedTest(name = "Digits in \"{0}\" should be {1}")
    @MethodSource("createNumbersWithLength")
    void countDigitsUsingBitwiseShiftsTest(long number, int length) {
        assertEquals(countDigitsUsingBitwiseShifts(number), length);
        assertThrows(IllegalArgumentException.class, () -> countDigitsUsingBitwiseShifts(~number));
    }

    @DisplayName("countDigitsUsingDivisionByPowerOfTwo(long);")
    @ParameterizedTest(name = "Digits in \"{0}\" should be {1}")
    @MethodSource("createNumbersWithLength")
    void countDigitsUsingDivisionByPowerOfTwoTest(long number, int length) {
        assertEquals(countDigitsUsingDivisionByPowerOfTwo(number), length);
        assertThrows(IllegalArgumentException.class, () -> countDigitsUsingDivisionByPowerOfTwo(~number));
    }
}