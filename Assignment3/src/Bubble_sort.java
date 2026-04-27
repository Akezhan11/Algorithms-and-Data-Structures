import java.util.Arrays;
import java.util.Scanner;

public class Bubble_sort{
    public static int[] Bubble_sort(int[] arr , String asc){
        boolean isAsc = asc.equals("asc");
        for(int i= 0;i<arr.length;i++){
            for(int j = 0; j<arr.length-1-i;j++){
                sort(arr, j,isAsc);
            }
        }
        return arr;
    }
    public static void sort(int[] arr, int j,boolean isAsc) {
        boolean swap = false;
        if (isAsc){
            if (arr[j] > arr[j + 1]) {
                swap=true;
            }
        }
        else {
            if (arr[j] < arr[j + 1]) {
                swap = true;
            }
        }
        if (swap) {
            int curr = arr[j];
            arr[j] = arr[j+1];
            arr[j+1] = curr;
        }

    }
    void main(){
        Scanner sc = new Scanner(System.in);
        System.out.print("asc or desc: ");
        String asc =  sc.nextLine();
        System.out.print("Enter array size: ");
        int n =  sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array elements: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Bubble_sort(arr, asc);
        System.out.println(Arrays.toString(arr));
    }
}