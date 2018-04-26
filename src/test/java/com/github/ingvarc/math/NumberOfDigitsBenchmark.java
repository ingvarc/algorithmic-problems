package com.github.ingvarc.math;

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
public class NumberOfDigitsBenchmark {

    @Param({"0", "1", "2147483647", "9223372036854775807"})
    private long number;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(NumberOfDigitsBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public void countDigitsByDivision() {
        NumberOfDigits.countDigitsByDivision(number);
    }

    @Benchmark
    public void countDigitsByMultiplication() {
        NumberOfDigits.countDigitsByMultiplication(number);
    }

    @Benchmark
    public void countDigitsToString() {
        NumberOfDigits.countDigitsToString(number);
    }

    @Benchmark
    public void countDigitsLog() {
        NumberOfDigits.countDigitsLog(number);
    }

    @Benchmark
    public void countDigitsBitwise() {
        NumberOfDigits.countDigitsBitwise(number);
    }

    @Benchmark
    public void countDigitsByDivisionByPowerOfTwo() {
        NumberOfDigits.countDigitsByDivisionByPowerOfTwo(number);
    }
}