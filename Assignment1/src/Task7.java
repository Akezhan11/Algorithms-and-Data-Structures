import java.util.Scanner;

public class Task7 {
    static void Task7(int[][] arr,int top,int bottom,int left,int right,int num){
        if(top>bottom || left>right) return;

        for(int i = left;i<=right;i++){
            arr[top][i] = num++;
        }
        for(int j = top+1;j<=bottom;j++){
            arr[j][right] = num++;
        }
        if(top<bottom){
            for(int i = right-1;i>=left;i--){
                arr[bottom][i] = num++;
            }
        }
        if(left<right){
            for(int j = bottom-1;j>top;j--){
                arr[j][left] = num++;
            }
        }
        Task7(arr,top+1,bottom-1,left+1,right-1,num);
    }
    void main(){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("n = ");
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        Task7(arr,0,n-1,0,n-1,1);
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}