class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        int longest =1;
        Set<Integer> st = new HashSet<>();

        for (int i=0;i<=n-1;i++)
        {
          //st.put(nums[i]); remember set not have put(in map) it has add operation
            st.add(nums[i]);

        }
        
        for (int it: st){
            //if (!st.contain(it-1)){ - WRONG SPELLING OF CONTAINS 
            if (!st.contains(it-1)){         
            int cnt = 1;
            int x = it;
              
            while (st.contains(x+1)){
                x=x+1;
                cnt += 1;
            }
         // longest= Max.VAL(longest,cnt); - WRONG
            longest= Math.max(longest,cnt);
            }
        }
    return longest;

    }
}