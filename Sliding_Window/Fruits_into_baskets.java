package Sliding_Window;

import java.util.HashMap;

public class Fruits_into_baskets {
    // as per aditya verma format
    public static int totalFruit(int[] fruits) {
        int low=0;
        int high =0;
        int max =0;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(high<fruits.length){
            int frhigh = fruits[high];
            map.put(frhigh,map.getOrDefault(frhigh,0)+1);

            if(map.size()<2){
                max=Math.max(max,high-low+1);
                high++;
            }else if(map.size()==2){
                max=Math.max(max,high-low+1);
                high++;
            }else{
                while(low<=high&&map.size()>2){
                    int fr = fruits[low];
                    map.put(fr,map.get(fr)-1);
                    if(map.get(fr)==0){
                        map.remove(fr);
                    }
                    low++;
                }
                max=Math.max(max,high-low+1);
                high++;
            }
        }
        return max;
    }
    // logic is same as above but concise
    public static int totalFruit2(int[] fruits) {
        int low=0;
        int high =0;
        int max =0;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(high<fruits.length){
            int frhigh = fruits[high];
            map.put(frhigh,map.getOrDefault(frhigh,0)+1);
            while(low<=high&&map.size()>2){
                int fr = fruits[low];
                map.put(fr,map.get(fr)-1);
                if(map.get(fr)==0){
                    map.remove(fr);
                }
                low++;
            }
            max=Math.max(max,high-low+1);
            high++;

        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{0}));
    }
}
