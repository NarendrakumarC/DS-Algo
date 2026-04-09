class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        for(String st:strs){
            char []ch = st.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            hm.putIfAbsent(key,new ArrayList<>());
            hm.get(key).add(st);
        }
        return new ArrayList<>(hm.values());
    }
}