// ──────────────────────────────────────────────────
// Problem  : 1606. Find Servers That Handled Most Number of Requests
// Difficulty: Hard
// Tags     : Array, Heap (Priority Queue), Simulation, Ordered Set
// Link     : https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/
// Runtime  : 130 ms (beats 46%)
// Memory   : 99796000 (beats 90%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; i++) free.add(i);
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        int[] cnt = new int[k];
        int n = arrival.length;
        for (int i = 0; i < n; i++) {
            long t = arrival[i];
            while (!busy.isEmpty() && busy.peek()[0] <= t) {
                free.add((int) busy.poll()[1]);
            }
            if (free.isEmpty()) continue;
            int pref = i % k;
            Integer s = free.ceiling(pref);
            if (s == null) s = free.first();
            free.remove(s);
            cnt[s]++;
            busy.offer(new long[]{t + load[i], s});
        }
        int mx = 0;
        for (int c : cnt) mx = Math.max(mx, c);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++)
            if (cnt[i] == mx) ans.add(i);
        return ans;
    }
}