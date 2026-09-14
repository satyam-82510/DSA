// TC = O(N)
// SC = O(1)
class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        //think from Backward(right-to-left) traversal, inverse leetcode 12, adjacent comparison- think from last element and Compare new comming element that what happen or what new sign come when one lesser come to left means it come with negative sign or say subtracted from final result or come gretor in left while compare from right one then it added
        int result= map.get(s.charAt(s.length()-1));
        for(int i=s.length()-2; i>=0;i--){
        if (map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
            result= result - map.get(s.charAt(i));
        } else {
            result= result + map.get(s.charAt(i));
        }
        }
    return result;
    }
}