//Heap
//Given an integer array and an integer K, return the K most frequent elements.
// Your algorithm should be better than O(N log N),
// utilizing a Hash Map for frequency counting
// and a Min-Heap to keep track of the top K elements.
import java.util.*;

public class Task7 {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> freqMap.get(a) - freqMap.get(b)
        );
        for (int num : freqMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequent(nums1, 2)));
        int[] nums2 = {4, 4, 4, 6, 6, 7, 7, 7, 7, 9};
        System.out.println(Arrays.toString(topKFrequent(nums2, 2)));
    }
}