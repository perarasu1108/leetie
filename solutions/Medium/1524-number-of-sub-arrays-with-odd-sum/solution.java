// ──────────────────────────────────────────────────
// Problem  : 1524. Number of Sub-arrays With Odd Sum
// Difficulty: Medium
// Tags     : Array, Math, Dynamic Programming, Prefix Sum
// Link     : https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
// Runtime  : 8 ms (beats 44%)
// Memory   : 81440000 (beats 73%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        long odd = 0, even = 0, ans = 0;

        for (int x : arr) {
            if (x % 2 == 1) {
                long newOdd = even + 1;
                long newEven = odd;
                odd = newOdd;
                even = newEven;
            } else {
                even = even + 1;
            }
            ans = (ans + odd) % MOD;
        }

        return (int) ans;
    }
}