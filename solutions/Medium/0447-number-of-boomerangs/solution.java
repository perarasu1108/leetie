// ──────────────────────────────────────────────────
// Problem  : 447. Number of Boomerangs
// Difficulty: Medium
// Tags     : Array, Hash Table, Math
// Link     : https://leetcode.com/problems/number-of-boomerangs/
// Runtime  : 142 ms (beats 26%)
// Memory   : 46920000 (beats 41%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        if(n<3)return 0;
        int count =0;
        for(int i=0;i<n;i++){
            HashMap<Long,Integer> hm= new HashMap<>();
            for(int j=0;j<n;j++){
                if(j==i)continue;
                int y = points[i][1]-points[j][1];
                int x = points[i][0]-points[j][0];
                long key = y*y + x*x;
                hm.put(key,hm.getOrDefault(key,0)+1);
            }
            for(Map.Entry<Long,Integer> u : hm.entrySet()){
                int k = u.getValue();
                if(k>1) count+= k*(k-1);
            }
        }
        return count;
    }
}