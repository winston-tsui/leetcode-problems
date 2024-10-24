/*
 * Leetcode 3: Longest Substring Without Repeating Characters. Java. Medium.
 * Tricky problem. O(n) runtime and O(min(m, n)) space complexity. m is size of input character alphabet.
 * The trick is to use the sliding window technique. Use a HashSet to efficiently track repeating characters.
 * Here I used leftPtr to denote the left boundary of the substring. Calculate longest length accordingly.
 * 1/9/2024 Winston Tsui
*/

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> mySet = new HashSet<Character>();
        int longestLen = 0;
        int leftPtr = 0;

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (!mySet.contains(currChar)) {
                mySet.add(currChar);
                longestLen = Math.max(longestLen, i - leftPtr + 1);
            } else {
                while (mySet.contains(currChar)) {
                    mySet.remove(s.charAt(leftPtr));
                    leftPtr++;
                }
                mySet.add(currChar);
            }
        }
        return longestLen;
    }
}

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int longestLen = 0;
//         int l = 0;
//         HashSet<Character> charSet = new HashSet<>();

//         for (int r = 0; r < s.length(); r++){
//             while (charSet.contains(s.charAt(r))){
//                 charSet.remove(s.charAt(l));
//             }
//             charSet.add(s.charAt(r));
//             longestLen = Math.max(longestLen, r - l + 1);
//         }
//         return longestLen;
//     }
// }
