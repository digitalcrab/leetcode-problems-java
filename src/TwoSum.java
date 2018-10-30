import java.util.HashMap;

/**
 * Given an array of integers, return *indices* of the two numbers such that they add up to a specific target.
 * You may assume that each input would have *exactly* one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class TwoSum {
    /**
     * Time complexity : O(n^2)
     * Space complexity : O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * One-pass Hash Table
     * Time complexity : O(n)
     * Space complexity : O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diff = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // check if we have it in the map already, if so then just take an index of it (value of map)
            if (diff.containsKey(nums[i])) {
                return new int[]{diff.get(nums[i]), i};
            }

            // calculate desired missing value and store it in the map to future use
            int desired = target - nums[i];
            diff.put(desired, i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};

        TwoSum ts = new TwoSum();

        for (int r : ts.twoSum(nums, 9)) {
            System.out.println(r);
        }
    }
}
