// ──────────────────────────────────────────────────
// Problem  : 3566. Partition Array into Two Equal Product Subsets
// Difficulty: Medium
// Tags     : Array, Bit Manipulation, Recursion, Enumeration
// Link     : https://leetcode.com/problems/partition-array-into-two-equal-product-subsets/
// Runtime  : 3 ms (beats 44%)
// Memory   : 43648000 (beats 62%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    boolean solve(int[] nums, int n, long target, int i, long pro1, long pro2){
        if(i==n) return (target==pro1 && pro1==pro2);
        
       
        boolean a=solve(nums, n, target, i+1, pro1*nums[i], pro2);
       
        boolean b=solve(nums, n, target, i+1, pro1, pro2*nums[i]);

        return a|b; 
    }
    public boolean checkEqualPartitions(int[] nums, long target) {
        return solve(nums, nums.length, target, 0, 1, 1);
    }
}