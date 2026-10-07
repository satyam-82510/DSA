class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0, rsum=0, maxSum=0;
        for(int i=0;i<=k-1;i++){//Note: equality of k
            lsum= lsum+cardPoints[i];
            maxSum=lsum;
        }
        int rindex=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            lsum=lsum-cardPoints[i];
            rsum=rsum+cardPoints[rindex];//Note : not cardPoints[i_]-> wrong
            rindex--;
            maxSum=Math.max(maxSum,lsum+rsum);
        }
    return maxSum;
    }
}