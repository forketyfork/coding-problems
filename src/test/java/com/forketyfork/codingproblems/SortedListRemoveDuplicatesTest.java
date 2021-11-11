package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.ListNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortedListRemoveDuplicatesTest {

    private static record TestCase(ListNode head, ListNode expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(null, null),
                new TestCase(ListNode.from(1), ListNode.from(1)),
                new TestCase(ListNode.from(1, 2), ListNode.from(1, 2)),
                new TestCase(ListNode.from(1, 2, 2, 3), ListNode.from(1, 2, 3)),
                new TestCase(ListNode.from(1, 1, 2, 3), ListNode.from(1, 2, 3)),
                new TestCase(ListNode.from(1, 2, 3, 3), ListNode.from(1, 2, 3)),
                new TestCase(ListNode.from(1, 2, 2, 2, 3), ListNode.from(1, 2, 3))
        );
    }

    private final SortedListRemoveDuplicates sortedListRemoveDuplicates = new SortedListRemoveDuplicates();

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, sortedListRemoveDuplicates.deleteDuplicates(testCase.head));
    }

}