// ──────────────────────────────────────────────────
// Problem  : 210. Course Schedule II
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Graph Theory, Topological Sort
// Link     : https://leetcode.com/problems/course-schedule-ii/
// Runtime  : 12 ms (beats 6%)
// Memory   : 48312000 (beats 7%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
            indegree.put(i, 0);
        }

        for (int[] i : prerequisites) {
            indegree.put(i[0], indegree.get(i[0]) + 1);
            graph.get(i[1]).add(i[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet())
            if (entry.getValue() == 0)
                q.offer(entry.getKey());

        int[] ans = new int[numCourses];
        int i = 0;

        while (!q.isEmpty()) {
            ans[i] = q.poll();

            for (Integer j : graph.get(ans[i])) {
                indegree.put(j, indegree.get(j) - 1);
                if (indegree.get(j) == 0)
                    q.add(j);
            }
            i++;
        }

        if (i != numCourses)
            return new int[0];

        return ans;
    }
}