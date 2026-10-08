class Solution{
// ACTUALLY MEAN WE WANT TO FIND(EXTRACKTED MEANING) -> MAX LENGTH SUBARRAY AT MOST 2 TYPES OF NUMBERS
// // WHEN K GIVEN THIS 3 APPROCH BELOW THREE ONLY ARR GIVEN NOT K (THAT IS ACTUAL)ON LEETCODE GIVEN
//In the generalized version of this problem ("Longest Subarray with at most K Distinct Elements"), k represents the maximum number of unique elements allowed in the window.
// // 1. Brute Force Approach (Nested Loops + Set)
// // Time Complexity: O(N^2) - Two nested loops iterate over all possible subarrays.
// // Space Complexity: O(1) - Set stores at most 3 elements.
// public int totalElementsBruteForce(int[] arr, int k) {//BECAUSE NAME OF FUNCTION CHANGE THATS WHY NOT RUN THESE THREE AS CLASS DRIVER NOT ACCEPT , WE CAN CHANGE PARAMETER THAT NOT AFFECT 
//     int n = arr.length;
//     int maxLen = 0;

//     for (int i = 0; i < n; i++) {
//         Set<Integer> st = new HashSet<>();
//         for (int j = i; j < n; j++) {
//             st.add(arr[j]);
//             if (st.size() <= k) {
//                 maxLen = Math.max(maxLen, j - i + 1);
//             } else {
//                 break;
//             }
//         }
//     }

//     return maxLen;
// }

// 2. Better Approach (Sliding Window with while Shrinking)
// // Time Complexity: O(N + N) = O(2N) - Outer pointer 'r' and inner pointer 'l' traverse array elements at most once each.
// // Space Complexity: O(K) - Map stores at most K + 1 unique elements.
// public int totalElementsBetter(int[] arr, int k) {
//     int n = arr.length;
//     int l = 0, r = 0;
//     int maxLen = 0;
//     Map<Integer, Integer> mpp = new HashMap<>();

//     while (r < n) {
//         mpp.put(arr[r], mpp.getOrDefault(arr[r], 0) + 1);

//         // Shrink the window until it contains at most k unique elements
//         while (mpp.size() > k) {
//             mpp.put(arr[l], mpp.get(arr[l]) - 1);
//             if (mpp.get(arr[l]) == 0) {
//                 mpp.remove(arr[l]);
//             }
//             l++;
//         }

//         if (mpp.size() <= k) {
//             maxLen = Math.max(maxLen, r - l + 1);
//         }

//         r++;
//     }

//     return maxLen;
// }

// 3. Optimal Approach (Sliding Window with Single if Shrinking)
// // Time Complexity: O(N) - Outer pointer 'r' moves N times; 'l' shifts at most once per step.
// // Space Complexity: O(K) - Map stores at most K + 1 unique elements.
// public int totalElementsOptimal(int[] arr, int k) {
//     int n = arr.length;
//     int l = 0, r = 0;
//     int maxLen = 0;
//     Map<Integer, Integer> mpp = new HashMap<>();

//     while (r < n) {
//         mpp.put(arr[r], mpp.getOrDefault(arr[r], 0) + 1);

//         // If unique elements exceed k, shrink the window only once per iteration
//         if (mpp.size() > k) {
//             mpp.put(arr[l], mpp.get(arr[l]) - 1);
//             if (mpp.get(arr[l]) == 0) {
//                 mpp.remove(arr[l]);
//             }
//             l++;
//         }

//         if (mpp.size() <= k) {
//             maxLen = Math.max(maxLen, r - l + 1);
//         }

//         r++;
//     }

//     return maxLen;
// }

//when k is not given and say k=2 in proble statement only that we have two baskets only
// 1. Brute Force Approach (Nested Loops + Set)
// // Time Complexity: O(N^2) - Two nested loops iterate over all possible subarrays.
// // Space Complexity: O(1) - Set stores at most 3 distinct fruit types.
// public int totalFruit(int[] fruits) {
//     int n = fruits.length;
//     int maxLen = 0;

//     for (int i = 0; i < n; i++) {
//         Set<Integer> st = new HashSet<>();
//         for (int j = i; j < n; j++) {
//             st.add(fruits[j]);
//             if (st.size() <= 2) {
//                 maxLen = Math.max(maxLen, j - i + 1);
//             } else {
//                 break;
//             }
//         }
//     }

//     return maxLen;
// }

// 2. Better Approach (Sliding Window with while Shrinking)
// // Time Complexity: O(N + N) = O(2N) - Pointers 'r' and 'l' move through array at most once each.
// // Space Complexity: O(1) - Map stores at most 3 fruit types.
// public int totalFruit(int[] fruits) {
//     int n = fruits.length;
//     int l = 0, r = 0;
//     int maxLen = 0;
//     Map<Integer, Integer> mpp = new HashMap<>();

//     while (r < n) {
//         mpp.put(fruits[r], mpp.getOrDefault(fruits[r], 0) + 1);

//         // Shrink the window until we have at most 2 distinct fruit types
//         while (mpp.size() > 2) {
//             mpp.put(fruits[l], mpp.get(fruits[l]) - 1);
//             if (mpp.get(fruits[l]) == 0) {
//                 mpp.remove(fruits[l]);
//             }
//             l++;
//         }

//         if (mpp.size() <= 2) {
//             maxLen = Math.max(maxLen, r - l + 1);
//         }

//         r++;
//     }

//     return maxLen;
// }

// 3. Optimal Approach (Sliding Window with Single if Shrinking)
// // Time Complexity: O(N) - Single pass through the array with 'r' pointer moving N times.
// // Space Complexity: O(1) - Map stores at most 3 fruit types.
public int totalFruit(int[] fruits) {
    int n = fruits.length;
    int l = 0, r = 0;
    int maxLen = 0;
    Map<Integer, Integer> mpp = new HashMap<>();

    while (r < n) {
        mpp.put(fruits[r], mpp.getOrDefault(fruits[r], 0) + 1);

        // Shrink the window at most once per iteration
        if (mpp.size() > 2) {
            mpp.put(fruits[l], mpp.get(fruits[l]) - 1);
            if (mpp.get(fruits[l]) == 0) {
                mpp.remove(fruits[l]);
            }
            l++;
        }

        if (mpp.size() <= 2) {
            maxLen = Math.max(maxLen, r - l + 1);
        }

        r++;
    }

    return maxLen;
}


}//class solution end bracket