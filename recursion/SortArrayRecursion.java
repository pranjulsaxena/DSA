import java.util.ArrayList;

public class SortArrayRecursion {

    static void sort(ArrayList<Integer> a) {
        if (a.size() == 1) {
            return;
        }
        int temp = a.remove(a.size() - 1);
        sort(a);
        insert(a, temp);
    }

    static void insert(ArrayList<Integer> a, int temp) {
        if (a.size() == 0 || a.get(a.size() - 1) <= temp) {
            a.add(temp);
            return;
        }
        int val = a.remove(a.size() - 1);
        insert(a, temp);
        a.add(val);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(9);
        list.add(5);
        list.add(4);

        sort(list);

        System.out.println("Sorted List: " + list);
    }
}
