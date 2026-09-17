class Solution {
    public int maxSubArray(int[] nums) {
    long ms=Long.MIN_VALUE;
    long sum= 0;
    int n = nums.length;
    for(int i=0;i<n;i++){
    sum += nums[i];
    if (sum>ms){
        ms=sum;
    }
    if(sum<0){
        sum=0;
    }
    }
    if(ms==Integer.MIN_VALUE) return 0;
    // return ms; give error as lossy conversion as function return a need of int return answer value in int
    return (int) ms;
    }
}