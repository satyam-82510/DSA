class Solution {
    private void recurPermute(int []nums,List<Integer> ds,List<List<Integer>> ans,boolean freq[]){
        if(ds.size()==nums.length){//base case
            ans.add(new ArrayList<>(ds));
            return;// return statement from this when recursion call
        }
        for(int i=0; i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                recurPermute(nums,ds, ans,freq);//recursion complete on one i multiple call till return statement then baktrack and all thing again for new i
                ds.remove(ds.size()-1);//backtrack stepin loop
                freq[i]=false;//backtrack
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      List<Integer> ds= new ArrayList<>();
      boolean freq[]= new boolean[nums.length];
      recurPermute(nums,ds,ans,freq);
      return ans;
    }
}