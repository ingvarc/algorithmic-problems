package com.github.ingvarc.text;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.of;

class PalindromeTest {

    private static Stream<Arguments> createPalindromeWords() {
        return Stream.of(of("Anna"), of("Civic"), of("Kayak"), of("Level"), of("Madam"), of("Mom"),
                of("Noon"), of("Racecar"), of("Radar"), of("Redder"), of("Refer"), of("Repaper"),
                of("Rotator"), of("Rotor"), of("Sagas"), of("Solos"), of("Stats"), of("Tenet"), of("Wow"));
    }

    private static Stream<Arguments> createPalindromeSentences() {
        return Stream.of(of("Evil olive"), of("Noel sees Leon"), of("No lemon, no melon"),
                of("Rise to vote sir"), of("A nut for a jar of tuna"), of("Some men interpret nine memos"),
                of("Gateman sees name, garageman sees nametag"));
    }

    private static Stream<Arguments> createNonPalindromeWords() {
        return Stream.of(of("Annas"), of("Kayaks"), of("Levels"), of("Madams"), of("Moms"), of("Racecars"),
                of("Radars"), of("Refers"), of("Rotators"), of("Rotors"), of("Saga"), of("Solo"), of("State"));
    }

    private static Stream<Arguments> createNonPalindromeSentences() {
        return Stream.of(of("Evil olives"), of("Noel saw Leon"), of("No lemons, no melons"),
                of("Rise not to vote sir"), of("A nut for jars of tuna"), of("Some men interpreted nine memos"),
                of("Gatemen see name, garagemen see nametag"));
    }

    @ParameterizedTest(name = "\"{0}\" is a palindrome")
    @MethodSource({"createPalindromeWords", "createPalindromeSentences"})
    void isPalindrome(String text) {
        assertThat(Palindrome.isPalindrome(text), is(true));
    }

    @ParameterizedTest(name = "\"{0}\" is not a palindrome")
    @MethodSource({"createNonPalindromeWords", "createNonPalindromeSentences"})
    void isPalindromeForNonPalindrome(String text) {
        assertThat(Palindrome.isPalindrome(text), is(false));
    }

    @Test
    void isPalindromeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Palindrome.isPalindrome(null));
        assertThrows(IllegalArgumentException.class, () -> Palindrome.isPalindrome(""));
        assertThrows(IllegalArgumentException.class, () -> Palindrome.isPalindrome(",!!,"));
    }

    @ParameterizedTest(name = "\"{0}\" is a palindrome")
    @MethodSource({"createPalindromeWords", "createPalindromeSentences"})
    void isPalindromeReverseString(String text) {
        assertThat(Palindrome.isPalindromeReverseString(text), is(true));
    }

    @ParameterizedTest(name = "\"{0}\" is not a palindrome")
    @MethodSource({"createNonPalindromeWords", "createNonPalindromeSentences"})
    void isPalindromeReverseStringForNonPalindrome(String text) {
        assertThat(Palindrome.isPalindromeReverseString(text), is(false));
    }

    @Test
    void isPalindromeReverseStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Palindrome.isPalindromeReverseString(null));
        assertThrows(IllegalArgumentException.class, () -> Palindrome.isPalindromeReverseString(""));
        assertThrows(IllegalArgumentException.class, () -> Palindrome.isPalindromeReverseString(",!!,"));
    }

    @ParameterizedTest(name = "\"{0}\" is a palindrome")
    @MethodSource({"createPalindromeWords", "createPalindromeSentences"})
    void isPalindromeStringBuilder(String text) {
        assertThat(Palindrome.isPalindromeStringBuilder(text), is(true));
    }

    @ParameterizedTest(name = "\"{0}\" is not a palindrome")
    @MethodSource({"createNonPalindromeWords", "createNonPalindromeSentences"})
    void isPalindromeStringBuilderForNonPalindrome(String text) {
        assertThat(Palindrome.isPalindromeStringBuilder(text), is(false));
    }

    @Test
    void isPalindromeStringBuilderThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Palindrome.isPalindromeStringBuilder(null));
        assertThrows(IllegalArgumentException.class, () -> Palindrome.isPalindromeStringBuilder(""));
        assertThrows(IllegalArgumentException.class, () -> Palindrome.isPalindromeStringBuilder(",!!,"));
    }

    @ParameterizedTest(name = "\"{0}\" is a palindrome")
    @MethodSource({"createPalindromeWords", "createPalindromeSentences"})
    void isPalindromeIntStream(String text) {
        assertThat(Palindrome.isPalindromeIntStream(text), is(true));
    }

    @ParameterizedTest(name = "\"{0}\" is not a palindrome")
    @MethodSource({"createNonPalindromeWords", "createNonPalindromeSentences"})
    void isPalindromeIntStreamForNonPalindrome(String text) {
        assertThat(Palindrome.isPalindromeIntStream(text), is(false));
    }

    @Test
    void isPalindromeIntStreamThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Palindrome.isPalindromeIntStream(null));
        assertThrows(IllegalArgumentException.class, () -> Palindrome.isPalindromeIntStream(""));
        assertThrows(IllegalArgumentException.class, () -> Palindrome.isPalindromeIntStream(",!!,"));
    }
}