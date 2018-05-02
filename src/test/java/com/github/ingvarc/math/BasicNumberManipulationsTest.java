package com.github.ingvarc.math;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.github.ingvarc.math.BasicNumberManipulations.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test for BasicNumberManipulations class.
 */
class BasicNumberManipulationsTest {

    @DisplayName("Test countEvenDigits(long);")
    @ParameterizedTest(name = "Even digits in \"{0}\" should be {1}")
    @CsvSource({"0, 0", "1, 0", "12345678, 4", "2222222222222, 13", "2147483647, 6", "223372036854775807, 7"})
    void countEvenDigitsTest(long number, int expected) {
        assertThat(countEvenDigits(number), is(equalTo(expected)));
    }

    @DisplayName("Test countEvenDigits(long); throws IllegalArgumentException")
    @ParameterizedTest(name = "Illegal argument \"{0}\", throws exception")
    @CsvSource({"-1", "-12345678", "-2147483648", "-9223372036854775808"})
    void countEvenDigitsTestShouldThrowException(long number) {
        assertThrows(IllegalArgumentException.class, () -> countEvenDigits(number));
    }

    @DisplayName("Test containDigits(long, long);")
    @ParameterizedTest(name = "Check if number \"{0}\" contains {1}, result {2}")
    @CsvSource({"10, 5, false", "0, 0, true", "10, 0, true", "11, 11, true",
            "2147483647, 2147483647, true", "2147483647, 742, false", "2147483647, 483, true",
            "9223372036854775807, 9223372036854775807, true", "9223372036854775807, 65468, false", "9223372036854775807, 036854, true"})
    void containDigitClassicTest(long number, long digits, boolean assertion) {
        assertThat(containDigits(number, digits), is(assertion));
    }

    @DisplayName("Test containDigits(long, long); throws IllegalArgumentException")
    @ParameterizedTest(name = "Illegal argument \"{0}\" or \"{1}\", throws exception")
    @CsvSource({"-2147483648, -2147483648", "-2147483648, 956", "2147483648, -147",
            "-9223372036854775808, -9223372036854775808", "-9223372036854775808, 865367", "9223372036854775807, -922337"})
    void containDigitClassicTestShouldThrowException(long firstNum, long secondNum) {
        assertThrows(IllegalArgumentException.class, () -> containDigits(firstNum, secondNum));
    }

    @DisplayName("Test highestDigit(long);")
    @ParameterizedTest(name = "The highest digit in \"{0}\" is {1}")
    @CsvSource({"2147483647, 8", "0, 0", "1111111, 1", "11111119, 9", "9223372036854775807, 9"})
    void highestDigitTest(long number, int expected) {
        assertThat(highestDigit(number), is(CoreMatchers.equalTo(expected)));
    }

    @DisplayName("Test highestDigit(long); throws IllegalArgumentException")
    @ParameterizedTest(name = "Illegal argument \"{0}\", throws exception")
    @CsvSource({"-2147483648", "-1111111", "-11111119", "-9223372036854775807"})
    void highestDigitTestShouldThrowException(long number) {
        assertThrows(IllegalArgumentException.class, () -> highestDigit(number));
    }
}