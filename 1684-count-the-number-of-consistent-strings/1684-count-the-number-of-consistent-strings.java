class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int counter=0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<allowed.length();i++){
            set.add(allowed.charAt(i));
        }
        for(String str : words){
            boolean flag = true;
            for(int i=0; i<str.length(); i++){
                if (!set.contains(str.charAt(i))){
                    flag = false;
                }
            }
            if(flag==true) counter++; // or if(flag) counter++;
        }
        return counter;
    }
}