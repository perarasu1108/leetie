// ──────────────────────────────────────────────────
// Problem  : 1786. Number of Restricted Paths From First to Last Node
// Difficulty: Medium
// Tags     : Dynamic Programming, Graph Theory, Topological Sort, Heap (Priority Queue), Shortest Path, Dijkstra's Algorithm
// Link     : https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/
// Runtime  : 119 ms (beats 6%)
// Memory   : 176828000 (beats 5%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    int mod = 1000000007;

    public class Pair {
        int vtx;
        long cost;

        public Pair(int vtx, long cost) {
            this.vtx = vtx;
            this.cost = cost;
        }
    }

    public int countRestrictedPaths(int n, int[][] edges) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashMap<>());
        }
        for (int[] arr : edges) {
            int a = arr[0];
            int b = arr[1];
            int cost = arr[2];
            map.get(a).put(b, cost);
            map.get(b).put(a, cost);
        }

        long[] dis = new long[n + 1];
        Arrays.fill(dis, Long.MAX_VALUE);
        dijkstra(map, dis);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(1, n, dp, map, dis);
    }

    public void dijkstra(HashMap<Integer, HashMap<Integer, Integer>> map, long[] dis) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Long.compare(o1.cost, o2.cost);
            }
        });
        int n = dis.length - 1;
        dis[n] = 0;
        pq.add(new Pair(n, 0));
        while (!pq.isEmpty()) {
            Pair rv = pq.poll();
            int vtx = rv.vtx;
            long cost = rv.cost;
            if (cost > dis[vtx]) continue;

            for (int nbrs : map.get(vtx).keySet()) {
                long c = map.get(vtx).get(nbrs) + cost;
                if (c < dis[nbrs]) {
                    dis[nbrs] = c;
                    pq.add(new Pair(nbrs, c));
                }
            }
        }
    }

    public int dfs(int node, int n, int[] dp, HashMap<Integer, HashMap<Integer, Integer>> map, long[] dis) {
        if (node == n) {
            return 1;
        }
        if (dp[node] != -1) {
            return dp[node];
        }

        long a = 0;
        for (int nbrs : map.get(node).keySet()) {

            if (dis[node] > dis[nbrs]) {
                a = (a + dfs(nbrs, n, dp, map, dis)) % mod;
            }
        }
        return dp[node] = (int) (a % mod);
    }
}