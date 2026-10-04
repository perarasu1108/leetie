// ──────────────────────────────────────────────────
// Problem  : 763. Partition Labels
// Difficulty: Medium
// Tags     : Hash Table, Two Pointers, String, Greedy
// Link     : https://leetcode.com/problems/partition-labels/
// Runtime  : 10 ms (beats 24%)
// Memory   : 43920000 (beats 28%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastOccurrence.get(s.charAt(i)));
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}