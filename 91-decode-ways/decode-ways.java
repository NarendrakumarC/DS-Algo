class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }

        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return decode(n-1, s, dp);
    }

    private int decode(int pos, String str, int[] dp){
        
        // handle negative index
        if(pos < 0) return 1;

        // correct base case
        if(pos == 0) {
            return str.charAt(0) == '0' ? 0 : 1;
        }

        if(dp[pos] != -1) {
            return dp[pos];
        }

        // Single digit
        int individual = 0;
        if(str.charAt(pos) != '0') {
            individual = decode(pos - 1, str, dp);
        }

        // Two digit
        int pair = 0;
        int num = (str.charAt(pos-1) - '0') * 10 + (str.charAt(pos) - '0');

        if(num >= 10 && num <= 26) {
            pair = decode(pos - 2, str, dp);
        }

        dp[pos] = individual + pair;
        return dp[pos];
    }
}