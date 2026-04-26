public class Linear_Search {
    public static void main(String[] args) {
        int[] dataset = {54, 70, 93, 77, 94, 22, 15, 45, 40, 85};
        int target = 15;
        int comparisons = 0;

        System.out.println("Starting Linear Search for Target: " + target);

        for (int i = 0; i < dataset.length; i++) {
            comparisons++;

            System.out.println("Comparison " + comparisons + ": checking index [" + i + "] (value " + dataset[i] + ")");

            if (dataset[i] == target) {
                System.out.println("\nSUCCESS! Target " + target + " found at index [" + i + "].");
                System.out.println("Total comparisons made: " + comparisons);
                System.out.println("Average-case time complexity: O(N)");
                return;
            }
        }

        System.out.println("\nTarget not found.");
    }
}