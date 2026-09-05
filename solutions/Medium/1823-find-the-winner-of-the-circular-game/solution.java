// ──────────────────────────────────────────────────
// Problem  : 1823. Find the Winner of the Circular Game
// Difficulty: Medium
// Tags     : Array, Math, Recursion, Queue, Simulation
// Link     : https://leetcode.com/problems/find-the-winner-of-the-circular-game/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42284000 (beats 70%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findTheWinner(int n, int k) {
        int winner=0;
        for (int i = 1; i <= n; i++) {
            winner = (winner + k) % i;
        }
        return winner + 1;
    }
}