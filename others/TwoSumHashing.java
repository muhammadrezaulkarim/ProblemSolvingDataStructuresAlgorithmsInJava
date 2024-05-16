import java.util.HashSet;
import java.util.Set;

class TwoSumHashing {
    public void pairExist(int nums[], int sum) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; ++i) {
            int complement = sum - nums[i];

            if (set.contains(complement)) {
                System.out.println("Yes! A pair exist");
                return;
            }

            set.add(nums[i]);
        }

        System.out.println("No pair exist");
    }

    public static void main(String[] args) {
        TwoSumHashing ob = new TwoSumHashing();
        int nums[] = { 1, 4, 45, 6, 10, 8 };

        int n = 16;
        // int n = 50;
        ob.pairExist(nums, n);
    }
}
/*
 * Time complexity: O(N), the entire array is needed to be traversed once.
 * Space complexity: O(N), A hash set has been used to store array elements.
 * 
 * // This solution does not deal with duplicates. For dealing with duplictate
 * pairs, please refer to problem 16.24
 * in the cracking the coding interview book
 */
