// ──────────────────────────────────────────────────
// Problem  : 62. Unique Paths
// Difficulty: Medium
// Tags     : Math, Dynamic Programming, Combinatorics
// Link     : https://leetcode.com/problems/unique-paths/
// Runtime  : 0 ms (beats 0%)
// Memory   : 41920000 (beats 0%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    static int f(int[][] dp,int i,int j){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=f(dp,i,j-1)+f(dp,i-1,j);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        return f(dp,m-1,n-1);
    }
}