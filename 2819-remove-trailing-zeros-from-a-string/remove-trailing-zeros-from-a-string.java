class Solution {
    public String removeTrailingZeros(String num) {
      /*while(num.endsWith("0")){
        num = num.substring(0,num.length()-1);
      }*/
      // other way via regular expressions
      num = num.replaceAll("0+$","");
      return num;
    }
}