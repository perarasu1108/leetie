// ──────────────────────────────────────────────────
// Problem  : 201. Bitwise AND of Numbers Range
// Difficulty: Medium
// Tags     : Bit Manipulation
// Link     : https://leetcode.com/problems/bitwise-and-of-numbers-range/
// Runtime  : 3 ms (beats 100%)
// Memory   : 45596000 (beats 95%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int cnt = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            cnt++;
        }
        return (left << cnt);
    }
}
