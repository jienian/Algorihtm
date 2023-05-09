public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] temp = new int[200];
        
        // 统计每个字符的出现次数
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - ' ']++;
        }
        
        int flag = 1;
        
        // 遍历统计数组，检查是否存在超过一个奇数次出现的字符
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] % 2 != 0) {
                if (flag != 1) {
                    // 如果已经存在超过一个奇数次出现的字符，则返回 false
                    return false;
                }
                flag++;
            }
        }
        
        // 如果没有超过一个奇数次出现的字符，则返回 true
        return true;
    }
}
