class Solution {
    public void combiSum(int idx,int target,int [] candidates,List<List<Integer>> ans,List<Integer> ds){
    // if (idx==n){  (as n is not accessible here)
    if (idx==candidates.length){
        if (target==0){
        /*ans.add(ds);
        Shallow Copy in Result List (Line 6)
        Problem: On line 6, you wrote ans.add(ds);. Because ds is a reference to a single list that gets modified and emptied as backtracking continues, ans ends up storing references to the modified list. By the end of execution, ans will contain empty sublists like [[], []].*/
        ans.add(new ArrayList<>(ds));// TBR PATTERN TO STORE UPDATED LIST IN LISTOFLIST
        }
    return;
    }
      
    if(candidates[idx]<= target){
        ds.add(candidates[idx]);
        combiSum(idx,target-candidates[idx],candidates,ans,ds);//
       /* ds.remove(candidates[idx]); // IndexOutOfBoundsException error :Incorrect ds.remove() Usage (Line 13):
       ​Issue: In Java, List.remove(int index) removes by index position, not value. Passing candidates[idx] directly attempts to remove the element at that index, which causes an IndexOutOfBoundsException or removes the wrong element.
       ​Fix: Remove the last added element using its index position: ds.remove(ds.size() */
       ds.remove(ds.size()-1);// CPRRECT FORM
       }
    combiSum(idx+1,target,candidates,ans,ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //    int n = candidates.length; no use directly in anoter function
       List<List<Integer>> ans = new ArrayList<>();
       List<Integer> ds = new ArrayList<>();
       combiSum(0,target,candidates,ans,ds);
       return ans;
    }
}


// OPTIMAL BUT SLOW SOLUTION NELOW ONE
// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> res = new ArrayList<>();

//         makeCombination(candidates, target, 0, new ArrayList<>(), 0, res);
//         return res;        
//     }

//     private void makeCombination(int[] candidates, int target, int idx, List<Integer> comb, int total, List<List<Integer>> res) {
//         if (total == target) {
//             res.add(new ArrayList<>(comb));
//             return;
//         }

//         if (total > target || idx >= candidates.length) {
//             return;
//         }

//         comb.add(candidates[idx]);
//         makeCombination(candidates, target, idx, comb, total + candidates[idx], res);
//         comb.remove(comb.size() - 1);
//         makeCombination(candidates, target, idx + 1, comb, total, res);
//     }    
// }