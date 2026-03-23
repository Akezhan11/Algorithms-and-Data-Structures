import java.util.Scanner;

public class Task10 {
    public static boolean isPowerOf(int n){
        if( n == 1){
            return true;
        }
        if(n<=0||n%2!=0){
            return false;
        }
        return isPowerOf(n/2);
    }
    void main(){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("n = ");
        n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            if(isPowerOf(i)){
                System.out.println(i+" is a power of 2");
            }else{
                System.out.println(i+" is not a power of 2");
            }
        }
    }
}
