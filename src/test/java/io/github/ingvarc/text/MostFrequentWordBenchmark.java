package io.github.ingvarc.text;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 10, time = 1)
@Fork(1)
@State(Scope.Thread)
public class MostFrequentWordBenchmark {

    private static final String TEXT = "instituted limited cash benefits the elderly poor about half states offered cash benefits blind some governments " +
            "tried provide local officials tried assess recipients needs some extent their moral worthiness prior federal government " +
            "played almost role providing relief spending beyond veterans depression deepened tax revenues dropped between state local " +
            "social welfare with aid loans from newly created reconstruction finance corporation average risen faced with national " +
            "unemployment rates near roosevelt administration accepted responsibility relief arguing that unemployment poverty become " +
            "national problem federal from sources sample cities jumped then first full year new deal annual average benefit payments " +
            "relief household during this early phase new deal replaced between average annual manufacturing earnings figure plot " +
            "differences differences between for sample cities administration federal fera officials distributed funds state governments " +
            "through opaque process which officials seem have paid attention economic distress state state entreaties fera administrators " +
            "state efforts fund relief likelihood funds influencing roosevelt state governments then distributed relief direct relief " +
            "included programs that specific work requirements assistance provided cash kind including subsistence items such food shelter " +
            "clothing household necessities medical care hospitalization work relief required labor government project fera series broad " +
            "guidelines its programs relied heavily state local officials administer receive applicants relief applied local offices where " +
            "officials with them determined their eligibility relief based budget deficit between family total income hypothetical expected " +
            "spending family that size this budget deficit the basis the family direct relief benefits work relief payment fera project actual " +
            "relief cases lowered benefits case more households response harsh winter high levels unemployment fera activities were supplemented " +
            "temporarily civil works administration work relief program from november through march large numbers fera relief rolls were " +
            "transferred employment where they received wages that were the shut down months later many workers were shifted fera work relief " +
            "roosevelt administration redesigned relief system federal government continued provide work relief the employable unemployed through " +
            "works progress administration returned much responsibility direct relief unemployables considered family budget deficit when assessing " +
            "need relief employment federal then hired people from certified rolls wpa like fera predecessor used hard fast rules distribute funds " +
            "econometric studies have found that local economic distress lobbying state local governments presidential contributed matching funds aid " +
            "unemployables social security introduced state federal versions many states prior age assistance mothers pensions aid blind end but " +
            "eight states were receiving federal grants shift federal relief efforts the eventual reductions spending caused federal government share " +
            "relief spending meanwhile average capita relief spending cities rose fell spiked downturn declined relief benefits rose between average " +
            "annual manufacturing earnings after performing analysis focus combined course making hard isolate each program effect addition categorical " +
            "programs like and state mothers pensions too narrowly focused when matched with measures demographic outcomes many states mothers " +
            "pensions the later dependent children programs were limited households with children with least parent infants received relief from general " +
            "programs measure capita relief spending the cities analysis this section combines direct relief work relief private relief funds from " +
            "levels government federal relief data includes cwa fera and social security programs aid dependent children blind old assistance sample " +
            "average average annual manufacturing earnings from bureau census average relief expenditures household based data national resources " +
            "planning board federal share relief spending from national resources planning board fishback kantor wallis fleck analyze board describe " +
            "administration fera cwa fishback kantor wallis the numerous references cited therein reported integrated public microdata series from " +
            "empirical model infant mortality rates goal examine relationship between relief the general fertility rate the same basic modeling " +
            "procedures each demographic outcome establish template all analyses first working through estimations infant mortality rates then examine " +
            "remaining demographic outcomes estimate following reduced form infant mortality equation capita relief spending city year economic activity " +
            "vector demographic characteristics random error because income data city level exist the per capita retail sales county where city located " +
            "measure economic vector contains series socioeconomic factors these include percent black income cultural practices toward raising infants " +
            "control the differences health maturity among potential childbearing population infant mortality general fertility";

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MostFrequentWordBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public void getMostFrequentWord() {
        MostFrequentWord.getMostFrequentWord(TEXT);
    }

    @Benchmark
    public void getMostFrequentWordUsingMap() {
        MostFrequentWord.getMostFrequentWordUsingMap(TEXT);
    }

    @Benchmark
    public void getMostFrequentWordUsingStreams() {
        MostFrequentWord.getMostFrequentWordUsingStreams(TEXT);
    }
}