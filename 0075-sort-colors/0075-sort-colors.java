class Solution {
    public void sortColors(int[] nums) {
       int n = nums.length;
    //    int low=, int mid=0, int high = n-1; -> WRONG AS COMMAS HERE MUST ; ONLY IN int = a,b;
       int low=0; int mid=0; int high = n-1;
    while(mid<=high){
       if(nums[mid]==0){
        int temp= nums[mid];
        nums[mid] = nums[low];
        nums[low]= temp;
        low++;// if yeh nhi lagaoge to infinte loop mai rahege ek hi array ke element ke liye
        mid++;

       } else if (nums[mid]==1){
       mid++;

       } else { // (nums[mid]==2)
        int temp= nums[mid];
        nums[mid]=nums[high];
        nums[high]= temp;
        high--;
       }
    }
    }
}

// Time Complexity: O(n) The array is traversed only once using the `mid` pointer. Each element is checked at most once, and swaps are done in constant time.

// Space Complexity: O(1) Only a few integer pointers (`low`, `mid`, `high`) are used. Sorting is done in-place, requiring no additional space.