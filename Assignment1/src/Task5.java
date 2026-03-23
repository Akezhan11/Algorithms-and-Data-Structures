import java.util.Scanner;

public class Task5 {
    public static int Task5(int[] arr,int n){
        if(n==1){
            return arr[n-1];
        }
        System.out.print(arr[n-1] + " ");
        return Task5(arr,n-1);
    }
    void main(){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("n = ");
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Task5(arr,n));
    }
}
