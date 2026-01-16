package Sliding_Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Count_occurences_anagram {
    static List<Integer> search(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = map.size();
        int k = p.length();
        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();

        while (j < s.length()) {

            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.replace(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    count--;
                }
            }

            if (j - i + 1 < k) {
                j++;
            }
            else if (j - i + 1 == k) {
                if (count == 0) {
                    ans.add(i);
                }

                char start = s.charAt(i);
                if (map.containsKey(start)) {
                    if (map.get(start) == 0) {
                        count++;
                    }
                    map.replace(start, map.get(start) + 1);
                }

                i++;
                j++;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(search("abc","cbaebabacd"));
    }
}
