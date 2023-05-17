//函数用于寻找数组中需要进行排序的最短连续子数组。通过从左到右和从右到左两次遍历数组，分别查找最后一个逆序位置和第一个逆序位置。最后返回逆序位置的范围。
class Solution {
    public int[] subSort(int[] array) {
        int last = -1, first = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = array.length;
        for(int i = 0; i < len; i++){
            if(array[i] < max){
                last = i;
            }else{
                max = Math.max(max, array[i]);
            }
            if(array[len - 1 - i] > min){
                first = len - 1 - i;
            }else{
                min = Math.min(min, array[len - 1 - i]);
            }
        }
        return new int[]{first, last};
    }
}
