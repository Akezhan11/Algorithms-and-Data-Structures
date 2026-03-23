import java.util.Scanner;

public class Task4 {
    public static int Task4(int b,int n){
        if(n == 0) return 1;
        return power(b, n) + Task4(b, n - 1);
    }
    public static int power(int b, int n) {
        if (n == 0) return 1;
        return b * power(b, n - 1);
    }
    void main(){
        Scanner sc = new Scanner(System.in);
        int b;
        System.out.println("b = ");
        b = sc.nextInt();
        int n ;
        System.out.println("n = ");
        n = sc.nextInt();
        System.out.println(Task4(b,n));
    }
}
