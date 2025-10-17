package com.forketyfork.codingproblems;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCompressionTest {

    private static record TestCase(char[] input, int expectedLength, char[] expectedArray) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                // Basic compression
                new TestCase(
                    new char[] {'a', 'a', 'b', 'b', 'c', 'c', 'c'},
                    6,
                    new char[] {'a', '2', 'b', '2', 'c', '3'}
                ),
                // No compression needed (all different)
                new TestCase(
                    new char[] {'a', 'b', 'c'},
                    3,
                    new char[] {'a', 'b', 'c'}
                ),
                // Single character
                new TestCase(
                    new char[] {'a'},
                    1,
                    new char[] {'a'}
                ),
                // All same character
                new TestCase(
                    new char[] {'a', 'a', 'a', 'a'},
                    2,
                    new char[] {'a', '4'}
                ),
                // Two of same
                new TestCase(
                    new char[] {'a', 'a'},
                    2,
                    new char[] {'a', '2'}
                ),
                // Long run (double digit)
                new TestCase(
                    new char[] {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                    3,
                    new char[] {'a', '1', '2'}
                ),
                // Very long run (triple digit)
                new TestCase(
                    createCharArray('a', 100),
                    4,
                    new char[] {'a', '1', '0', '0'}
                ),
                // Mixed single and multiple
                new TestCase(
                    new char[] {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c'},
                    5,
                    new char[] {'a', 'b', '1', '2', 'c', '3'}
                ),
                // Alternating pattern
                new TestCase(
                    new char[] {'a', 'b', 'a', 'b'},
                    4,
                    new char[] {'a', 'b', 'a', 'b'}
                ),
                // Three characters, different counts
                new TestCase(
                    new char[] {'a', 'a', 'a', 'b', 'b', 'c'},
                    5,
                    new char[] {'a', '3', 'b', '2', 'c'}
                ),
                // Large count in middle
                new TestCase(
                    new char[] {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c'},
                    5,
                    new char[] {'a', 'b', '1', '0', 'c'}
                ),
                // Multiple double-digit runs
                new TestCase(
                    createMultipleRuns(),
                    6,
                    new char[] {'a', '1', '2', 'b', '1', '5'}
                ),
                // Capital letters
                new TestCase(
                    new char[] {'A', 'A', 'A', 'B', 'B'},
                    4,
                    new char[] {'A', '3', 'B', '2'}
                )
        );
    }

    private static char[] createCharArray(char c, int count) {
        char[] result = new char[count];
        for (int i = 0; i < count; i++) {
            result[i] = c;
        }
        return result;
    }

    private static char[] createMultipleRuns() {
        char[] result = new char[27];
        // 12 'a's followed by 15 'b's
        for (int i = 0; i < 12; i++) {
            result[i] = 'a';
        }
        for (int i = 12; i < 27; i++) {
            result[i] = 'b';
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        int resultLength = new StringCompression().compress(testCase.input);
        assertEquals(testCase.expectedLength, resultLength,
            "Compressed length should match expected value");

        // Only check the first resultLength characters
        char[] actualCompressed = new char[resultLength];
        System.arraycopy(testCase.input, 0, actualCompressed, 0, resultLength);
        assertArrayEquals(testCase.expectedArray, actualCompressed,
            "Compressed array content should match expected");
    }

}
