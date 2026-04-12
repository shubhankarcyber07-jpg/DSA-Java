//Two_Sum_L1
import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // if complement already exists, return indices
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // otherwise, store current number
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}