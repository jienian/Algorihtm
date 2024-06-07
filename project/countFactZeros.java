// 16.5 阶乘尾数。设计一个算法，算出 n 阶乘有多少个尾随零。
public int countFactZeros(int num) {
    if (num < 0) return -1;
    int count = 0;
    for (int i = 5; num / i >= 1; i *= 5) {
        count += num / i;
    }
    return count;
}