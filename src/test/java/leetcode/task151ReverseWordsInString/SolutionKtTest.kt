package leetcode.task151ReverseWordsInString

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SolutionKtTest {

  private val solutionKt = SolutionKt()

  @Test
  fun testReverseWords() {
    assertEquals("blue is sky the", solutionKt.reverseWords("the sky is blue"))
    assertEquals("world hello", solutionKt.reverseWords("  hello world  "))
    assertEquals("example good a", solutionKt.reverseWords("a good   example"))
  }
}