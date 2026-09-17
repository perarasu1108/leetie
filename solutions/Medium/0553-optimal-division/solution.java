// ──────────────────────────────────────────────────
// Problem  : 553. Optimal Division
// Difficulty: Medium
// Tags     : Array, Math, Dynamic Programming
// Link     : https://leetcode.com/problems/optimal-division/
// Runtime  : 3 ms (beats 89%)
// Memory   : 42884000 (beats 85%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1) return String.valueOf(nums[0]);
        if (n == 2) return nums[0] + "/" + nums[1];
        
        
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/(");
        for (int i = 1; i < n; i++) {
            sb.append(nums[i]);
            if (i != n - 1) sb.append("/");
        }
        sb.append(")");
        
        return sb.toString();
    }
}