// TWO VARIETY ASK IN TWO SUM   1.SAY YES OR NO     2. SAY THE INDEX OF IF YES

//1. BRUTE FORCE APPROACH 
/*
class Solution {
      public int[] twoSum(int[] nums, int target) {
          int n = nums.length;
        

        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if(nums[i] + nums[j] == target ) {
                    int ans[] = {i,j};
                return ans; 
                }
            }
        }
        
    int ans[] = {};
    return ans;
    }
}

*/



// 2. BETTER OR OPTIMAL ACCORDING TO ITS VARIETY OF TWO SUM ASK 

/*
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[]{}; // Fallback if no solution found
    }
}
*/


//3. OPTIMAL FOR FIRST VARIETY ONLY
//NOT RUN
/*
import java.util.Arrays;

class Solution { 
    public boolean twoSumExist(int[] nums, int target) { 
        Arrays.sort(nums); 
        int left = 0; 
        int right = nums.length - 1; 
        
        while (left < right) { 
            int sum = nums[left] + nums[right]; 
            
            if (sum == target) { 
                return true; 
            } else if (sum < target) { 
                left++; 
            } else { 
                right--; 
            } 
        } 
        return false; 
    } 
}
*/


//RUNNABLE CODE

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        // 1D array storing indices: {0, 1, 2, ..., n - 1}
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        // Sort the index array based on corresponding values in nums
        Arrays.sort(index, (a, b) -> Integer.compare(nums[a], nums[b]));

       // CONCEPT
        // Two-pointer search using the sorted indices
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = nums[index[left]] + nums[index[right]];

            if (sum == target) {
                return new int[] { index[left], index[right] };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {};
    }
}


