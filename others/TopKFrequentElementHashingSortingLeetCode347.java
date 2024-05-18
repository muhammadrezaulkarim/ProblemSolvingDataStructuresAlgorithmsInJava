
import java.util.*;

public class TopKFrequentElementHashingSortingLeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (Integer n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        List<NumWithFrequency> list = new ArrayList<NumWithFrequency>();

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            list.add(new NumWithFrequency(entry.getKey(), entry.getValue()));
        }

        Comparator<NumWithFrequency> cmp = (ob1, ob2) -> ob1.frequency.compareTo(ob2.frequency);

        Collections.sort(list, cmp.reversed());

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).number;
        }

        return result;

    }

    public static void main(String[] args) {
        TopKFrequentElementHashingSortingLeetCode347 ob = new TopKFrequentElementHashingSortingLeetCode347();
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

/* Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]

Your algorithm's time complexity must be better than O(n log n), where n is the array's size. */
