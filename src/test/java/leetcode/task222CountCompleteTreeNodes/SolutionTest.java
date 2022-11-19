package leetcode.task222CountCompleteTreeNodes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  private final Solution solution = new Solution();

  @Test
  void countNodesEmptyTree() {
    assertEquals(0, solution.countNodes(null));
  }

  @Test
  void countNodesRootOnly() {
    assertEquals(1, solution.countNodes(new TreeNode(1)));
  }

  @Test
  void countNodes12() {
    TreeNode root = new TreeNode(1, new TreeNode(2), null);
    assertEquals(2, solution.countNodes(root));
  }

  @Test
  void countNodes123() {
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    assertEquals(3, solution.countNodes(root));
  }

  @Test
  void countNodes1234() {
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    root.left.left = new TreeNode(4);
    assertEquals(4, solution.countNodes(root));
  }

  @Test
  void countNodes12345() {
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    assertEquals(5, solution.countNodes(root));
  }

  @Test
  void countNodes123456() {
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    assertEquals(6, solution.countNodes(root));
  }

  @Test
  void countNodes12345678() {
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    root.left.left.left = new TreeNode(8);
    assertEquals(8, solution.countNodes(root));
  }
}