class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int indexA = m - 1;
        int indexB = n - 1;
        int indexMerged = m + n - 1;

        while (indexA >= 0 && indexB >= 0) {
            if (A[indexA] > B[indexB]) {
                A[indexMerged] = A[indexA];
                indexA--;
            } else {
                A[indexMerged] = B[indexB];
                indexB--;
            }
            indexMerged--;
        }

        // 如果B数组还有剩余元素未合并
        while (indexB >= 0) {
            A[indexMerged] = B[indexB];
            indexB--;
            indexMerged--;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] B = {2, 5, 6};
        int n = 3;

        Solution solution = new Solution();
        solution.merge(A, m, B, n);

        for (int num : A) {
            System.out.print(num + " ");
        }
    }
}
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> removeElementsFromList(List<Integer> list1, List<Integer> list2, int k) {
        Set<Integer> set1 = new HashSet<>(list1.subList(0, k)); // 表示list1的K窗口的集合
        Set<Integer> set2 = new HashSet<>(list2.subList(0, k)); // 表示list2的K窗口的集合
        
        int count = 0; // 记录删除的元素数量
        
        for (int i = k; i < list2.size(); i++) {
            int num = list2.get(i);
            
            if (set1.contains(num)) {
                list2.remove(i);
                set2.remove(num);
                count++;
                i--; // 调整删除后的索引
            } else {
                set2.add(num);
            }
        }
        
        return list2;
    }
}
