package Sliding_Window;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        int low = 0;
        int high = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();

        while (high < s.length()) {
            char currentChar = s.charAt(high);

            while (set.contains(currentChar)) {
                set.remove(s.charAt(low));
                low++;
            }

            set.add(currentChar);

            maxLen = Math.max(maxLen, high - low + 1);

            high++;
        }
        return maxLen;
    }
    public static int longestKSubstr(String s) {
        int low = 0;
        int high = 0;
        int count = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();

        while (high < s.length()) {
            Character ch = s.charAt(high);
            int window=high-low+1;
            map.put(ch, map.getOrDefault(ch, 0) + 1);
             if (map.size() == window) {
                count = Math.max(count, window);

            }
                while (low <= high && map.size() < high-low+1) {
                    Character ch_low = s.charAt(low);
                    map.put(ch_low, map.get(ch_low) - 1);
                    if (map.get(ch_low) == 0) {
                        map.remove(ch_low);
                    }
                    low++;
                }
                high++;

        }
        return count == Integer.MIN_VALUE ? -1 : count;
    }
    public static void main(String[] args) {
        System.out.println(longestKSubstr("aab"));
    }
}