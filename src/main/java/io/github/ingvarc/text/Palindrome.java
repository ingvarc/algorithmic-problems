package io.github.ingvarc.text;

import java.util.stream.IntStream;

/**
 * Checks whether a given String is a palindrome.
 */
public class Palindrome {

    /**
     * Removes everything except for letters and numbers and makes capital letters lower case.
     *
     * @param text text to be cleaned
     * @return cleaned text
     */
    private static String cleanText(String text) {
        validateInput(text);
        return text.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
    }

    /**
     * Validates the text.
     *
     * @param text text to be validated
     * @throws IllegalArgumentException if the text is null or empty
     */
    private static void validateInput(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Determines whether the text is a palindrome.
     *
     * @param text any text
     * @return true if the text is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String text) {
        String cleanText = cleanText(text);
        validateInput(cleanText);
        int forward = 0;
        int backward = cleanText.length() - 1;
        char[] charArray = cleanText.toCharArray();
        while (backward > forward) {
            if (charArray[forward++] != charArray[backward--]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines whether the text is a palindrome.
     *
     * @param text any text
     * @return true if the text is a palindrome, false otherwise
     */
    public static boolean isPalindromeReverseString(String text) {
        String cleanText = cleanText(text);
        validateInput(cleanText);
        int halfLength = cleanText.length() / 2;
        char[] charArray = new char[halfLength];
        cleanText.getChars(0, halfLength, charArray, 0);
        return new StringBuilder()
                .append(charArray)
                .reverse().toString()
                .equals(cleanText.substring(cleanText.length() % 2 == 0 ? halfLength : halfLength + 1));
    }

    /**
     * Determines whether the text is a palindrome. Uses {@link StringBuilder#reverse()}.
     *
     * @param text any text
     * @return true if the text is a palindrome, false otherwise
     */
    public static boolean isPalindromeStringBuilder(String text) {
        String cleanText = cleanText(text);
        validateInput(cleanText);
        return new StringBuilder(cleanText).reverse().toString().equals(cleanText);
    }

    /**
     * Determines whether the text is a palindrome. Uses {@link IntStream}.
     *
     * @param text any text
     * @return true if the text is a palindrome, false otherwise
     */
    public static boolean isPalindromeIntStream(String text) {
        String cleanText = cleanText(text);
        validateInput(cleanText);
        return IntStream
                .range(0, cleanText.length() / 2)
                .noneMatch(i -> cleanText.charAt(i) != cleanText.charAt(cleanText.length() - i - 1));
    }
}
