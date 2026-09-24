// ──────────────────────────────────────────────────
// Problem  : 3550. Smallest Index With Digit Sum Equal to Index
// Difficulty: Easy
// Tags     : Array, Math
// Link     : https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/
// Runtime  : 1 ms (beats 100%)
// Memory   : 45596000 (beats 60%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int x = nums[i];
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            if (sum == i) return i;
        }
        return -1;
    }
}