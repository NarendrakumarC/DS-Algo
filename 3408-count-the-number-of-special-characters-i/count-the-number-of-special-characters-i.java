class Solution {
    public int numberOfSpecialChars(String word) {
        int count=0;
        Set<Character> hs = new HashSet<>();
        for(Character ch : word.toCharArray()){
            hs.add(ch);
        }
        for(char ch = 'a'; ch <='z'; ch++){
            if(hs.contains(ch) && hs.contains((char) (ch - 'a' +'A') ))
            count++;
        }
        return count;
    }
}