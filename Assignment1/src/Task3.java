import java.util.Scanner;

public class Task3 {
    public static int Task3(int n){
        if(n == 0) return 0;
        return n+ Task3(n-1);
    }
    void main(){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("n = ");
        n = sc.nextInt();
        System.out.println(Task3(n));
    }
}
