package leetcode.task938RangeSumOfBST;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("task938RangeSumOfBST.SolutionTest")
class SolutionTest {

  private final Solution solution = new Solution();

  @Test
  void rangeSumBST1() {
    var node3 = new TreeNode(3, new TreeNode(1), null);
    var node7 = new TreeNode(7, new TreeNode(6), null);
    var node5 = new TreeNode(5, node3, node7);
    var node15 = new TreeNode(15, new TreeNode(13), new TreeNode(18));

    var root = new TreeNode(10, node5, node15);

    assertEquals(23, solution.rangeSumBST(root, 6, 10));
  }

  @Test
  void rangeSumBST2() {
    var node5 = new TreeNode(5, new TreeNode(3), new TreeNode(7));
    var node15 = new TreeNode(15, null, new TreeNode(18));

    var root = new TreeNode(10, node5, node15);

    assertEquals(32, solution.rangeSumBST(root, 7, 15));
  }
}