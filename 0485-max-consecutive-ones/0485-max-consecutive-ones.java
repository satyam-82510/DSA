class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int onecount=0;
        int maxcount=0;//max count nhi rakhenge to last count return hota hai max abhi tak ka count nhi
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                onecount++;
               maxcount=Math.max(maxcount,onecount); 
            } else {
                onecount=0;
            }
        }
        return maxcount;
    }
}