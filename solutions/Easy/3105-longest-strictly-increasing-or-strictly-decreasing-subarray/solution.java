// ──────────────────────────────────────────────────
// Problem  : 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
// Difficulty: Easy
// Tags     : Array
// Link     : https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/
// Runtime  : 2 ms (beats 15%)
// Memory   : 43788000 (beats 91%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = 1, inc = 1, dec = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            } else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            maxLen = Math.max(maxLen, Math.max(inc, dec));
        }
        return maxLen;
    }
}