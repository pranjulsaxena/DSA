package Sliding_Window;

import java.util.HashMap;

public class Minimum_window_substring {
    public static String minWindow(String s, String t) {
        int low = 0;
        int high = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = map.size();
        String str = "";
        while (high < s.length()) {
            Character h = s.charAt(high);
            if (map.containsKey(h)) {
                map.put(h, map.get(h) - 1);
                if (map.get(h) == 0) {
                    count--;
                }
            }
             while  (count == 0) {
                Character l = s.charAt(low);
                while (low < high && !map.containsKey(l)) {
                    low++;
                    l = s.charAt(low);
                }

                   while (low < high && map.containsKey(l)&&map.get(l) < 0) {
                       map.put(l, map.get(l) + 1);
                       low++;
                       l = s.charAt(low);
                   }

                if (str.isEmpty() || (high - low + 1) < str.length()) {
                    str = s.substring(low, high + 1);
                }
               if(map.containsKey(l)){
                   map.put(l, map.get(l) + 1);
                   if (map.get(l) > 0) {
                       count++;
                   }
               }
                low++;

            }
            high++;
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ACAB","AB"));
    }
}
