package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.ListNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotateLinkedListTest {

    private record TestCase(ListNode head, int k, ListNode expected) {

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(null, 2, null),
                new TestCase(ListNode.from(1, 2), 2, ListNode.from(1, 2)),
                new TestCase(ListNode.from(1, 2), 1, ListNode.from(2, 1)),
                new TestCase(ListNode.from(7, 7, 3, 5), 2, ListNode.from(3, 5, 7, 7)),
                new TestCase(ListNode.from(1, 2, 3, 4, 5), 3, ListNode.from(3, 4, 5, 1, 2)),
                new TestCase(ListNode.from(1, 2, 3, 4, 5), 0, ListNode.from(1, 2, 3, 4, 5)),
                new TestCase(ListNode.from(1, 2, 3, 4, 5), 4, ListNode.from(2, 3, 4, 5, 1))
        );
    }

    private final RotateLinkedList rotateLinkedList = new RotateLinkedList();

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertEquals(testCase.expected, rotateLinkedList.rotate(testCase.head, testCase.k));
    }

}