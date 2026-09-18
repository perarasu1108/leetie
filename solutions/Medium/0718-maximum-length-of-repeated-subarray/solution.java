// ──────────────────────────────────────────────────
// Problem  : 718. Maximum Length of Repeated Subarray
// Difficulty: Medium
// Tags     : Array, Binary Search, Dynamic Programming, Sliding Window, Rolling Hash, Hash Function
// Link     : https://leetcode.com/problems/maximum-length-of-repeated-subarray/
// Runtime  : 83 ms (beats 22%)
// Memory   : 66552000 (beats 17%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    int f(int[][] dp,int i,int j,int[] nums1,int[] nums2){
        if(i==0 || j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(nums1[i-1]==nums2[j-1]){
           return dp[i][j]=1+f(dp,i-1,j-1,nums1,nums2);
        }
return dp[i][j]=0;
    }
    public int findLength(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[][] dp=new int[n+1][m+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                ans=Math.max(ans,f(dp,i,j,nums1,nums2));
            }
        }
        return ans;
    }
}