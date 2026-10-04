// ──────────────────────────────────────────────────
// Problem  : 752. Open the Lock
// Difficulty: Medium
// Tags     : Array, Hash Table, String, Breadth-First Search, Bidirectional Search
// Link     : https://leetcode.com/problems/open-the-lock/
// Runtime  : 74 ms (beats 92%)
// Memory   : 48820000 (beats 58%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> st = new HashSet<>();
        for (String str : deadends) {
            st.add(str);
        }
        if (st.contains("0000")) {
            return -1;
        }
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        int level = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                String str = q.poll();
                if (str.equals(target)) {
                    return level;
                } else {
                    helper(q, st, str);
                }
            }
            level++;
        }
        return -1;
    }

    public void helper(Queue<String> q, HashSet<String> st, String str) {
        for (int i = 0; i < 4; i++) {
            char[] arr = str.toCharArray();
            char inc = (arr[i] == '9') ? '0' : (char) (arr[i] + 1);
            char dec = (arr[i] == '0') ? '9' : (char) (arr[i] - 1);

            arr[i] = inc;
            String newarr1 = new String(arr);
            arr[i] = dec;
            String newarr2 = new String(arr);
            if (!st.contains(newarr1)) {
                st.add(newarr1);
                q.add(newarr1);
            }
            if (!st.contains(newarr2)) {
                st.add(newarr2);
                q.add(newarr2);
            }
        }
    }
}