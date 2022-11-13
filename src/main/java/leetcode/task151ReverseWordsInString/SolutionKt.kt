package leetcode.task151ReverseWordsInString

class SolutionKt {
  fun reverseWords(source: String): String =
    source.trim().split(" ")
      .filter(String::isNotBlank)
      .reversed()
      .joinToString(separator = " ")
}