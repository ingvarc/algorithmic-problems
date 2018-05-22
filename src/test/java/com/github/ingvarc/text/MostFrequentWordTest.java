package com.github.ingvarc.text;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.github.ingvarc.text.MostFrequentWord.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class MostFrequentWordTest {

    private static Stream<Arguments> createSampleSentences() {
        return Stream.of(of("bb aa cc dd aa", "aa"), of("aa", "aa"), of(" ", ""));
    }

    @ParameterizedTest(name = "The most frequent word in \"{0}\" is \"{1}\"")
    @MethodSource({"createSampleSentences"})
    void getMostFrequentWordTest(String text, String expected) {
        assertThat(getMostFrequentWord(text), is(expected));
    }

    @ParameterizedTest(name = "The most frequent word in \"{0}\" is \"{1}\"")
    @MethodSource({"createSampleSentences"})
    void getMostFrequentWordUsingMapTest(String text, String expected) {
        assertThat(getMostFrequentWordUsingMap(text), is(expected));
    }

    @ParameterizedTest(name = "The most frequent word in \"{0}\" is \"{1}\"")
    @MethodSource({"createSampleSentences"})
    void getMostFrequentWordUsingStreamsTest(String text, String expected) {
        assertThat(getMostFrequentWordUsingStreams(text), is(expected));
    }
}