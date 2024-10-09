package com.forketyfork.codingproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, List<Integer>> swords = new HashMap<>();
        int wordLen = words[0].length();
        for (int i = 0; i <= s.length() - words.length * wordLen; i++) {
            String sword = s.substring(i, i + wordLen);
            swords.computeIfAbsent(sword, w -> new ArrayList<>()).add(i);
        }
        Map<String, List<Integer>> wordIdxs = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordIdxs.computeIfAbsent(words[i], w -> new ArrayList<>()).add(i);
        }
        List<Integer> result = new ArrayList<>();
        for (var entry : wordIdxs.entrySet()) {
            int i = entry.getValue().get(0);
            List<Integer> starts = swords.get(entry.getKey());
            if (starts == null) {
                continue; // not a starting word
            }
            lstarts:
            for (int start : starts) {
                int seenWords = 1 << i;
                int next = start + wordLen;
                lsubstring:
                for (int wordNum = 1; wordNum < words.length; wordNum++, next += wordLen) {
                    String nextWord = s.substring(next, next + wordLen);
                    List<Integer> wordIdx = wordIdxs.get(nextWord);
                    if (wordIdx == null) {
                        continue lstarts; // no matching next word
                    }
                    for (int idx : wordIdx) {
                        int flag = 1 << idx;
                        if ((seenWords & flag) == 0) { // word instance is not yet used
                            seenWords |= flag;
                            continue lsubstring;
                        }
                    }
                    continue lstarts; // all word instances are already used
                }
                result.add(start);
            }
        }
        return result;
    }
}
