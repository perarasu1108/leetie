// ──────────────────────────────────────────────────
// Problem  : 55. Jump Game
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Greedy
// Link     : https://leetcode.com/problems/jump-game/
// Runtime  : 2 ms (beats 93%)
// Memory   : 47220000 (beats 92%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for(int i = nums.length - 1; i>= 0; i--){
            if( i + nums[i] >= goal ){
                goal = i;
            }
        }
        return goal == 0;
    }
}