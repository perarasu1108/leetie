// ──────────────────────────────────────────────────
// Problem  : 264. Ugly Number II
// Difficulty: Medium
// Tags     : Hash Table, Math, Dynamic Programming, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/ugly-number-ii/
// Runtime  : 2 ms (beats 100%)
// Memory   : 43276000 (beats 74%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int nthUglyNumber(int n) {

        int[] ugly = new int[n];

        // First ugly number
        ugly[0] = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for (int i = 1; i < n; i++) {

            int next = Math.min(
                ugly[p2] * 2,
                Math.min(ugly[p3] * 3, ugly[p5] * 5)
            );

            ugly[i] = next;

            // Move every pointer that produced next
            if (next == ugly[p2] * 2) {
                p2++;
            }

            if (next == ugly[p3] * 3) {
                p3++;
            }

            if (next == ugly[p5] * 5) {
                p5++;
            }
        }

        return ugly[n - 1];
    }
}