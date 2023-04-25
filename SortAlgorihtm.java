
public class Solution{
    //交换位置
       public static void swap(int[] arr, int i , int j){
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp; 
    }
    //选择排序
    public static void selectSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //0~n-1
        //1~n-1
        int N = arr.length;
        for(int i = 0; i < N; i++){
            //0 ~ n-1
            //i ~ n-1
            int minValueIndex = i;
            for(int j = i + 1; j < N; j++){
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr,i, minValueIndex);
            
            
        }
    }
    //冒泡排序
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //0~n-1
        //0~n-2
        //0~end
        int N = arr.length;
        for(int end = N - 1; end >= 0;end--){
            //0~end 干一堆
            //0 1 ,1 2, 2 3 ,3 4, 4 5 end-1 end
            for(int second = 1; second <= end; second++){
                if(arr[second - 1] > arr[second]){
                    swap(arr, second - 1, second);
                }   
            }
        }
    }
    //插入排序
    public static void insertSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //0～0 完成
        //0～1 让范围上有序
        //0～2
        //0～n-1
        int N = arr.length;
        for(int end = 1; end < N;end++){
            int newNumIndex = end;
            while(newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]){
                swap(arr, newNumIndex-1, newNumIndex);
                newNumIndex--;
            }
        }
    }
    //插入排序优化2
    public static void insertSort2(int[] arr ){
        if(arr == null || arr.length < 2){
            return;
        } 
        int N = arr.length;
        for(int end = 1; end < N;end++){
            //pre新数的前一个位置
            for(int pre = end - 1;pre >= 0 && arr[pre] > arr[pre + 1]; pre--){
                swap(arr, pre, pre + 1);
            } 
        }
    }
 
    
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i] + "");
        }
        System.out.println();
    }
        
    public static void main(String[] args) {
       int[] arr = {0,1,20, 1, 3, 5, 11, 10};
        printArray(arr);
        //selectSort(arr);
        //bubbleSort(arr);
        //insertSort(arr);
        insertSort2(arr);
        printArray(arr);
    }
}   



