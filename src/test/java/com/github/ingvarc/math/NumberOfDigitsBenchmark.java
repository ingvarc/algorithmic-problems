package com.github.ingvarc.math;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static com.github.ingvarc.math.NumberOfDigits.*;

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
    public void countDigitsUsingDivisionBenchmark() {
        countDigitsUsingDivision(number);
    }

    @Benchmark
    public void countDigitsUsingMultiplicationBenchmark() {
        countDigitsUsingMultiplication(number);
    }

    @Benchmark
    public void countDigitsConvertingToStringBenchmark() {
        countDigitsConvertingToString(number);
    }

    @Benchmark
    public void countDigitsUsingCommonLogarithmBenchmark() {
        countDigitsUsingCommonLogarithm(number);
    }

    @Benchmark
    public void countDigitsUsingBitwiseShiftsBenchmark() {
        countDigitsUsingBitwiseShifts(number);
    }

    @Benchmark
    public void countDigitsUsingDivisionByPowerOfTwoBenchmark() {
        countDigitsUsingDivisionByPowerOfTwo(number);
    }
}