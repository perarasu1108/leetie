// ──────────────────────────────────────────────────
// Problem  : 1. Two Sum
// Difficulty: Easy
// Tags     : Array, Hash Table
// Link     : https://leetcode.com/problems/two-sum/
// Runtime  : 2 ms (beats 99%)
// Memory   : 47416000 (beats 11%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr={-1,-1};
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                arr[0]=map.get(target-nums[i]);
                arr[1]=i;
                return arr;
            }
            map.put(nums[i],i);
        }
       return arr;
    }
    
}