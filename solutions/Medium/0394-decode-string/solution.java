// ──────────────────────────────────────────────────
// Problem  : 394. Decode String
// Difficulty: Medium
// Tags     : String, Stack, Recursion
// Link     : https://leetcode.com/problems/decode-string/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42624000 (beats 87%)
// Language : java
// Copyright: (c) 2026 perarasu1108. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
   int i = 0;
public String decodeString(String s) {
    StringBuilder sb = new StringBuilder();
    int count = 0;
    String tmp_string = "";
    
    while (i < s.length()) {
        char c = s.charAt(i);
        i++;
        
        if (c == '[') {
            tmp_string = decodeString(s); // do subproblem
            for (int j = 0; j < count; j++) {
                sb.append(tmp_string);
            }
            count = 0; // reset counter
        } else if (c == ']') { // subproblem complete
            break;
        } else if (Character.isAlphabetic(c)) {
            sb.append(c);
        } else {
            count = count * 10 + c - '0';
        }
    }
    
    return sb.toString();
}
}