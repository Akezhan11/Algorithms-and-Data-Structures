import java.util.Arrays;

//Quick Sort
//"A high-frequency trading platform needs to sort stock prices in microseconds."
//
//Using the first element as the Pivot, demonstrate the Partitioning step (Lomuto or Hoare scheme).
// Clearly show the elements being swapped and the final position of the pivot.
public class Quick_Sort {
    public static void quick_sort(int[] arr, int left, int right){
        if(left< right){
            int pivotIndex = partition(arr,left, right);
            quick_sort(arr, left, pivotIndex - 1);
            quick_sort(arr, pivotIndex + 1, right);
        }
    }
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left + 1;
        int j = right;

        System.out.println("Starting partition. Pivot: " + pivot);

        while (i <= j) {
            while (i <= j && arr[i] <= pivot) i++;
            while (i <= j && arr[j] > pivot) j--;

            if (i < j) {
                System.out.println("Swap: changing  " + arr[i] + " with " + arr[j]);
                swap(arr, i, j);
            }
        }

        System.out.println("Final Swap: putting Pivot (" + pivot + "). Changing with " + arr[j]);
        swap(arr, left, j);
        System.out.println("Final massive of the step: " + Arrays.toString(arr) + "\n");
        System.out.println("Final position of Pivot (" + pivot + ") — index [" + j + "]\n");
        return j;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    void main(){
        int[] unique_dataset = {54, 70, 93, 77, 94, 22, 15, 45, 40, 85};
        quick_sort(unique_dataset, 0, unique_dataset.length - 1);
        System.out.println(Arrays.toString(unique_dataset));
    }
}