package leetcode.task222CountCompleteTreeNodes;

/**
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * <p>
 * According to Wikipedia, every level, except possibly the last,
 * is completely filled in a complete binary tree,
 * and all nodes in the last level are as far left as possible.
 * <p>
 * It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Design an algorithm that runs in less than O(n) time complexity.
 */
public class Solution {
  public int countNodes(TreeNode root) {
    if (root == null)
      return 0;

    Counter counter = countNodesWithH(root, new Counter(), 0);

    if (counter.h == 0)
      return counter.leafCount;
    else if (counter.h == 1)
      return 1 + counter.leafCount;

    return (int) Math.pow(2, counter.h) - 1 + counter.leafCount;
  }

  private Counter countNodesWithH(TreeNode root, Counter counter, int h) {
    if (root.left == null) {
      counter.leafCount = (h == counter.h) ? counter.leafCount + 1 : counter.leafCount;
      return counter;
    }
    counter.h = (h == counter.h) ? counter.h + 1 : counter.h;
    countNodesWithH(root.left, counter, h + 1);

    if (root.right == null) {
      counter.finish = true;
      return counter;
    }

    if (!counter.finish) {
      countNodesWithH(root.right, counter, h + 1);
    }

    return counter;
  }

  private static class Counter {
    int h = 0, leafCount = 0;
    boolean finish = false;
  }
}
