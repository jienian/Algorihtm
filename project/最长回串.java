class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[128]; // 用来统计每个字符出现的次数，ASCII码范围为0-127
        for (char c : s.toCharArray()) {
            arr[c]++; // 统计字符出现的次数
        }
        int count = 0; // 记录出现次数为奇数的字符的个数
        for (int i : arr) {
            count += (i % 2); // 如果字符出现次数为奇数，则将count加1
        }
        // 回文串的长度等于字符串长度减去出现次数为奇数的字符个数加1（如果有的话）
        return count == 0 ? s.length() : (s.length() - count + 1);
    }
}
时间复杂度为 O(n)，其中 n 是字符串的长度。算法需要遍历字符串并统计每个字符出现的次数，然后再遍历统计数组，计算出现次数为奇数的字符个数。
空间复杂度为 O(1)，因为使用了固定大小的数组来存储字符出现的次数，不随输入规模而变化。