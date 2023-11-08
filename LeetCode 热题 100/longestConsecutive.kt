// 根据输入的整数数组，找出最长连续序列的长度
fun longestConsecutive(nums: IntArray): Int {
    // 使用HashSet存储整数数组中的数字，以便快速查找
    val numSet = HashSet(nums)
    var longestStreak = 0
    // 遍历numSet中的每个数字
    for (num in numSet) {
        // 如果当前数字的前一个数字不在numSet中，则存在一个连续序列
        if (!numSet.contains(num - 1)) {
            var currentNum = num
            var currentStreak = 1
            // 继续向后查找连续的数字，直到找到一个不在numSet中的数字
            while (numSet.contains(currentNum + 1)) {
                currentNum += 1
                currentStreak += 1
            }
            // 更新最长序列的长度
            longestStreak = maxOf(longestStreak, currentStreak)
        }
    }
    // 返回最长序列的长度
    return longestStreak
}