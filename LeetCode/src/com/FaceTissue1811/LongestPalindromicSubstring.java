package com.FaceTissue1811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindromicSubstring {
    class Solution {
        /**
         * my first idea
         */
        String longestPalindrome(String s) {
            String ans = "";
            int palindromeLength = 0;
            Map<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    map.get(c).add(i);
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(c, list);
                }
            }
            for (Map.Entry<Character, List<Integer>> next : map.entrySet()) {
                List<Integer> value = next.getValue();
                for (int i = 0; i < value.size(); i++) {
                    for (int j = value.size() - 1; j > i; j--) {
                        if (checkPalindrome(s, value.get(i), value.get(j)) && value.get(j) - value.get(i) > palindromeLength) {
                            palindromeLength = value.get(j) - value.get(i);
                            ans = s.substring(value.get(i), value.get(j) + 1);
                        }
                    }
                }
            }
            if(s.equals("")) return ans;
            return palindromeLength == 0 ? s.substring(0, 1) : ans;
        }

        boolean checkPalindrome(String s, int start, int end) {
            boolean result = true;
            int mid = (start + end) / 2;
            for (int i = start; i <= mid; i++) {
                if (s.charAt(i) != s.charAt(end + start - i)) {
                    result = false;
                    break;
                }
            }
            return result;
        }

        /**
         * longest common substring between s and s'
         */
        String longestCommonSubstring(String s) {
            String reverse = "", ans = "";
            for (int i = s.length() - 1; i >= 0; i--) reverse += s.charAt(i);
            for (int i = 0; i < s.length(); i++) {
                for (int j = s.length() - 1; j > i; j--) {
                    String substring = s.substring(i, j + 1);
                    if (reverse.contains(substring) && substring.length() > ans.length()) {
                        String ar = "";
                        for (int k = substring.length() - 1; k >= 0; k--) ar += substring.charAt(k);
                        if (s.indexOf(substring) == reverse.indexOf(ar)) {
                            ans = substring;
                            break;
                        }
                    }
                }
            }
            return s.length() > 0 && ans.equals("") ? String.valueOf(s.charAt(0)) : ans;
        }

        /**
         * brute force
         */
        String bruteForce(String s) {
            String ans = "";
            if (s == null || s.length() < 1) return "";
            int length = s.length();
            for (int i = 0; i < length; i++) {
                for (int j = length - 1; j > i; j--) {
                    String substring = s.substring(i, j + 1);
                    String reverse = "";
                    for (int k = substring.length() - 1; k >= 0; k--) reverse += substring.charAt(k);
                    if (substring.equals(reverse) && substring.length() > ans.length()) {
                        ans = substring;
                        break;
                    }
                }
            }
            return ans.equals("") ? String.valueOf(s.charAt(0)) : ans;
        }

        /**
         * expand around center
         */
        String expandAroundCenter(String s) {
            if (s == null || s.length() < 1) return "";
            String ans = "";
            for (int i = 0; i < s.length(); i++) {
                int len1 = expand(s, i, i);
                int len2 = expand(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > ans.length()) ans = s.substring(i - (len - 1) / 2, i + len / 2 + 1);
            }
            return ans;
        }

        int expand(String s, int start, int end) {
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            return end - start - 1;
        }

        /**
         * Manacher's algorithm
         */
        String manacherAlgorithm(String s) {
            String t = "$#";
            for (int i = 0; i < s.length(); i++) {
                t += s.charAt(i);
                t += '#';
            }
            char[] chars = t.toCharArray();
            int[] p = new int[chars.length];
            int ansLen = 0, ansCenter = 0, id = 0, mx = 0;
            for (int i = 0; i < chars.length; i++) {
                p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
                while (i - p[i] >=0 && i + p[i] < p.length && chars[i - p[i]] == chars[i + p[i]]) p[i]++;
                if (mx < i + p[i]) {
                    mx = i + p[i];
                    id = i;
                }
                if (ansLen < p[i]) {
                    ansLen = p[i];
                    ansCenter = i;
                }
            }
            return s.substring((ansCenter - ansLen) / 2, ansLen - 1);
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring outer = new LongestPalindromicSubstring();
        Solution solution = outer.new Solution();
        System.out.println(solution.manacherAlgorithm("noon"));
    }
}
