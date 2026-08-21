//1. BRUTE FORCE APPROACH 

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






//2. BETTER APPROCH - our mistakes 
// class Solution {
// public int[] twoSum(int[] nums, int target ) {
// // Hashmap<int, int > map = new Hashmap<int, int>
// // unordered_map <int, int> m;
// HashMap<Integer, Integer> map = new HashMap<>();
// int n = nums.length;
//     //  for (i=0; i<n; i++){
//  //  int first = nums[i];     // int second = target - first;
         
//          //if(m.find(sec)!= m.end() ) {
//    // Iterate over all elements
//         for (int i = 0; i < n; i++) {
//            // int first = nums[i];
//             //int complement = target - first;
//             // or direct write 
//             int complement = target - nums[i];
//             // Check if complement exists in map
            // if (map.containsKey(complement)) {
            //  // int ans[]= {map.get(complement), i}; 
            //    //return ans;  
            //   // Pair found
            //    return new int[] { map.get(complement), i};
              
//             }
//             // Store current element and its index
//             map.put(arr[i], i);
//         }
//         // No pair found
//      // int arr []= {};
//      // return arr;
//      return new int[] {};
//     //  return new int int [0];
//       } 
// }




// 2. BETTER OR OPTIMAL AS 

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int n = nums.length;

//         for (int i = 0; i < n; i++) {  //TC = O(N)
//             //int first = nums[i];
//             //int complement = target - first;
//             int complement = nums[i];

//             if (map.containsKey(complement)) { //TC = O(1)BEST AND AVERAGE  AND 
//             // IN WORST CASE O(N) TC FOR SEARCHING ELEMENT IN A MAP 
//                 return new int[] { map.get(complement), i };
//             }

//             map.put(nums[i], i); 
//         }

//         return new int[]{}; // Fallback if no solution found
//     }
// }  


