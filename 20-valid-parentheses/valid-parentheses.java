class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch =='{'){
                    st.push(ch);
            }else if(ch == ')' || ch == ']' || ch =='}'){
                    if(st.size() == 0) return false;
                    char open = st.peek();
                    if(!isOpposite(open,ch)){
                        return false;
                    }
                    st.pop();
            }
        }
        return st.size() == 0 ? true : false;
    }
    private boolean isOpposite(char open, char close){
        if((open =='(' && close ==')' ) || (open=='[' && close ==']') || (open =='{' && close == '}')){
            return true;
        }
        return false;
    }
}