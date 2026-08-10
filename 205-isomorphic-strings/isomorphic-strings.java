class Solution {
    public boolean isIsomorphic(String s, String t) {
         // Since the input can consist of any valid ASCII character (256 possibilities)
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            // If their previous seen positions do not match, they are not isomorphic
            if (mapS[charS] != mapT[charT]) {
                return false;
            }
            
            // Update the last seen position (using i + 1 because default array value is 0)
            mapS[charS] = i + 1;
            mapT[charT] = i + 1;
        }
        
        return true;
    }
}