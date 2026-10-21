// ──────────────────────────────────────────────────
// Problem  : 2027. Minimum Moves to Convert String
// Difficulty: Easy
// Tags     : String, Greedy
// Link     : https://leetcode.com/problems/minimum-moves-to-convert-string/
// Runtime  : 1 ms (beats 83%)
// Memory   : 42072000 (beats 100%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minimumMoves(String s) {
        int i=0;
        int step=0;
        while(i<s.length()){
            if(s.charAt(i)=='X'){
                i=i+3;
                step++;
            }
            else{
                i++;
            }
        }
        return step;
    }
}