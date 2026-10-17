class Solution {
    public int search(int[] nums, int target) {
        int n= nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid= low + (high-low)/2;
            if(nums[mid]==target) return mid;

            // search in left part but not first identify the sorted part of numsay so
            if(nums[low]<=nums[mid]){//means left part is sorted
                if(nums[low]<=target && target<=nums[mid]){//check for that is lie in that sorted part or other part
                    high= mid-1;
                } else{
                    low = mid+1;
                }
            } else {//nums[mid]<=nums[high]//right part is sorted
            //de hum ek ki half se answer rahe hai ki konsi side jana hai as one if fail then another can work
            //but now again check where is lie
                if(nums[mid]<=target && target<=nums[high]){
                    low= mid+1;
                } else {
                    high=mid-1;
                }
            }

        } 
        return -1;

    }
}