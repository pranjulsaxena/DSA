public class Tower_of_Hanoi {
    static void Solve(char source, char helper, char destination, int n) {
        if (n == 1) {
            System.out.println(n + " moves from " + source + "to " + destination);
            return;
        }
        Solve(source, destination, helper, n - 1);
        System.out.println(n + " moves from " + source + "to " + destination);
        Solve(helper, source, destination, n - 1);
        return;

    }

    public static void main(String[] args) {
        Solve('A', 'B', 'C', 3);
    }
}
