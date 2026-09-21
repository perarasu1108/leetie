// ──────────────────────────────────────────────────
// Problem  : 337. House Robber III
// Difficulty: Medium
// Tags     : Dynamic Programming, Tree, Depth-First Search, Binary Tree, DP on Trees
// Link     : https://leetcode.com/problems/house-robber-iii/
// Runtime  : 2 ms (beats 28%)
// Memory   : 46528000 (beats 59%)
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
    HashMap<TreeNode,Integer> dp=new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null) return 0;
        if(dp.containsKey(root)){
           return dp.get(root);
        }
        int robs=root.val;
        if(root.left!=null){
            robs+=rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            robs+=rob(root.right.left)+rob(root.right.right);
        }
        int not=rob(root.left)+rob(root.right);
        int ans= Math.max(robs,not);
        dp.put(root,ans);
        return ans;
    }
}