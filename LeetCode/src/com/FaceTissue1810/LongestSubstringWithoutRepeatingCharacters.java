package com.FaceTissue1810;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "pwwkew";
        LongestSubstringWithoutRepeatingCharacters out = new LongestSubstringWithoutRepeatingCharacters();
        Solution solution = out.new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

    private class Solution {
        /**
         * my solution
         */
        private int lengthOfLongestSubstring(String s) {
            int result = 1;
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.clear();
                for (int j = i; j < s.length(); j++) {
                    set.add(s.charAt(j));
                    if (set.size() != j - i + 1) break;
                }
                result = set.size() > result ? set.size() : result;
            }
            return s.length() > 0 ? result : 0;
        }

        /**
         * sliding window
         */
        private int slidingWindow(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int i = 0, j = 0, ans = 0;
            while (i < n && j < n) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j++));
                    ans = Math.max(j - i, ans);
                }
                else {
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }

        /**
         * sliding window optimized
         */
        private int slidingWindowOptimized(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int n = s.length(), ans = 0;
            for (int i = 0, j = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) i = Math.max(map.get(s.charAt(j)), i);
                ans = Math.max(j - i + 1, ans);
                map.put(s.charAt(j), j + 1);
            }
            return ans;
        }
    }
}
