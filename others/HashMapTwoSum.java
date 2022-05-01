import java.util.*;

class HashMapTwoSum {
    public int[] twoSum(int[] nums, int target) {

        int[] resultIndices = new int[2];

        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(nums[i]);

            if (list == null) {
                list = new ArrayList<Integer>();
                list.add(i);
                map.put(nums[i], list);
            } else {
                list.add(i);
                map.put(nums[i], list);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            Integer expectedNumber = target - nums[i];

            List<Integer> expectedNumberIndices = map.get(expectedNumber);

            if (expectedNumberIndices != null) {
                for (Integer index : expectedNumberIndices) {
                    if (index != i) {
                        resultIndices[0] = i;
                        resultIndices[1] = index;
                        break;
                    }
                }
            }
        }

        return resultIndices;

    }

    public static void main(String[] args) {
        HashMapTwoSum ob = new HashMapTwoSum();

        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        int[] resultIndices = ob.twoSum(nums, target);

        for (Integer i : resultIndices) {
            System.out.print(i + " ");
        }
    }
}

/*
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * 
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * 
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
