package Sliding_Window;

import java.util.HashMap;

public class Longest_SubString_with_K_unique_Characters {
    public static int longestKSubstr(String s, int k) {
        int low = 0;
        int high = 0;
        int count = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();

        while (high < s.length()) {
            Character ch = s.charAt(high);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.size() < k) {
                high++;
            } else if (map.size() == k) {
                count = Math.max(count, high - low + 1);
                high++;
            } else {
                while (low <= high && map.size() > k) {
                    Character ch_low = s.charAt(low);
                        map.put(ch_low, map.get(ch_low) - 1);
                        if (map.get(ch_low) == 0) {
                            map.remove(ch_low);
                        }
                    low++;
                }
                high++;
            }
        }
        return count == Integer.MIN_VALUE ? -1 : count;
    }

    public static void main(String[] args) {
        System.out.println(longestKSubstr("aabaaab", 2));
    }
}
