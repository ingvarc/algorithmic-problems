package io.github.ingvarc.text;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 10, time = 1)
@Fork(1)
@State(Scope.Thread)
public class PalindromeBenchmark {

    @Param({"Anna", "Racecar", "Evil olive", "Noel sees Leon", "No lemon, no melon",
            "Some men interpret nine memos", "Gateman sees name, garageman sees nametag"})
    private String text;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(PalindromeBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public void isPalindrome() {
        Palindrome.isPalindrome(text);
    }

    @Benchmark
    public void isPalindromeReverseString() {
        Palindrome.isPalindromeReverseString(text);
    }

    @Benchmark
    public void isPalindromeStringBuilder() {
        Palindrome.isPalindromeStringBuilder(text);
    }

    @Benchmark
    public void countDigitsLog() {
        Palindrome.isPalindromeIntStream(text);
    }
}