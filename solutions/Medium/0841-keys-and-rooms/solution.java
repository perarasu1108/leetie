// ──────────────────────────────────────────────────
// Problem  : 841. Keys and Rooms
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Graph Theory
// Link     : https://leetcode.com/problems/keys-and-rooms/
// Runtime  : 1 ms (beats 83%)
// Memory   : 46148000 (beats 81%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n= rooms.size();
        boolean[] vis = new boolean[n];

        dfs(0, rooms,vis);
        for(int i=0; i<n; i++){
            if(!vis[i]) return false;
        }
        return true;
    }
    private static void dfs(int node, List<List<Integer>> rooms, boolean[] vis ){
        vis[node] = true;
        for(Integer it: rooms.get(node)){
            if(!vis[it]){
                dfs(it, rooms, vis);
            }
        }
    }
}