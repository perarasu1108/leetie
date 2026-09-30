// ──────────────────────────────────────────────────
// Problem  : 1111. Maximum Nesting Depth of Two Valid Parentheses Strings
// Difficulty: Medium
// Tags     : String, Stack, Bracket Sequences
// Link     : https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
// Runtime  : 1 ms (beats 100%)
// Memory   : 44552000 (beats 100%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] maxDepthAfterSplit(String s) {
        int n = s.length();
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++)
            res[i] = (i ^ s.charAt(i)) & 1;
            
        return res;
    }
}