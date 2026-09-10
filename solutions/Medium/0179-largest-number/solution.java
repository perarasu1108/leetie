// ──────────────────────────────────────────────────
// Problem  : 179. Largest Number
// Difficulty: Medium
// Tags     : Array, String, Greedy, Sorting
// Link     : https://leetcode.com/problems/largest-number/
// Runtime  : 6 ms (beats 94%)
// Memory   : 45096000 (beats 45%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];

       
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

       
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        
        if (arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        return sb.toString();
    }
}