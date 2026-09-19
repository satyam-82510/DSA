// METHOD 1( BRUTE FORCE 1)
// why slow : string gone in string pool mai baar baar new cstring add as concetination
// class Solution {
//     public String reverseWords(String s) {
//        String arr[]= s.split(" ");
//        String res = "";
//     /*  String res = " ";
//     Output : "  blue is sky the"
//     Expected : "blue is sky the" */
//        for(int i = arr.length-1; i>=0;i--){
//         if(arr[i].length()==0) {
//             continue;
//         }
//         if(res.length()==0){
//         res+=arr[i];
//         } else {
//             res +=" "+arr[i];
//         }
//        }
//     return res;
//     }
// }

// METHOD 1( OPTIMISE BRUTE FORCE ONLY THAT BECOME OPTIMAL USING STRING BUILDER )
// class Solution {
//     public String reverseWords(String s) {
// //   String arr[]= s.split(" ");
//     //    String res = "";
//     StringBuilder res = new StringBuilder();
//     for(int i = arr.length-1; i>=0;i--){
//         if(arr[i].length()==0) {
//             continue;
//         }
//         if(res.length()==0){
//         res.append(arr[i]);
//         } else {
//             res.append(" ").append(arr[i]);
//             // // also
//             //   res.append(" ");
//             //   res.append(arr[i]);
//         }
//        }
//     return res.toString();
//     }
// }


// optimal very fast 
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for(int i = words.length-1; i>=0;i--){
            result.append(words[i]);
            if(i>0){
                result.append(" ");
            }
        }

        return result.toString();
    }
}

// solution fast 

// class Solution {
//     public String reverseWords(String s) {
        
//         String[] words = s.trim().split("\\s+");
        
//         StringBuilder reversed = new StringBuilder();
        
        
//         for (int i = words.length - 1; i >= 0; i--) {
//             reversed.append(words[i]);
//             if (i > 0) {
//                 reversed.append(" ");
//             }
//         }
        
       
//         return reversed.toString();
//     }
// }

// //  fast 
// class Solution {
//     public String reverseWords(String s) {
//         String[] arr=s.trim().split("\\s+");
//         int i=0,j=arr.length-1;
//         while(i<j){
//             String temp=arr[i];
//             arr[i]=arr[j];
//             arr[j]=temp;
//             i++;
//             j--;
//         }
//         return String.join(" ",arr);
//     }
// }
        //Optimal

//         int n=s.length();
//         int i=n-1;//start from the end the string

//         StringBuilder res=new StringBuilder();

//         while(i>=0){
//              while(i>=0 && s.charAt(i)==' '){
//             i--;
//         }
//             if(i<0){
//                 break;
//             }
//             int end=i;
//             while(i>=0 && s.charAt(i)!=' '){
//                 i--;
//             }
//             if(res.length()>0){
//                 res.append(" ");
//             }
//             res.append(s.substring(i+1,end+1));
//         }

// return res.toString();

        //Brute force
        // int n = s.length();
        // List<String> list = new ArrayList<>();
        // int i = 0;

        // while (i < n) {

        //     // 1. Skip spaces
        //     while (i < n && s.charAt(i) == ' ') {
        //         i++;
        //     }

        //     // 2. Build one word
        //     String word = "";
        //     while (i < n && s.charAt(i) != ' ') {
        //         word += s.charAt(i);
        //         i++;
        //     }

        //     // 3. Add only complete word
        //     if (!word.isEmpty()) {
        //         list.add(word);
        //     }
        // }

        // // 4. Reverse list
        // Collections.reverse(list);

        // // 5. Join with single spaces
        // StringBuilder res = new StringBuilder();
        // for (i = 0; i < list.size(); i++) {
        //     res.append(list.get(i));
        //     if (i < list.size() - 1) {
        //         res.append(" ");
        //     }
        // }

        // return res.toString();
    // }
// }

// class Solution {
//     public String reverseWords(String s) {

//         String[] word= s.split("\\s+");

//         String ans="";

//         for(int i = word.length-1; i >=0 ; i--){
//             ans+=word[i];
//             ans+= " ";
//         }
//         return ans.trim();
        
//     }
// }

// // // method 2 : optimal approach 
// check what error in this with below corrected one
// class Solution {
//     public String reverseWords(String s) {

//     StringBuilder res = new StringBuilder();
//     int startIndex= s.length()-1;
//     while(startIndex >= 0){
//         //  while(startIndex >= 0 && s.charAt(startIndex)=="*"){
//       while(startIndex >= 0 && s.charAt(startIndex)==' '){
//         startIndex--;
//       }
//       if (startIndex<0){
//         break;
//       }
//       int endIndex = startIndex;
//       while(startIndex >= 0 && s.charAt(startIndex)!=' '){
//       startIndex--;
//       if(res.length()==0){
//       res.append(s.substring(startIndex+1, endIndex+1));
//         } else {
//             res.append(" ").append(s.substring(startIndex+1, endIndex+1));
//        }
//       }
//     }
//     return res.toString();
//     }
//  }

// class Solution {
//     public String reverseWords(String s) {
//         StringBuilder res = new StringBuilder();
//         int startIndex = s.length() - 1;

//         while (startIndex >= 0) {
//             // Skip spaces
//             while (startIndex >= 0 && s.charAt(startIndex) == ' ') {
//                 startIndex--;
//             }

//             // Exit if no more words are left
//             if (startIndex < 0) {
//                 break;
//             }

//             int endIndex = startIndex;

//             // Find the start of the current word
//             while (startIndex >= 0 && s.charAt(startIndex) != ' ') {
//                 startIndex--;
//             }

//             // Append the extracted word
//             if (res.length() == 0) {
//                 res.append(s.substring(startIndex + 1, endIndex + 1));
//             } else {
//                 res.append(" ").append(s.substring(startIndex + 1, endIndex + 1));
//             }
//         }

//         return res.toString();
//     }
// }


        /* Case-by-Case Breakdown with Examples
       ​Case 1: Standard string with single spaces between words
       ​Input: "the sky is blue"
       ​s.split(" ") result: ["the", "sky", "is", "blue"]
​With Line 6: "blue is sky the"
​Without Line 6: "blue is sky the"
​Result: Output is identical because there are no empty string elements in arr.
​Case 2: String with multiple spaces between words
​Input: "the  sky" (2 spaces between "the" and "sky")
​s.split(" ") result: ["the", "", "sky"]
​With Line 6 (Used):
​i = 2: arr[2] is "sky". Length > 0 \rightarrow res becomes "sky".  
​i = 1: arr[1] is "". Length == 0 \rightarrow Line 90 skips it.  
​i = 0: arr[0] is "the". Length > 0 \rightarrow res becomes "sky the".  
​Final Output: "sky the" (Correct)
​Without Line 6 (Not Used):
​i = 2: arr[2] is "sky" \rightarrow res becomes "sky".
​i = 1: arr[1] is "" \rightarrow res becomes "sky " (applies space + empty string).
​i = 0: arr[0] is "the" \rightarrow res becomes "sky  the" (extra spaces preserved).
​Final Output: "sky  the" (Incorrect — extra spaces remain)
​Case 3: String with leading or trailing spaces
​Input: "  hello world  "
​s.split(" ") result: ["", "", "hello", "world"]
​With Line 6 (Used):
​Skips all empty strings "" at indices 0 and 1.  
​Final Output: "world hello" (Correct)
​Without Line 6 (Not Used):
​Processes "" as valid words, attaching spaces to them.
​Final Output: " world hello  " (Incorrect — extra leading/trailing spaces) */