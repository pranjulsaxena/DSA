package Binary_Search;

public class Koko_eating_bananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int start, end, mid, res;
//        if(piles.length==1){
//            return (int)Math.ceil((double)piles[0]/h);
//        }
//        start = min(piles);
        start = 1; // minimum speed of eating bananas can be 1
        end = max(piles);
        res =0;
        while(start<=end){
            mid = start + (end-start)/2;
            if (isValid(piles, mid, h)) {
                res = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }
    public static boolean isValid(int[]piles,int speed,int h){
        long hours = 0; // hours completed
        for (int pile : piles) {
//            hours += (int) Math.ceil((double) pile / speed);
            hours += (pile + speed - 1) / speed;  // it is fast approach than above method.
            if (hours > h) {
                return false;
            }
        }
        return true;
    }
    public static int min(int[] piles){
        int min = Integer.MAX_VALUE;
        for(int i =0; i<piles.length;i++){
            if(piles[i]<=min){
                min = piles[i];
            }
        }
        return min;
    }
    public static int max(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i =0; i<piles.length;i++){
            if(piles[i]>=max){
                max = piles[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{312884470},312884469));

    }
}
