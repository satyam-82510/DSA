class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
            }
            // List<Integer> list = new ArraysList<>(); -> Wrong
            // List<Integer> list = new ArrayLists<>();-> Wrong
            List<Integer> list = new ArrayList<>();
            // for(int key : keySet() ){-> Wrong
            for(int key : map.keySet() ){
               int count=map.get(key);
               if(count>n/3){
                list.add(key);
               }

            }
    return list;
    }
}