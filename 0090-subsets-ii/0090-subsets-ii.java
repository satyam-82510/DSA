// class Solution {
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         List<Integer> subset = new ArrayList<>();
//         Arrays.sort(nums);
//         backtrack(0, nums, subset, res);
//         return res;        
//     }

//     private void backtrack(int i, int[] nums, List<Integer> subset, List<List<Integer>> res) {
//         if (i == nums.length) {
//             res.add(new ArrayList<>(subset));
//             return;
//         }

//         subset.add(nums[i]);
//         backtrack(i + 1, nums, subset, res);
//         subset.remove(subset.size() - 1);

//         while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
//             i++;
//         }

//         backtrack(i + 1, nums, subset, res);
//     }    
// }

// m2
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        subset(nums, nums.length, 0, new ArrayList(), result);
        return result;

    }

    public void subset(int[] nums, int n , int ind, List<Integer> arr, List<List<Integer>> result){

            result.add(new ArrayList<>(arr));
  

        for(int i=ind; i<n; i++){
            if(i > ind && nums[i] == nums[i-1]){
                continue;
            }
            arr.add(nums[i]);
            subset(nums, n, i+1, arr, result);
            arr.remove(arr.size()-1);
        }
    }
}

// // brute force
// class Solution {
//     void generate(int[] nums,int idx,List<Integer> curr,Set<List<Integer>> result){
//         if(idx==nums.length){
//             result.add(new ArrayList<>(curr));
//             return;
//         }
        
//         curr.add(nums[idx]);
//         generate(nums,idx+1,curr,result);
        
//         curr.remove(curr.size()-1);
//         generate(nums,idx+1,curr,result);
//     }
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         List<Integer> curr=new ArrayList<>();
//         Set<List<Integer>> result = new HashSet<>();
//         Arrays.sort(nums);
//         generate(nums,0,curr,result);
//         return new ArrayList<>(result);
//     }
// }