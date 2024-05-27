//点名 O(logn), O(1)
class Solution {
    public int takeAttendance(int[] records) {
        int i = 0, j = records.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(records[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}