// Method = using a extra data structure(list) and freq map array (space complexity more)
// class Solution {
//     private void recurPermute(int []nums,List<Integer> ds,List<List<Integer>> ans,boolean freq[]){
//         if(ds.size()==nums.length){//base case
//             ans.add(new ArrayList<>(ds));
//             return;// return statement from this when recursion call
//         }
//         for(int i=0; i<nums.length;i++){
//             if(!freq[i]){
//                 freq[i]=true;
//                 ds.add(nums[i]);
//                 recurPermute(nums,ds, ans,freq);//recursion complete on one i multiple call till return statement then baktrack and all thing again for new i
//                 ds.remove(ds.size()-1);//backtrack stepin loop
//                 freq[i]=false;//backtrack
//             }
//         }
//     }
//     public List<List<Integer>> permute(int[] nums) {
//       List<List<Integer>> ans = new ArrayList<>();
//       List<Integer> ds= new ArrayList<>();
//       boolean freq[]= new boolean[nums.length];
//       recurPermute(nums,ds,ans,freq);
//       return ans;
//     }
// }

// Space Optimisation
class Solution{
    private void recurPermute(int index, int[] nums, List<List<Integer>> ans){
    if(index==nums.length){
        //copy the ds to ans 
        List<Integer> ds= new ArrayList<>();
        for(int i=0; i<nums.length;i++){
            ds.add(nums[i]);
        }
        ans.add(new ArrayList<>(ds));
        return;
    }
    for(int i=index; i<nums.length; i++){
        swap(i,index,nums);
        recurPermute(index+1,nums,ans);
        swap(i,index,nums); //Reswap it -as it karna padega(backtrack step)
    }
    }
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      recurPermute(0,nums,ans);
      return ans; 
    }
}