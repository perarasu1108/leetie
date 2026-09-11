// ──────────────────────────────────────────────────
// Problem  : 3483. Unique 3-Digit Even Numbers
// Difficulty: Easy
// Tags     : Array, Hash Table, Recursion, Enumeration
// Link     : https://leetcode.com/problems/unique-3-digit-even-numbers/
// Runtime  : 1 ms (beats 100%)
// Memory   : 43536000 (beats 99%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) freq[d]++;

        int count = 0;

        for (int h = 1; h <= 9; h++) {
            if (freq[h] == 0) continue;
            freq[h]--;

            for (int t = 0; t <= 9; t++) {
                if (freq[t] == 0) continue;
                freq[t]--;

                for (int u = 0; u <= 8; u += 2) {
                    if (freq[u] > 0) count++;
                }

                freq[t]++;
            }

            freq[h]++;
        }

        return count;
    }
}