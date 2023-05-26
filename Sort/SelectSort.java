public class Main{
    public static void selectionSort(int[] arr){
    if(arr == null || arr.length < 2) return;
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] > arr[minIndex] ? j : minIndex;
            }
            swap(arr, i , minIndex);
        }
    } 

    publix static void swap(int[] arr, int i , int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }

    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }
}
//注释版本：
import java.util.Arrays;
public class SelectionSort {
 
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // 在剩余的未排序部分中找到最小的元素的索引
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            // 将最小元素与当前位置交换
            swap(arr, i, minIndex);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
 
    // 测试方法：使用Arrays.sort进行比较
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
 
    // 测试方法：生成随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
 
    // 测试方法：复制数组
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
 
    // 测试方法：比较两个数组是否相等
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
 
    // 测试方法：打印数组
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
 
    // 主方法
    public static void main(String[] args) {
        int testTime = 500000; // 测试次数
        int maxSize = 100; // 数组最大长度
        int maxValue = 100; // 数组元素的最大值
        boolean succeed = true;
        // 开始进行测试
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selectionSort(arr1); // 使用选择排序算法进行排序
            comparator(arr2); // 使用Arrays.sort进行排序
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!"); // 打印测试结果
 
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }
}


public class SelectionSort {
 
    // 选择排序算法
    public static void selectionSort(int[] arr) {
        // 如果数组为空或只有一个元素，则无需排序
        if (arr == null || arr.length < 2) {
            return;
        }
        
        // 遍历数组，每次找到未排序部分的最小元素并交换到正确的位置
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;  // 当前未排序部分的最小元素索引
            
            // 在剩余的未排序部分中找到最小的元素的索引
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            
            // 将最小元素与当前位置交换
            swap(arr, i, minIndex);
        }
    }
    
    // 交换数组中两个元素的位置
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
