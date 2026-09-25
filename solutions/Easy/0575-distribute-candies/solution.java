// ──────────────────────────────────────────────────
// Problem  : 575. Distribute Candies
// Difficulty: Easy
// Tags     : Array, Hash Table
// Link     : https://leetcode.com/problems/distribute-candies/
// Runtime  : 29 ms (beats 95%)
// Memory   : 48416000 (beats 68%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int distributeCandies(int[] candyType) 
    {
     int n = candyType.length;
     int mini = Integer.MIN_VALUE;
     HashSet<Integer> set = new HashSet<>();
     for(int num : candyType)
     {
        set.add(num);
     }  
     int uniqueType = set.size();

     mini = Math.min(uniqueType, n/2);

    return mini; 
    }
}