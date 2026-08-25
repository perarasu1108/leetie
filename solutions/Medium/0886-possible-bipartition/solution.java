// ──────────────────────────────────────────────────
// Problem  : 886. Possible Bipartition
// Difficulty: Medium
// Tags     : Depth-First Search, Breadth-First Search, Union-Find, Graph Theory, Graph Coloring, Bipartite Graph
// Link     : https://leetcode.com/problems/possible-bipartition/
// Runtime  : 14 ms (beats 74%)
// Memory   : 52864000 (beats 85%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] color = new int[n+1];
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] temp: dislikes){
            int from = temp[0];
            int to = temp[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        for(int i=1; i<=n; i++){
            color[i] = -1;
        }
        for(int i=1; i<=n; i++){
            if(color[i] == -1){
                if(dfsPartition(i, dislikes, color, adj, 1) == false) return false;
            }
        }
        return true;
    }
    private boolean dfsPartition(int node, int[][] dislikes, int[] color, List<List<Integer>> adj, int col){
        color[node] = col;
        for(int it: adj.get(node)){
            if(color[it] == -1){
                if(dfsPartition(it, dislikes, color, adj, 1-color[node]) == false) return false;
            }
            else if(color[it] == color[node]) return false;
        }
        return true;
    }
}