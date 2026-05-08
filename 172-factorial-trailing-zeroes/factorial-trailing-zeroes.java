class Solution {
    public int trailingZeroes(int n) {
        int zeroCount =0;
        for(int i=5;i<=n;i=i*5){
            zeroCount += (n/i);
        }
        return zeroCount;
    }
}