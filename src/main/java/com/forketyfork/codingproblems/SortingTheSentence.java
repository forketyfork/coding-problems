package com.forketyfork.codingproblems;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 * Each word consists of lowercase and uppercase English letters.
 * <p>
 * A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words
 * in the sentence.
 * <p>
 * For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1"
 * or "is2 sentence4 This1 a3".
 * <p>
 * Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.
 *
 * @see <a href="https://leetcode.com/problems/sorting-the-sentence/">LeetCode #1859. Sorting the Sentence</a>
 */
public class SortingTheSentence {

    public String sortSentence(String s) {
        return Stream.of(s.split(" "))
                .map(OrderedWord::new)
                .sorted()
                .map(OrderedWord::getWord)
                .collect(Collectors.joining(" "));
    }

    private static class OrderedWord implements Comparable<OrderedWord> {

        private final int num;

        private final String word;

        private final int hashCode;

        public String getWord() {
            return word;
        }

        OrderedWord(String string) {
            int last = string.length() - 1;
            this.num = string.charAt(last) - '0';
            this.word = string.substring(0, last);
            this.hashCode = Objects.hash(num, word);
        }

        @Override
        public int compareTo(OrderedWord other) {
            return Integer.compare(this.num, other.num);
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof OrderedWord otherWord) {
                return otherWord.num == this.num && otherWord.word.equals(this.word);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return hashCode;
        }
    }

}

