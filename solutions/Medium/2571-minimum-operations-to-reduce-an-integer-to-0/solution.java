// ──────────────────────────────────────────────────
// Problem  : 2571. Minimum Operations to Reduce an Integer to 0
// Difficulty: Medium
// Tags     : Dynamic Programming, Greedy, Bit Manipulation
// Link     : https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41912000 (beats 73%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
       public int minOperations(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 3) == 3) {
                n++;
                res++;
            } else {
                res += n & 1;
                n >>= 1;
            }
        }
        return res;
    }
}