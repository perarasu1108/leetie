// ──────────────────────────────────────────────────
// Problem  : 486. Predict the Winner
// Difficulty: Medium
// Tags     : Array, Math, Dynamic Programming, Recursion, Minimax, Game Theory, Zero-Sum Game
// Link     : https://leetcode.com/problems/predict-the-winner/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42804000 (beats 36%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length,sum=0;
        int[][]arr=new int[n][n];
        for(int val:nums)sum+=val;
        return helper(nums,arr,0,n-1)>=0;
    }
    public int helper(int[]arr,int[][]dp,int start,int end){
        if(start==end)return arr[start];
        if(dp[start][end]!=0)return dp[start][end];
        int takeStart=arr[start]-helper(arr,dp,start+1,end);
        int takeEnd=arr[end]-helper(arr,dp,start,end-1);
        return dp[start][end]=Math.max(takeStart,takeEnd);
    }
}