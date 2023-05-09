class Solution {
    public String compressString(String S) {
        // 如果字符串长度小于等于2，无法进行压缩，直接返回原字符串
        if (S.length() <= 2) {
            return S;
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        int count = 1;
        int i = 0;

        // 遍历字符串中的字符
        for (i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                // 如果当前字符和下一个字符相同，计数器加1
                count++;
            } else {
                // 如果当前字符和下一个字符不同，将当前字符和计数器值追加到结果字符串中
                sb.append(chars[i]);
                sb.append(count);
                count = 1; // 重置计数器为1
            }
        }

        // 处理最后一个字符和计数器值
        sb.append(chars[i]);
        sb.append(count);

        // 判断压缩后的字符串长度与原字符串长度，返回长度较短的字符串
        return S.length() <= sb.length() ? S : sb.toString();
    }
}
