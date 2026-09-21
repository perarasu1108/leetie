// ──────────────────────────────────────────────────
// Problem  : 1372. Longest ZigZag Path in a Binary Tree
// Difficulty: Medium
// Tags     : Dynamic Programming, Tree, Depth-First Search, Binary Tree, DP on Trees
// Link     : https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
// Runtime  : 7 ms (beats 28%)
// Memory   : 57648000 (beats 60%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLength=0;
    public void solve(TreeNode root,int dir,int currLength){
        if(root==null) return;
        maxLength=Math.max(maxLength,currLength);
        if(dir==1){
            solve(root.left,0,currLength+1);
            solve(root.right,1,1);
        }
        else{
            solve(root.right,1,currLength+1);
            solve(root.left,0,1);
        }
    }

    public int longestZigZag(TreeNode root) {
        solve(root,0,0);
        solve(root,1,0);
        return maxLength;
    }
}