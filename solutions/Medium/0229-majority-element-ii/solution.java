// ──────────────────────────────────────────────────
// Problem  : 229. Majority Element II
// Difficulty: Medium
// Tags     : Array, Hash Table, Sorting, Counting, Boyer–Moore Majority Vote Algorithm
// Link     : https://leetcode.com/problems/majority-element-ii/
// Runtime  : 14 ms (beats 43%)
// Memory   : 51436000 (beats 87%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            elementCountMap.put(nums[i], elementCountMap.getOrDefault(nums[i], 0) + 1);
        }
        
        List<Integer> majorityElements = new ArrayList<>();
        int threshold = nums.length / 3;
        
        for (Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();
            
            if (count > threshold) {
                majorityElements.add(element);
            }
        }
        
        return majorityElements;
    }
}