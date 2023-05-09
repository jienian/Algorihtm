//双指针
public class Solution {
    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        int spaceCount = 0;
        
        // 计算空格的数量
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }
        
        // 计算替换空格后的新长度
        int newLength = length + 2 * spaceCount;
        int newIndex = newLength - 1;
        
        // 从原字符串末尾开始遍历并替换空格
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                // 替换空格为"%20"
                chars[newIndex--] = '0';
                chars[newIndex--] = '2';
                chars[newIndex--] = '%';
            } else {
                // 复制非空格字符到新长度的位置
                chars[newIndex--] = chars[i];
            }
        }
        
        // 构建新的字符串并返回结果
        return new String(chars, 0, newLength);
    }
}

