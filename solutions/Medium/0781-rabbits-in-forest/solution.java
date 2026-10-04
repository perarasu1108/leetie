// ──────────────────────────────────────────────────
// Problem  : 781. Rabbits in Forest
// Difficulty: Medium
// Tags     : Array, Hash Table, Math, Greedy
// Link     : https://leetcode.com/problems/rabbits-in-forest/
// Runtime  : 6 ms (beats 8%)
// Memory   : 44168000 (beats 39%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.Arrays;

class Solution {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int res = 0, count = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 0) {
                res++;  
            } else if (i == 0 || answers[i] != answers[i - 1] || count == 0) {
                res += answers[i] + 1;  
                count = answers[i];
            } else {
                count--;  
            }
        }
        return res;
    }
}