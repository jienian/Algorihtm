class Solution {
    /**
     * 计算时间的可能性总数
     *
     * @param time 给定的时间字符串，格式为 "HH:MM"，其中 "?" 表示可选的任意数字
     * @return 可能性总数
     */
    public int countTime(String time) {
        return f(time.substring(0, 2), 24) * f(time.substring(3), 60);
    }

    /**
     * 计算字符串可能性的个数
     *
     * @param s 给定的字符串
     * @param m 字符串中数字的范围
     * @return 可能性的个数
     */
    private int f(String s, int m) {
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            boolean a = s.charAt(0) == '?' || s.charAt(0) - '0' == i / 10;
            boolean b = s.charAt(1) == '?' || s.charAt(1) - '0' == i % 10;
            cnt += a && b ? 1 : 0;
        }
        return cnt;
    }
}
