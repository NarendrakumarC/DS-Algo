class Solution {   
    public int countSubstrings(String s) {
        int count =0; 
        for(int i=0;i<s.length();i++){
            // Case 1: Odd length palindromes (center is at a character)
            count += helper(s, i, i);
            // Case 2: Even length palindromes (center is between two characters)
            count += helper(s, i, i+1);
        }
        return count;
    }
    private int helper(String st, int left, int right){
        int count =0;
        // Expand outwards as long as characters match and pointers are in bounds
        while(left >=0 && right < st.length() && st.charAt(left) == st.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}