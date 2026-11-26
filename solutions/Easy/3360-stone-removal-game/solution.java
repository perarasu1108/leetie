// ──────────────────────────────────────────────────
// Problem  : 3360. Stone Removal Game
// Difficulty: Easy
// Tags     : Math, Simulation
// Link     : https://leetcode.com/problems/stone-removal-game/
// Runtime  : 0 ms (beats 100%)
// Memory   : 40828000 (beats 100%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canAliceWin(int n) {
        int missing = 55 - n;  // stones short of playing all ten moves
        long unplayed = Math.round(Math.sqrt(2 * missing));  // smallest j with 1 + 2 + ... + j >= missing
        return unplayed % 2 == 1;  // 10 - unplayed moves were played: odd means Alice moved last
    }
}