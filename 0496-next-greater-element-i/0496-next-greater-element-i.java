//  BRUTE FORCE 
// TC = (N*M) , SC = O(1) EXCLUDING OUTPUT ARRAY
// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         int[] result = new int[nums1.length];

//         for (int i = 0; i < nums1.length; i++) {
//             int target = nums1[i];
//             int nextGreater = -1;
//             boolean found = false;

//             for (int j = 0; j < nums2.length; j++) {
//                 if (nums2[j] == target) {
//                     found = true;
//                 }
//                 if (found && nums2[j] > target) {
//                     nextGreater = nums2[j];
//                     break;
//                 }
//             }
//             result[i] = nextGreater;
//         }

//         return result;
//     }
// }
/* VERY IMPORTANT NOTES PLEASE READ WHILE REVISING : In the line nums2[j] == target, once found is set to true, no code ever sets it back to false inside that inner loop.
Because found is a boolean variable declared outside the inner for loop, its value stays true for all remaining iterations of j until the inner loop finishes or breaks.
Why It Stays true
 * No reset condition: The code only has an assignment to set found = true. There is no else { found = false; } block.
 * Variable Persistence: Once a variable is assigned a value in memory during a loop execution, it retains that value across subsequent iterations unless explicitly reassigned.
Why This Behavior Is Necessary for the Algorithm
This behavior is completely intentional for the logic to work correctly:
 * Before target is seen: found is false. Any numbers larger than target appearing to the left in nums2 are ignored because found && nums2[j] > target evaluates to false.
 * When target is seen: found becomes true.
 * After target is seen: found must stay true so that the algorithm continues checking every element to the right of the target to see if it is greater than target.
If found were reset to false on the very next index, the algorithm would completely forget that it had already located the target in nums2.
*/

// BY STACK APPROACH(MONOTONIC STACK APPROACH)
// TC = O(N+M), SC= (M) FOR THE STAck
// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         // Array to store the next greater element for every item in nums2
//         int[] nextGreaterMap = new int[10001]; // Constraint: nums2[i] <= 10000
//         Stack<Integer> stack = new Stack<>();

//         // Process nums2 from right to left using for and while loops
//         for (int i = nums2.length - 1; i >= 0; i--) {
//             int current = nums2[i];

//             // Maintain decreasing order in stack (pop smaller/equal elements)
//             while (!stack.isEmpty() && stack.peek() <= current) {
//                 stack.pop();
//             }

//             // If stack has elements, top is the next greater element; otherwise -1
//             if (stack.isEmpty()) {
//                 nextGreaterMap[current] = -1;
//             } else {
//                 nextGreaterMap[current] = stack.peek();
//             }

//             // Push current value to stack
//             stack.push(current);
//         }

//         // Build result for nums1 using the map array
//         int[] result = new int[nums1.length];
//         for (int i = 0; i < nums1.length; i++) {
//             result[i] = nextGreaterMap[nums1[i]];
//         }

//         return result;
//     }
// }

// By hashmap
// TC = O(N+M) where n nums1,length m is nums2.length, SC= (M) FOR THE STAck and hasmap
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Process nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];

            // Pop elements smaller than or equal to current element
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            // Map current element to its next greater element (or -1 if none)
            map.put(num, stack.isEmpty() ? -1 : stack.peek());

            // Push current element onto the stack
            stack.push(num);
        }

        // Map answers for nums1 using precalculated lookup
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}