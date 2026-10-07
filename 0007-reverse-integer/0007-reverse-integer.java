class Solution {
    public int reverse(int x) {
        int rev=0;
        while(x!=0){
            int digit= x%10;
            // if(rev>(int) 1e9 /10 || rev<(int) -1e9/10){//FIRST STEP//good practice take Integer.MAX_VALUE =(int)1e9
            if(rev>Integer.MAX_VALUE/10 || rev<Integer.MIN_VALUE/10){ 
                return 0;
            }
            rev=(rev*10)+digit;//SECOND STEP
            x=x/10;//THIRD STEP
        }
        return rev;
    }
}