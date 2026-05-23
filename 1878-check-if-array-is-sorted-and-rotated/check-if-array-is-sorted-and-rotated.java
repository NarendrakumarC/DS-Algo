class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
       
    for (int x = 0; x < n; x++) {
            int[] B = nums.clone(); // avoid modifying original
            rotateK(B, n, x);
            boolean sorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (B[i] > B[i + 1]) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) return true;
        }
        return false;
    }
    private int[] rotateK(int[] arr, int N, int K){
        K=K%N;
        arr = reverseInRange(arr, 0, N-1);
        arr = reverseInRange(arr, 0, K-1);
        arr = reverseInRange(arr, K, N-1);
        return arr;
    }
    private int[] reverseInRange(int arr[], int L, int R){
        int i=L; int j=R;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }
}