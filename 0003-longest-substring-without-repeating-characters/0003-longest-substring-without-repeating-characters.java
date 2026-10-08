class Solution {
    public int lengthOfLongestSubstring(String s) {
        int hash[]= new int [256];
        Arrays.fill(hash,-1);
        int n=s.length();
        int l=0;
        int r=0;
        int maxLen=0;
        while(r<n){
            // Check if character s.charAt(r) is already in the map/hash
            if(hash[s.charAt(r)]!=-1){
                 // If character's last seen position is inside the current window [l, r]  * MOST IMPORTANT LINE T0 UNDERSTAND*
                if(hash[s.charAt(r)]>=l){ //means repeating charater anywhere in window greter than or equal to l //Note: if Seen at index before l or outside window in left Ignore that duplicate they not consider as outside the window SO NOT REPEAT IN OUR CURRENT SUBSTRING
                    l=hash[s.charAt(r)]+1;// hash[s.charAt(r)] give the last seen index

                }
            }
            int len=r-l+1;// we can intialise this random variable in loop only that is reinitialise in loop only and in use in loop only
            maxLen=Math.max(len,maxLen);
            hash[s.charAt(r)]=r; // Update the last seen index of current character
            r++;//l ko humne pehle hi update kar diya hai so only move right pointer
        }
    return maxLen;
    }
}
