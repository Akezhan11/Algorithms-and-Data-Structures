import java.util.Arrays;

public class Merge_Sort {
    public static void mergeSort(int[] array, String indent) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        System.out.println(indent + "Division: " + Arrays.toString(array) + "  ->  "
                + Arrays.toString(left) + " and " + Arrays.toString(right));

        mergeSort(left, indent + "  ");
        mergeSort(right, indent + "  ");

        merge(array, left, right, indent);
    }
    public static void merge(int[] array, int[] left, int[] right, String indent) {
        int i = 0;
        int j = 0;
        int k = 0;

        boolean isFinalMerge = (array.length == 10);

        if (isFinalMerge) {
            System.out.println("\n");
            System.out.println("(Final Merge Step)");
            System.out.println("(L): " + Arrays.toString(left));
            System.out.println("(R): " + Arrays.toString(right));
            System.out.println("\n");
        }

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                if (isFinalMerge) {
                    System.out.println("L[" + i + "]=" + left[i] + " vs R[" + j + "]=" + right[j] +
                            " -> " + left[i] + " less. writing into array and moving left pointer.");
                }
                array[k++] = left[i++];
            } else {
                if (isFinalMerge) {
                    System.out.println("L[" + i + "]=" + left[i] + " vs R[" + j + "]=" + right[j] +
                            " -> " + right[j] + " less. writing into array and moving right pointer.");
                }
                array[k++] = right[j++];
            }

            if (isFinalMerge) {
                System.out.println("Current array : " + Arrays.toString(Arrays.copyOfRange(array, 0, k)) + "\n");
            }
        }
        while (i < left.length) {
            if (isFinalMerge) System.out.println("Right array is empty. writing everything from left array: " + left[i]);
            array[k++] = left[i++];
        }
        while (j < right.length) {
            if (isFinalMerge) System.out.println("Left array is empty. writing everything from right array: " + right[j]);
            array[k++] = right[j++];
        }
        if (isFinalMerge) {
            System.out.println("\nFinal result : " + Arrays.toString(array));
        } else {
            System.out.println(indent + "Merging: " + Arrays.toString(left) + " + "
                    + Arrays.toString(right) + "  ->  " + Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] dataset = {54, 70, 93, 77, 94, 22, 15, 45, 40, 85};

        System.out.println("starting array: " + Arrays.toString(dataset) + "\n");
        System.out.println("Division phase");
        mergeSort(dataset, "");
    }
}