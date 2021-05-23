package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortingTheSentenceTest {

    private static record TestCase(String sentence, String expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase("sentence4 a3 is2 This1", "This is a sentence"),
                new TestCase("is2 sentence4 This1 a3", "This is a sentence"),
                new TestCase("Myself2 Me1 I4 and3", "Me Myself and I"),
                new TestCase("Test1", "Test")
        );
    }

    private SortingTheSentence sortingTheSentence = new SortingTheSentence();

    @ParameterizedTest
    @MethodSource("source")
    public void test(TestCase testCase) {
        assertEquals(testCase.expected, sortingTheSentence.sortSentence(testCase.sentence));
    }

}