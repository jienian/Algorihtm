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
