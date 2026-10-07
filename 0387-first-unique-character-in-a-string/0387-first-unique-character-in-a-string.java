// class Solution {
//     public int firstUniqChar(String s) {
//         int freq[]= new int[26];
//         char[] chars= s.toCharArray();
//         for(char c: chars){ // can we use a normal for loop below one code
//             freq[c-'a']++;
//         }
//        for(int i=0;i<chars.length;i++){ // this time we need a return index so not use a for loop this time
//             if(freq[chars[i]-'a']==1){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int firstUniqChar(String s) {
        int freq[] = new int[26];
        char[] chars = s.toCharArray();

        // Standard for loop using array index
        for (int i = 0; i < chars.length; i++) {
            freq[chars[i] - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (freq[chars[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}