class Solution {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] vec = new int[k];
            for(int i = 0; i < k;++i){
                vec[i] = arr[i];
            }
            return vec;
    }
}

