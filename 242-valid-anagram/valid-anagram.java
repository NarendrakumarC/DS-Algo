class Solution {
    public boolean isAnagram(String s, String t) {
        Map<String, List<String>> hm = new HashMap<>();
        boolean flag = false;
        char []src = s.toCharArray();
        char []tar = t.toCharArray();
        Arrays.sort(src);
        Arrays.sort(tar);
        String s1 =new String(src);
        String s2 = new String(tar);
        if(s1.equals(s2)){
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }
}