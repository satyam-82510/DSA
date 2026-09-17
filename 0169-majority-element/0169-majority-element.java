class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int cnt = 0;//   cnt
        for(int i : nums){
            if (i == candidate){
            cnt++;
            } else{
            cnt--;
            if(cnt==0){
                candidate=i;
                cnt=cnt+1;
            }
            }
        }
        return candidate;
    }
}