class Solution {
    public List<Integer> majorityElement(int[] nums) { 
    List<Integer> result = new ArrayList<>(); 
    HashMap<Integer,Integer> map= new HashMap<>();
    int n=nums.length;
        // for(int i=0;i<n; i++){
        // map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        // }
        for(int num: nums){
               map.put(num, map.getOrDefault(num,0)+1);
        }

        for(int key: map.keySet()){
            if(map.get(key)>n/3){
                result.add(key); 
            }
        }
        return result;
    }
}