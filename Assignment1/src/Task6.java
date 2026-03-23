import java.util.Scanner;

public class Task6 {
    public static void printReverse(Scanner sc, int n) {
        if (n == 0) {
            return;
        }
        String s = sc.nextLine();
        printReverse(sc, n - 1);
        System.out.println(s);
    }
    void main() {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        printReverse(sc, n);
    }
}
