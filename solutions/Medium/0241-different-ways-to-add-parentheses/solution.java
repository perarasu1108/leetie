// ──────────────────────────────────────────────────
// Problem  : 241. Different Ways to Add Parentheses
// Difficulty: Medium
// Tags     : Math, String, Dynamic Programming, Recursion, Memoization, Bracket Sequences
// Link     : https://leetcode.com/problems/different-ways-to-add-parentheses/
// Runtime  : 3 ms (beats 48%)
// Memory   : 44556000 (beats 27%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {

        public List<Integer> solve(String s) {

                List<Integer> ans = new ArrayList<>();

                        for (int i = 0; i < s.length(); i++) {

                                    char ch = s.charAt(i);

                                                if (ch == '+' || ch == '-' || ch == '*') {

                                                                List<Integer> left = solve(s.substring(0, i));
                                                                                List<Integer> right = solve(s.substring(i + 1));

                                                                                                for (int x : left) {

                                                                                                                    for (int y : right) {

                                                                                                                                            if (ch == '+') {
                                                                                                                                                                        ans.add(x + y);
                                                                                                                                                                                                } 
                                                                                                                                                                                                                        else if (ch == '-') {
                                                                                                                                                                                                                                                    ans.add(x - y);
                                                                                                                                                                                                                                                                            } 
                                                                                                                                                                                                                                                                                                    else {
                                                                                                                                                                                                                                                                                                                                ans.add(x * y);
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                                                                                                        if (ans.size() == 0) {
                                                                                                                                                                                                                                                                                                                                                                                                                                    ans.add(Integer.parseInt(s));
                                                                                                                                                                                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                                                                                                                                                                                    return ans;
                                                                                                                                                                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                                                                                                                                                            public List<Integer> diffWaysToCompute(String s) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    return solve(s);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                      }
