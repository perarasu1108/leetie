// ──────────────────────────────────────────────────
// Problem  : 1143. Longest Common Subsequence
// Difficulty: Medium
// Tags     : String, Dynamic Programming, Longest Common Subsequence
// Link     : https://leetcode.com/problems/longest-common-subsequence/
// Runtime  : 25 ms (beats 29%)
// Memory   : 54132000 (beats 21%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n][m];
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        return f(n-1,m-1,s1,s2,dp);
    }
    int f(int i,int j,String s1,String s2,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+f(i-1,j-1,s1,s2,dp);
        }
        else{
            return dp[i][j]=Math.max(f(i,j-1,s1,s2,dp),f(i-1,j,s1,s2,dp));
        }
        
    }
}