public class Divide_and_Conquer {
        static class MinMax {
            int min;
            int max;

            MinMax(int min, int max) {
                this.min = min;
                this.max = max;
            }
        }
        public static MinMax findMinMax(int[] arr, int left, int right) {
            MinMax result = new MinMax(0, 0);

            if (left == right) {
                System.out.println("Base Case (1 element): [" + arr[left] + "] -> Min: " + arr[left] + ", Max: " + arr[left]);
                result.min = arr[left];
                result.max = arr[left];
                return result;
            }
            if (right == left + 1) {
                if (arr[left] > arr[right]) {
                    result.max = arr[left];
                    result.min = arr[right];
                } else {
                    result.max = arr[right];
                    result.min = arr[left];
                }
                System.out.println("Base Case (2 elements): [" + arr[left] + ", " + arr[right] + "] -> Min: " + result.min + ", Max: " + result.max);
                return result;
            }
            int mid = (left + right) / 2;
            MinMax leftResult = findMinMax(arr, left, mid);
            MinMax rightResult = findMinMax(arr, mid + 1, right);
            result.min = Math.min(leftResult.min, rightResult.min);
            result.max = Math.max(leftResult.max, rightResult.max);

            System.out.println("Combining Sub-results: Left(Min:" + leftResult.min + ", Max:" + leftResult.max +
                    ") & Right(Min:" + rightResult.min + ", Max:" + rightResult.max +
                    ")  =>  Combined(Min:" + result.min + ", Max:" + result.max + ")");

            return result;
        }

        public static void main(String[] args) {
            int[] dataset = {54, 70, 93, 77, 94, 22, 15, 45, 40, 85};

            System.out.println("Starting Divide and Conquer Min/Max search...\n");

            MinMax finalResult = findMinMax(dataset, 0, dataset.length - 1);

            int range = finalResult.max - finalResult.min;

            System.out.println("\n FINAL RESULTS");
            System.out.println("Global Maximum: " + finalResult.max);
            System.out.println("Global Minimum: " + finalResult.min);
            System.out.println("Range (Max - Min) = " + finalResult.max + " - " + finalResult.min + " = " + range);
        }
}
