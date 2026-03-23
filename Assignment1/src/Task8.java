import java.util.Scanner;

public class Task8 {
    static void Task8(int[] arr, int pos, int n, int k){
        if(pos == n){
            for(int i = 0;i<n;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1;i<=k;i++){
                arr[pos] = i;
                Task8(arr, pos+1, n,k);
        }
    }
    void main(){
        int n, k;
        Scanner sc = new Scanner(System.in);
        System.out.println("n = ");
        n = sc.nextInt();
        System.out.println("k = ");
        k = sc.nextInt();
        int[] arr = new int[n];
        Task8(arr, 0, n,k);
    }
}
