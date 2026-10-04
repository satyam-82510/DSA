class Solution {
    public String reverseOnlyLetters(String s) {
      int left=0;
      int right=s.length()-1;
      char []ch = s.toCharArray();
      while(left<right){
        if(!Character.isLetter(ch[left])){
           left++;
        } else if (!Character.isLetter(ch[right])) {
            right--;
        } else{
            char temp = ch[left];// note: not a int as swap between same datatype either throw incompatable type error
            ch[left] = ch[right];
            ch[right] = temp;
            right--;
            left++;
        }
      }
    return new String(ch);
    }
}