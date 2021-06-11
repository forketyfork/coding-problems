package com.forketyfork.codingproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class PhoneNumber {

    private static final String[] MAPPING = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        List<char[]> result = new ArrayList<>();

        char[] proto = new char[digits.length()];
        result.add(proto);

        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            String letters = MAPPING[c - '0' - 2];
            int size = result.size();
            for (int j = 0; j < size; j++) {
                char[] curr = result.get(j);
                curr[i] = letters.charAt(0);
                for (int k = 1; k < letters.length(); k++) {
                    char[] copy = new char[digits.length()];
                    System.arraycopy(curr, 0, copy, 0, i);
                    copy[i] = letters.charAt(k);
                    result.add(copy);
                }
            }
        }

        return result.stream()
                .map(String::new)
                .collect(Collectors.toList());
    }
}
