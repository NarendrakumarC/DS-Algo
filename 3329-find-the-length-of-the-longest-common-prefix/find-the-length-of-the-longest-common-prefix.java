class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n= arr1.length;
        int m = arr2.length;
        Set<Integer> hs = new HashSet<Integer>();
        for(int i=0;i<n;i++){
            int num= arr1[i];
            while(num >0){
                hs.add(num);
                num /= 10;
            }
        }
        int maxlen = 0;
        for(int j=0;j<m;j++){
            int num=arr2[j];
            while(num > 0){
                if(hs.contains(num)){
                    int curlen = String.valueOf(num).length();
                    maxlen = Math.max(maxlen, curlen);
                }
                num /= 10;
            }
        }
        return maxlen;
    }
}