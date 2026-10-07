class Solution {
    public String reverseVowels(String s) {
        int n=s.length();
        int l=0;
        int r=n-1;
        char [] ch= s.toCharArray();
        while(l<r){
            if(!isVowel(ch[l])){
                l++;
            }
            else if(!isVowel(ch[r])){
                r--;
            }
            else{ 
            char temp= ch[l];// Note: always remind char if swap with char not int (as we in practice of int mostly so forget)
             ch[l]= ch[r];
             ch[r]=temp;
             l++;
             r--;
            }
        }
    return String.valueOf(ch);
    }
    public static boolean isVowel(char  ch){
        if( ch=='a' ||  ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){ //note we forget doble equal (= instead of ==)
            return true;
        }
        return false;
    }
}