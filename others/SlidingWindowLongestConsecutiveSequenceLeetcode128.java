import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SlidingWindowLongestConsecutiveSequenceLeetcode128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return 1;

        Arrays.sort(nums); // sort the numbers

        int index = 0, maxLength = 0;
        int lastValueInTheSequence = Integer.MAX_VALUE;

        Set<Integer> uniqueNumbers = new HashSet<Integer>();

        while (index < nums.length) {
            // special handing required for index 0
            if (index == 0) {
                maxLength = 1;
                lastValueInTheSequence = nums[index];
                uniqueNumbers.add(nums[index]);
            } else {
                // special handling for duplicates
                while (index < nums.length && nums[index] == nums[index - 1]) {
                    index++;
                }

                if (index == nums.length)
                    break;

                // check whether constraint satisfied
                if (nums[index] != lastValueInTheSequence + 1) {
                    uniqueNumbers.clear(); // reset unique number set
                }

                uniqueNumbers.add(nums[index]);
                lastValueInTheSequence = nums[index];
                // We could have used two pointers: start and end. 
                // Then compute the unique elements on the fly
                // to avoid extra computations, I used only one
                maxLength = Math.max(maxLength, uniqueNumbers.size());
            }

            index++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        SlidingWindowLongestConsecutiveSequenceLeetcode128 ob = new SlidingWindowLongestConsecutiveSequenceLeetcode128();
        // int nums[] = { 100, 4, 200, 1, 3, 2 }; // expected result 4
        // int nums[] = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }; // expected result 9
        // int nums[] = {9,1,4,7,3,-1,0,5,8,-1,6}; // expected result 7
        // int nums[] = {1, 2, 0, 1}; // expected result 3
        int nums[] = { 0, 0 }; // expected result 1

        System.out.println(ob.longestConsecutive(nums));
    }
}
