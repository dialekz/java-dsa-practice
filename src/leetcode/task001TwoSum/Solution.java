package leetcode.task001TwoSum;

import java.util.Arrays;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] sorted = sortArr(nums);
        int left = 0;
        int right = sorted.length - 1;
        for (; left < right; left++) {
            int search = target - sorted[left];
            for (; (sorted[right] >= search) && (left < right); right--) {
                if (search == sorted[right]) {
                    left = getIndex(nums, sorted[left], 0, nums.length);
                    right = getIndex(nums, sorted[right], nums.length - 1, -1);
                    return new int[]{left, right};
                }
            }
        }
        return null;
    }

    private int[] sortArr(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        return sorted;
    }

    private int getIndex(int[] nums, int element, int from, int to) {
        for (int i = from; i != to; i = (from > to) ? i - 1 : i + 1) {
            if (nums[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7}, 9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 3, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 3, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{9, 3, 3, 2}, 6)));
    }
}
