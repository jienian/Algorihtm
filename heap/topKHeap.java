package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class topKHeap {


/* 基于堆查找数组中最大的 k 个元素 */
public static Queue<Integer> topKHeap(int[] nums, int k) {
    // 初始化小顶堆
    Queue<Integer> heap = new PriorityQueue<Integer>();
    // 将数组的前 k 个元素入堆
    for (int i = 0; i < k; i++) {
        heap.offer(nums[i]);
    }
    // 从第 k+1 个元素开始，保持堆的长度为k
    for (int i = k; i < nums.length; i++) {
        // 若当前元素大于堆顶元素，堆顶元素出堆，当前元素入堆
        if (nums[i] > heap.peek()) {
            heap.poll();
            heap.offer(nums[i]);
        }
    }
    return heap;
 }
}
