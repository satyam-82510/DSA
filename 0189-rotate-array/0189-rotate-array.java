//TC=O(2N) IN REVERSING AFTER SOLVE
//SC=O(1)
class Solution {
    public void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; 
        //if we first reverse the  part wise(k step) then whole array
        // reverse(nums, 0, n-k-1);
        // reverse(nums, n-k, n-1);
        // reverse(nums, 0, n-1);


        //if we first reverse the whole array then part wise (from k steps)
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        


    }
}