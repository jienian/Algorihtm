class Solution {
    public int firstUniqChar(String s) {
        char[] map = new char[26];   // 用于存储每个字母出现的次数的数组
        char[] chars = s.toCharArray();   // 将字符串转换为字符数组
        for (char c : chars) {
            map[c - 'a']++;   // 对每个字符的计数加1
        }
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i] - 'a'] == 1)   // 找到第一个计数为1的字符，返回其索引位置
                return i;
        }
        return -1;   // 如果没有找到唯一的字符，返回-1
    }
}
