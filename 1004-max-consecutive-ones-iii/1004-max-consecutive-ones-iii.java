class Solution {
    //actual we want to find longest subarray with atmost k zeroes {from complete subarray}
   // Method most optimised as  only one while loop and Tc reduce to 2N ti O(N) only AND SC=O(1)
   //IN THIS METHOD WE MAINTAIN A MAX LENGTH(WINDOW SIZE) SEEN TILL AND CAN REDUCE THE WINDOW SIZE WE CAN ALLOW THE UDATE IN LENGTH TILL THE ZEROES <=K AND TILL THE LENGTH IS NOT GREATER THAN BEFORE
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0,zeroes=0,maxLen=0;
        int n= nums.length;
        while(r<n){
            if(nums[r]==0) zeroes++;
            if(zeroes>k) {
                if(nums[l]==0) zeroes--;
                l++;
            } 
            if(zeroes<=k){
                int len= r-l+1;
                maxLen= Math.max(len,maxLen);
            }
            r++;
        }
        return maxLen;
    }
}

// BETTER APRROCH THAN BRUTEFORCE BUT LESS THAN OPTIMAL APRROACH (THE OPTIMAL ARROACH IS MODIFIED OF THIS) 
// SLIDING WINDOW AND TWO POINTER APPROACH
// TC = O(N)+O(N)-> EITHER THERE IS 2 NESTED WHILE LOOP BUT NOT O(N^2) AS SECOND WHILE ATMOST IN PEICES) SO=O(2N)THAT WE WANT TO REDUCE IN MOST OPTIMAL APPROACH AS 2 WHILE LOOP AND SC= O(1)
// IN THIS WE TRIM A WINDOW FROM LEFT TILL THE ACCEPTED ANSWER IS NOTE COME MEANS TILL<=ZEROES,-> BUT THIS MAKE AGAIN LENGTH LESS THAN MAXLENGTH SO WE ONLY UPDATE THE ANSWER TILL MATH.MAX(LEN,MAXLEN)
// public class Solution {
//     public int longestOnes(List<Integer> nums, int k) {
//         int maxlen = 0;
//         int l = 0;
//         int r = 0;
//         int zeros = 0;

//         while (r < nums.size()) {
//             if (nums.get(r) == 0) {
//                 zeros++;
//             }

//             while (zeros > k) {
//                 if (nums.get(l) == 0) {
//                     zeros--;
//                 }
//                 l++;
//             }

//             if (zeros <= k) {
//                 int len = r - l + 1;
//                 maxlen = Math.max(len, maxlen);
//             }

//             r++;
//         }

//         return maxlen;
//     }

//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         List<Integer> nums = List.of(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0);
//         int k = 2;

//         System.out.println("Maximum length: " + sol.longestOnes(nums, k));
//     }
// }

// //BRUTEFORCE TC = O(N^2) AND SC=O(1)
// class Solution {
//     public int longestOnes(List<Integer> nums, int k) {
//         int maxlen = 0;
//         int n = nums.size();

//         for (int i = 0; i < n; i++) {
//             int zeros = 0;
//             for (int j = i; j < n; j++) {
//                 if (nums.get(j) == 0) {
//                     zeros++;
//                 }

//                 if (zeros <= k) {
//                     int len = j - i + 1;
//                     maxlen = Math.max(maxlen, len);
//                 } else {
//                     break;
//                 }
//             }
//         }

//         return maxlen;
//     }
// }