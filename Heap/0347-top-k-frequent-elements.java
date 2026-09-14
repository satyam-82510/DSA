class Solution {
    // By Min Heap
    // class__static Pair implements c_omparable_(Pair){
    static class Pair implements Comparable<Pair>{
        int element;
        int freq;

        Pair(int element, int freq){
        this.element= element;
        this.freq= freq;
        }
        @Override
        // class Pair CompareTo(Pair that)
        public int compareTo(Pair that){
        return this.freq-that.freq;//(Min HEAP)/ascending order: smallest freq stay at root
        // return that.freq-this.freq;//(MAX HEAP)descending order: largest freq stay at root
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
     // for(int key: keySet()){
        for(int key: map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        // }
        if (pq.size()>k){
            pq.remove();
        }
        }
        // This is also correct
        // int ans[] = new int[k];
        // int idx=0;
        // while(!pq.isEmpty()){
        //     ans[idx] = pq.remove().element;
        //     idx++;
        // }
        int ans[] = new int[k];
        int idx= k-1;

        while(!pq.isEmpty()){
            ans[idx--] = pq.remove().element;        
        }
        return ans;
    }
}


// // By Max Heap
//   static class Pair implements Comparable<Pair>{
//         int element;
//         int freq;

//         Pair(int element, int freq){
//         this.element= element;
//         this.freq= freq;
//         }
//         @Override
//         // class Pair CompareTo(Pair that)
//         public int compareTo(Pair that){
//         // return this.freq-that.freq;//(Min HEAP)/ascending order: smallest freq stay at root
//         return that.freq-this.freq;//(MAX HEAP)descending order: largest freq stay at root
//         }
//     }
//     public int[] topKFrequent(int[] nums, int k) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int num : nums){
//             map.put(num, map.getOrDefault(num,0)+1);
//         }
//         // PriorityQueue<Integer> pq = new PriorityQueue<>();
//         PriorityQueue<Pair> pq = new PriorityQueue<>();
//      // for(int key: keySet()){
//         for(int key: map.keySet()){
//             pq.add(new Pair(key,map.get(key)));
//         }
//         // if (pq.size()>k){
//         //     pq.remove();
//         // }
//         // }
//         // This is also correct
//         // int ans[] = new int[k];
//         // int idx=0;
//         // while(!pq.isEmpty()){
//         //     ans[idx] = pq.remove().element;
//         //     idx++;
//         // }
//         int ans[] = new int[k];
//         int idx=0;

//         while(idx<k && !pq.isEmpty()){
//             // Also correct
//             // ans[idx] = pq.remove().element; 
//             // idx++;  
//             ans[idx++] = pq.remove().element;           
//         }
//         return ans;
//     }
// }
