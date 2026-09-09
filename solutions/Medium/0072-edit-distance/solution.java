// ──────────────────────────────────────────────────
// Problem  : 72. Edit Distance
// Difficulty: Medium
// Tags     : String, Dynamic Programming
// Link     : https://leetcode.com/problems/edit-distance/
// Runtime  : 3 ms (beats 98%)
// Memory   : 47216000 (beats 35%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    int f(int i,int j,String s1,String s2,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
         if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]= f(i-1,j-1,s1,s2,dp);
        return dp[i][j]= 1+Math.min(f(i,j-1,s1,s2,dp),Math.min(f(i-1,j,s1,s2,dp),f(i-1,j-1,s1,s2,dp)));
    }
    public int minDistance(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n][m];
        for(int [] x:dp){
            Arrays.fill(x,-1);
        }
        return f(n-1,m-1,s1,s2,dp);
    }
}