// ──────────────────────────────────────────────────
// Problem  : 57. Insert Interval
// Difficulty: Medium
// Tags     : Array
// Link     : https://leetcode.com/problems/insert-interval/
// Runtime  : 1 ms (beats 98%)
// Memory   : 47160000 (beats 37%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> result = new ArrayList<>();
        
        
        for(int[] slot : intervals)
        {
            
            if(newInterval[1] < slot[0])
            {
                result.add(newInterval);
                newInterval = slot;
            } 
            
            else if(slot[1] < newInterval[0])
            {
                result.add(slot);
            } 
            
            else {
                newInterval[0] = Math.min(newInterval[0],slot[0]);
                newInterval[1] = Math.max(newInterval[1],slot[1]);
            }
        }
        
        result.add(newInterval);
        
        return result.toArray(new int[result.size()][]);
    }
}