class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        Stack<Integer> st=new Stack<>();
for(int i = 2*n-1; i >= 0; i--) {

    int index = i % n;

    while(!st.isEmpty() && st.peek() <= nums[index]) {
        st.pop();
    }

    if(i < n) {
        if(!st.isEmpty())
            ans[index] = st.peek();
        else
            ans[index] = -1;
    }

    st.push(nums[index]);
}
        return ans;
    }
}


// class Solution {
//     // Finds next greater values with a monotonic stack.
//     public int[] nextGreaterElements(int[] nums) {
//         int n = nums.length;
//         int[] answer = new int[n];
//         Arrays.fill(answer, -1);
//         Deque<Integer> candidates = new ArrayDeque<>();
 
//         // Two reverse passes simulate circular order.
//         for (int i = 2 * n - 1; i >= 0; i--) {
//             int index = i % n;
 
//             // Blocked values cannot be strictly greater.
//             while (!candidates.isEmpty() &&
//                    candidates.peek() <= nums[index]) {
//                 candidates.pop();
//             }
 
//             // Only the real pass writes final answers.
//             if (i < n && !candidates.isEmpty()) {
//                 answer[index] = candidates.peek();
//             }
 
//             candidates.push(nums[index]);
//         }
 
//         return answer;
//     }
// }