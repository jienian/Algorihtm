class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1; // 从 S 字符串的末尾开始遍历
        int j = T.length() - 1; // 从 T 字符串的末尾开始遍历
        int skipS = 0; // 记录 S 字符串中需要跳过的字符数
        int skipT = 0; // 记录 T 字符串中需要跳过的字符数

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++; // 遇到退格符，需要跳过一个字符
                    i--;
                } else if (skipS > 0) {
                    skipS--; // 需要跳过的字符数减一
                    i--;
                } else {
                    break; // 遇到非退格字符，结束内层循环
                }
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++; // 遇到退格符，需要跳过一个字符
                    j--;
                } else if (skipT > 0) {
                    skipT--; // 需要跳过的字符数减一
                    j--;
                } else {
                    break; // 遇到非退格字符，结束内层循环
                }
            }

            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false; // 当前字符不相等，返回 false
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false; // 一个字符串已遍历完，另一个字符串还有剩余字符，返回 false
                }
            }

            i--; // 继续比较前一个字符
            j--;
        }

        return true; // 遍历完成，所有字符都相等，返回 true
    }
}
