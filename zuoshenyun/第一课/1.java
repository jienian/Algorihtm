// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock
import java.util.Arrays;
class Main {
    public static void insertSort(int[] arr){
        if(arr == null || arr.length < 2) return;
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; i < arr.length; i++){
                swap(arr, j, j + 1);
            }
        }
    }
    //yihuo
    public static void swap(int[] arr, int i , int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }
    
    public static int[] generaRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }
    //dinyi
    public static int[] copyArray(int[] arr){
        if(arr == null){
            return null;
         }
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            res[i] = arr[i];
        }
        return res;
    }
    
    //isEqual
    public static boolean isEqual(int[] arr1, int[] arr2){
        if(arr1 == null && arr2 != null || (arr1 != null && arr2 == null)){
            return false;
        }
        if(arr1 == null && arr2 != null){
            return false;
        }
        if(arr1.length != arr2.length ){
            return false;
        }
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
       
    }
    
    //printArray
    public static void printArray(int[] arr){
        if(arr == null) return;
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
    
    //Main
     public static void main(String[] args) {
         int testTime = 50000;
         int maxSize = 100;
         int maxValue = 100;
         boolean succeed = true;
         for(int i = 0; i < testTime; i++){
             int[] arr1 = generaRandomArray(maxSize, maxValue);
             int[] arr2 = copyArray(arr1);
             insertSort(arr1);
             comparator(arr2);
             if(!isEqual(arr1, arr2)){
                 succeed = false;
                 break;
             }
         }
     System.out.println(succeed ? "Nice" : "Fucking fucked!");
         int[] arr= generaRandomArray(maxSize, maxValue);
         printArray(arr);
         insertSort(arr);
         printArray(arr);
    } 
}
 
   
 