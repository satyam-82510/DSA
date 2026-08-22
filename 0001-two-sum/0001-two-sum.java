// TWO VARIETY ASK IN TWO SUM   1.SAY YES OR NO     2. SAY THE INDEX OF IF YES

//1. BRUTE FORCE APPROACH [MULTI LOOP APPROACH]
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



// 2. BETTER OR OPTIMAL ACCORDING TO ITS VARIETY OF TWO SUM ASK : [HASHMAP OR HASHING APPROACH]
// It is best for second variety of question


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



//3. OPTIMAL FOR FIRST VARIETY :[TWO POINTER APPROACH] (Note: sorting is required)
/*
import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
      Arrays.sort(nums);
        int i = 0, j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];

            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[]{i, j};
            }
        }

        return new int[]{};
    }
}

*/
