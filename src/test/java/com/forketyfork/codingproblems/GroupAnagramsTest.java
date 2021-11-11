package com.forketyfork.codingproblems;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAnagramsTest {

    private static record TestCase(String[] strs, Set<Set<String>> expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(new String[] {""}, Set.of(Set.of(""))),
                new TestCase(new String[] {"a"}, Set.of(Set.of("a"))),
                new TestCase(new String[] {"ab", "ba"}, Set.of(Set.of("ab", "ba"))),
                new TestCase(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"},
                        Set.of(Set.of("bat"),
                                Set.of("nat", "tan"),
                                Set.of("ate", "eat", "tea")))
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, new GroupAnagrams().groupAnagrams(testCase.strs)
                .stream()
                .map(HashSet::new)
                .collect(Collectors.toSet()));
    }

}