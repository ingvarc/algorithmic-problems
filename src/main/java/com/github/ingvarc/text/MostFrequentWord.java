package com.github.ingvarc.text;

import java.util.*;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.regex.Pattern;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Find the most frequent word appeared in a String.
 */
public class MostFrequentWord {

    private MostFrequentWord(){}

    /**
     * Removes everything except for letters and numbers and makes capital letters lower case.
     *
     * @param text text to be cleaned
     * @return cleaned text
     */
    private static String cleanText(String text) {
        validateInput(text);
        return text.replaceAll("[^a-zA-Z0-9\\s]+", "").toLowerCase();
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
     * Simple and efficient solution for short sentences with O(n) complexity.
     *
     * @param text any text
     * @return the most frequent word in the given text
     */
    public static String getMostFrequentWord(String text) {
        String[] words = cleanText(text).split(" ");

        int frequency = 0;
        int biggestFrequency = 0;
        String mostFrequentWord = words.length >= 1 ? words[0] : "";

        for (int i = 1; i < words.length; i++) {
            frequency = (words[i].equals(mostFrequentWord)) ? frequency + 1 : 1;
            if (frequency > biggestFrequency) {
                biggestFrequency = frequency;
                mostFrequentWord = words[i];
            }
        }
        return mostFrequentWord;
    }

    /**
     * Memory consuming solution using Map.
     *
     * @param text any text
     * @return the most frequent word in the given text
     */
    public static String getMostFrequentWordUsingMap(String text) {
        String[] words = cleanText(text).split(" ");

        HashMap<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            int frequency = 1;
            if (wordCountMap.containsKey(word)) {
                frequency = wordCountMap.get(word) + 1;
            }
            wordCountMap.put(word, frequency);
        }

        Map.Entry<String,Integer> mostFrequent = null;
        for(Map.Entry<String, Integer> entry: wordCountMap.entrySet()) {
            if(mostFrequent == null || mostFrequent.getValue() < entry.getValue()) {
                mostFrequent = entry;
            }
        }
        return mostFrequent != null ? mostFrequent.getKey() : "";
    }

    /**
     * Solution using Stream API.
     *
     * @param text any text
     * @return the most frequent word in the given text
     */
    public static String getMostFrequentWordUsingStreams(String text) {
        return Pattern.compile(" ").splitAsStream(text)
                .collect(groupingBy(s -> s, counting()))
                .entrySet()
                .stream()
                .max(comparing(Map.Entry::getValue))
                .orElse(new SimpleImmutableEntry<>("", 0L)).getKey();

    }
}