import java.util.Scanner;

public class Task1 {
    public int Task1(int n){
        if(n==1){
            return 1;
        }
        return Task1(n-1) + n*n;
    }
    void main(){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("n = ");
        n = sc.nextInt();
        System.out.println(Task1(n));
    }
}
