//1. BRUTE FORCE - (Couple loop arrproach)
/* class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
              for (int i=0;i<n;i++){
                int count= 0; 
                for (int j=0;j<n; j++){
                    if(nums[i]==nums[j]){
                     count++;
                    }
                }    
            if (count > n/2){
                return nums[i];
            }
            }
    return -1; 
    }
}
*/

//2.1: BETTER ONE (HASHING OR HASHMAP APPROACH)
/*class Solution {
    public int majorityElement(int nums[]) {
       //Hashmap <Integer,Integer> map= new Hashmap <>();
    HashMap <Integer,Integer> map= new HashMap <>();
        int n = nums.length;
        for(int i=0; i < n ;i++){
            int num = nums[i];
           // map.put(num, map.getord   efault(num,0)+1);
              map.put(num, map.getOrDefault(num,0)+1);
            if(map.get(num)>n/2){
                return num;
            }    
            
        }
    return - 1;
    }       
}
*/

//2.2: using for each loop as alternative  ;

// import java.util.HashMap; - jaruri nhi
/*
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int threshold = nums.length / 2;

        // Enhanced for-loop replaces:
        // for (int i = 0; i < n; i++) { int num = nums[i]; ... }
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);

            // Check if current element's frequency exceeds n / 2
            if (count > threshold) {
                return num;
            }
        }

        return -1;
    }
}
*/


// 3. Optimal 

class Solution {
    public int majorityElement(int[] nums) {
    int freq=0, ans = 0;
    int n = nums.length;
    for (int i=0;i<n;i++){
        if (freq==0){
            ans= nums[i];
        }
        if(ans==nums[i]){
            freq++;
        } else {
            freq--;
        }
    }
    return ans;
    }
}    
    