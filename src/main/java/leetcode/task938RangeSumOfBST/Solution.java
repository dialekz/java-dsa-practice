package leetcode.task938RangeSumOfBST;

/**
 * Given the root node of a binary search tree and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range [low, high].
 */
class Solution {

  public int rangeSumBST(TreeNode root, int low, int high) {
    return rangeSumBST(root, low, high, 0);
  }

  private int rangeSumBST(TreeNode root, int low, int high, int result) {
    if (root == null) {
      return result;
    }

    if (root.val > low) {
      result = rangeSumBST(root.left, low, high, result);
    }
    if (root.val < high) {
      result = rangeSumBST(root.right, low, high, result);
    }
    if (root.val >= low && root.val <= high) {
      result += root.val;
    }
    return result;
  }
}
