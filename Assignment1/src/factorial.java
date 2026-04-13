import java.util.Scanner;

public class factorial {
    static int Factor(int n){
        if(n == 1){
            return 1;
        }
        return n*Factor(n-1);
    }
    void main(){
        Scanner sc =  new Scanner(System.in);
        System.out.println("n = ");
        int n = sc.nextInt();
        System.out.println(Factor(n));
    }
}
