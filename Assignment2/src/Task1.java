import java.util.Scanner;
//Array List
//Find the majority element in an array of size N. The majority element
// is the element that appears more than ⌊N/2⌋ times.
// Assume that the array is non-empty and the majority element always exists.

public class Task1 {
    static int Task1(int[] arr){
        int count = 0;
        Integer candidate = null;
        for(int num:arr){
            if(count==0) candidate=num;
            count += (num == candidate) ? 1:-1;
        }
        return candidate;
    }
    void main(){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        n = sc.nextInt();
        int [] arr =  new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Task1(arr));
    }
}
