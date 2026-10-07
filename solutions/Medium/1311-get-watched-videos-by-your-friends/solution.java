// ──────────────────────────────────────────────────
// Problem  : 1311. Get Watched Videos by Your Friends
// Difficulty: Medium
// Tags     : Array, Hash Table, Breadth-First Search, Graph Theory, Sorting
// Link     : https://leetcode.com/problems/get-watched-videos-by-your-friends/
// Runtime  : 41 ms (beats 13%)
// Memory   : 47732000 (beats 52%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<String> watchedVideosByFriends(
            List<List<String>> watchedVideos, 
            int[][] friends, 
            int id, 
            int level) {

        int n = friends.length;

        // Step 1: BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(id);
        visited[id] = true;

        int currLevel = 0;

        while (!queue.isEmpty() && currLevel < level) {
            int size = queue.size();
            currLevel++;

            for (int i = 0; i < size; i++) {
                int person = queue.poll();

                for (int f : friends[person]) {
                    if (!visited[f]) {
                        visited[f] = true;
                        queue.offer(f);
                    }
                }
            }
        }

        // Step 2: Count videos
        Map<String, Integer> freq = new HashMap<>();

        for (int person : queue) {
            for (String video : watchedVideos.get(person)) {
                freq.put(video, freq.getOrDefault(video, 0) + 1);
            }
        }

        // Step 3: Sort
        List<String> result = new ArrayList<>(freq.keySet());

        Collections.sort(result, (a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return freq.get(a) - freq.get(b); // frequency
            }
            return a.compareTo(b); // lexicographical
        });

        return result;
    }
}