package leetcode.task004MedianOfTwoSortedArrays;

public class Solution {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.findMedianSortedArrays(new int[]{3, 4, 5, 6, 7, 8}, new int[]{1, 2}));  // 4.5
    System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4, 5, 6, 7, 8}));  // 4.5
    System.out.println(solution.findMedianSortedArrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{7, 8}));  // 4.5
    System.out.println(solution.findMedianSortedArrays(new int[]{7, 8}, new int[]{1, 2, 3, 4, 5, 6}));  // 4.5
    System.out.println();
    System.out.println(solution.findMedianSortedArrays(new int[]{1, 2, 3, 5, 6}, new int[]{4}));  // 3.5
    System.out.println(solution.findMedianSortedArrays(new int[]{4}, new int[]{1, 2, 3, 5, 6}));  // 3.5
    System.out.println();
    System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));  // 2.5
    System.out.println(solution.findMedianSortedArrays(new int[]{3, 4}, new int[]{1, 2}));  // 2.5
    System.out.println();
    System.out.println(solution.findMedianSortedArrays(new int[]{2, 3, 4}, new int[]{1}));  // 2.5
    System.out.println(solution.findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4}));  // 2.5
    System.out.println();
    System.out.println(solution.findMedianSortedArrays(new int[]{1}, new int[]{-1}));        // 0.0
    System.out.println(solution.findMedianSortedArrays(new int[]{1}, new int[]{-2}));        // -0.5
    System.out.println(solution.findMedianSortedArrays(new int[]{-2}, new int[]{1}));        // -0.5
    System.out.println();
    System.out.println(solution.findMedianSortedArrays(new int[]{3}, new int[]{-1, -2}));   // -2.0
    System.out.println(solution.findMedianSortedArrays(new int[]{-1, -2}, new int[]{3}));   // -2.0
    System.out.println(solution.findMedianSortedArrays(new int[]{-3}, new int[]{-1, -2}));  // -1.0
    System.out.println(solution.findMedianSortedArrays(new int[]{-1, -2}, new int[]{-3}));  // -1.0
    System.out.println();
    System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));     // 2.0
    System.out.println(solution.findMedianSortedArrays(new int[]{2}, new int[]{1, 3}));     // 2.0
    System.out.println(solution.findMedianSortedArrays(new int[]{4}, new int[]{1, 2, 3}));  // 2.5
    System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));  // 2.5
    System.out.println();
    System.out.println(solution.findMedianSortedArrays(new int[]{1}, new int[]{1}));        // 1.0
    System.out.println(solution.findMedianSortedArrays(new int[]{1}, new int[]{2}));        // 1.5
    System.out.println(solution.findMedianSortedArrays(new int[]{2}, new int[]{1}));        // 1.5
    System.out.println(solution.findMedianSortedArrays(new int[]{1}, new int[]{3}));        // 2.0
    System.out.println(solution.findMedianSortedArrays(new int[]{3}, new int[]{1}));        // 2.0
    System.out.println();
    System.out.println(solution.findMedianSortedArrays(new int[]{1, 4}, new int[]{2}));     // 2.0
    System.out.println(solution.findMedianSortedArrays(new int[]{1, 9}, new int[]{2, 3}));  // 2.5
    System.out.println(solution.findMedianSortedArrays(new int[]{1, 9}, new int[]{2, 4}));  // 3.0
    System.out.println();
    System.out.println(solution.findMedianSortedArrays(new int[]{1}, new int[]{}));         // 1.0
    System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{1}));         // 1.0
    System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{}));      // 2.0
    System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{1, 3}));      // 2.0
    System.out.println();
    System.out.println(solution
        .findMedianSortedArrays(new int[]{2, 3, 5, 8}, new int[]{10, 12, 14, 16, 18, 20}));  // 11.0
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length == 0) {
      return getMedianForSortedArray(nums2);
    }

    if (nums2.length == 0) {
      return getMedianForSortedArray(nums1);
    }

    int median1 = 0;
    int median2;
    int prevMedian = -1;

    while (true) {
      median1 = (median1 + nums1.length) / 2;
      median2 = (nums1.length + nums2.length + 1) / 2 - median1;

      if (median1 == -1) {
        median1++;
        median2--;
      }

      if (median2 == -1) {
        median2++;
        median1--;
      }

      if (prevMedian == median1 && median1 != 0) {
        median1--;
        median2++;
      }

      if ((median1 == 0 || median2 >= nums2.length || nums1[median1 - 1] <= nums2[median2])
          && (median2 == 0 || median1 >= nums1.length || nums2[median2 - 1] <= nums1[median1])) {

        if ((nums1.length + nums2.length) % 2 == 1) {
          if (median1 == 0) {
            return nums2[median2 - 1];
          } else if (median2 == 0) {
            return nums1[median1 - 1];
          }
          return Math.max(nums1[median1 - 1], nums2[median2 - 1]);
        } else {
          int left, right;
          if (median1 == 0) {
            left = nums2[median2 - 1];
            right = (median2 == nums2.length) ? nums1[median1] : Math.min(nums1[median1], nums2[median2]);
          } else if (median2 == nums2.length) {
            left = Math.max(nums1[median1 - 1], nums2[median2 - 1]);
            right = nums1[median1];
          } else {
            left = (median2 == 0) ? nums1[median1 - 1] : Math.max(nums1[median1 - 1], nums2[median2 - 1]);
            right = (median1 == nums1.length) ? nums2[median2] : Math.min(nums1[median1], nums2[median2]);
          }
          return (left + right) / 2.0;
        }
      }

      prevMedian = median1;
      if (median1 != 0 && median2 < nums2.length && nums1[median1 - 1] > nums2[median2]) {
        median1--;
      } else if (median2 != 0 && median1 < nums1.length && nums2[median2 - 1] > nums1[median1]) {
        median1++;
      }
    }
  }

  private double getMedianForSortedArray(int[] arr) {
    return arr.length % 2 == 1 ? arr[arr.length / 2] : (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2.0;
  }
}
