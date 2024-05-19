import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SlidingWindowLongestConsecutiveSequenceNoSortLeetcode128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer n : nums)
            uniqueNumbers.add(n);

        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (uniqueNumbers.contains(num - 1))
                continue; // nums[i] will be covered by the sequence starting at nums[i]-1. so we can skip
                          // it

            // We will consider the sequence starting at nums[i]
            int length = 1; // nums[i] included in the current sequence
            num += 1; // start from the next number in the sequence and check whether the consequtive
                      // numbers exists or not

            while (uniqueNumbers.contains(num)) {
                length++;
                num++;
            }

            maxLength = Math.max(maxLength, length);

        }

        return maxLength;
    }

    public static void main(String[] args) {
        SlidingWindowLongestConsecutiveSequenceNoSortLeetcode128 ob = new SlidingWindowLongestConsecutiveSequenceNoSortLeetcode128();
        // int nums[] = { 100, 4, 200, 1, 3, 2 }; // expected result 4
        // int nums[] = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }; // expected result 9
        // int nums[] = {9,1,4,7,3,-1,0,5,8,-1,6}; // expected result 7
        // int nums[] = {1, 2, 0, 1}; // expected result 3
        // int nums[] = { 0, 0 }; // expected result 1

        System.out.println(ob.longestConsecutive(nums));
    }
}

/*
 * Complexity: O(n) . With sorting, solution will be O(nlogn)
 */
