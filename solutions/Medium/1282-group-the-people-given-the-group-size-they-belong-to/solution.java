// ──────────────────────────────────────────────────
// Problem  : 1282. Group the People Given the Group Size They Belong To
// Difficulty: Medium
// Tags     : Array, Hash Table, Greedy
// Link     : https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
// Runtime  : 8 ms (beats 55%)
// Memory   : 46804000 (beats 93%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> temp_group = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            temp_group.putIfAbsent(size, new ArrayList<>());
            temp_group.get(size).add(i);
            
            if(temp_group.get(size).size() == size) {
                result.add(new ArrayList<>(temp_group.get(size)));
                temp_group.get(size).clear();
            }
        }
        return result;
    }
}