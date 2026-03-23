import java.util.Scanner;

public class Task2 {
    public static int Task2(int[] arr,int n){
        if(n<=0){
            return 0;
        }
        return arr[n - 1] + Task2(arr,n-1);
    }
    void main(){
        int[] arr = {1,2,3,4,5};
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("n = ");
        n = sc.nextInt();
        System.out.println(Task2(arr,n));
    }
}