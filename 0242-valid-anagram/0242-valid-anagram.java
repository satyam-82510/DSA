class Solution {
    public boolean isAnagram(String s, String t) {
   //by HashMap
   if( s.length() != t.length()){
       return false;
          }
        // HashMap<String,Integer> map= new HashMap<>();
        HashMap<Character,Integer> map= new HashMap<>();
        for(int i=0;i<s.length(); i++){
          map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        
        for(int j=0; j<t.length(); j++){
            char ch = t.charAt(j);
            if( map.get(ch)!=null){
                if (map.get(ch) ==1){
                 map.remove(ch);
                }else {
                map.put(ch, map.get(ch)-1);
                }
            } else {
            return false;
            }
        }
        // if (map.isEmpty()){
        //     return true ;
        // } else {
        //     return false;
        // }
        return map.isEmpty();
    }
}