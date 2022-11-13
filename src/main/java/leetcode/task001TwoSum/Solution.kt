package leetcode.task001TwoSum

import java.util.*

fun twoSum(nums: IntArray, target: Int): IntArray? {
  val sorted = sort(nums)
  var left = 0
  var right = nums.size - 1

  while (left < right) {
    val search = target - sorted[left]
    while (sorted[right] >= search && left < right) {
      if (search == sorted[right]) {
        left = getIndex(nums, sorted[left], 0, nums.size)
        right = getIndex(nums, sorted[right], nums.size - 1, -1)
        return intArrayOf(left, right)
      }
      right--
    }
    left++
  }
  return null
}

val sort: (IntArray) -> IntArray = {
  val sortedArray = it.clone()
  Arrays.sort(sortedArray)
  sortedArray
}

fun getIndex(nums: IntArray, element: Int, from: Int, to: Int): Int {
  var i = from
  while (i != to) {
    if (nums[i] == element) {
      return i
    }
    i = if (from > to) i - 1 else i + 1
  }
  return -1
}

fun main() {
  println(twoSum(intArrayOf(2, 7, 11, 15), 9)?.contentEquals(intArrayOf(0, 1)))
  println(twoSum(intArrayOf(2, 7), 9)?.contentEquals(intArrayOf(0, 1)))
  println(twoSum(intArrayOf(2, 3, 7, 11, 15), 9)?.contentEquals(intArrayOf(0, 2)))
  println(twoSum(intArrayOf(2, 3, 11, 15), 9) == null)
  println(twoSum(intArrayOf(3, 3), 6)?.contentEquals(intArrayOf(0, 1)))
  println(twoSum(intArrayOf(9, 3, 3, 2), 6)?.contentEquals(intArrayOf(1, 2)))
}