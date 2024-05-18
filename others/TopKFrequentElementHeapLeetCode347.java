import java.util.*;

public class TopKFrequentElementHeapLeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (Integer n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        Comparator<NumWithFrequency> cmp = (ob1, ob2) -> ob1.frequency.compareTo(ob2.frequency);

        PriorityQueue<NumWithFrequency> pq = new PriorityQueue<>(cmp.reversed());

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new NumWithFrequency(entry.getKey(), entry.getValue()));
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().number;
        }

        return result;

    }

    public static void main(String[] args) {
        TopKFrequentElementHeapLeetCode347 ob = new TopKFrequentElementHeapLeetCode347();
        int nums[] = { 1, 1, 1, 2, 2, 3 };
        int k = 2;

        ob.topKFrequent(nums, k);

    }

}

class NumWithFrequency {
    Integer number;
    Integer frequency;

    public NumWithFrequency(Integer number, Integer frequency) {
        this.number = number;
        this.frequency = frequency;
    }
}

/* Time complexity for the above code would be O(NlogN). */

/*
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 */
