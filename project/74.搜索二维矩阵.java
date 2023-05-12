class Solution{
    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        while(low <= high){
            int mid = (high - low) / 2 * low; 
            int x = matrix[mid / n][ mid % n];
            if(x < target){
                low = mid + 1;

            }else if(x > target){
                high = mid - 1; 
            }else{
                return true;
            }

        }
        return false;
    }
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // 矩阵的行数
        int n = matrix[0].length; // 矩阵的列数

        int low = 0; // 二分查找的起始位置
        int high = m * n - 1; // 二分查找的结束位置

        while (low <= high) {
            int mid = (high - low) / 2 + low; // 计算中间元素的索引
            int x = matrix[mid / n][mid % n]; // 获取中间元素的值

            if (x < target) {
                low = mid + 1; // 目标值在右半部分，更新起始位置
            } else if (x > target) {
                high = mid - 1; // 目标值在左半部分，更新结束位置
            } else {
                return true; // 找到目标值
            }
        }
        return false; // 没有找到目标值
    }
}
