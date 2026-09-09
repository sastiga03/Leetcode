class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] dp=new int[n];
        dp[0]=0;
        int minprice=prices[0];
        for(int i=1;i<n;i++){
            int profit=prices[i]-minprice;
            dp[i]=Math.max(dp[i-1],profit);
            minprice=Math.min(minprice,prices[i]);
        }
        return dp[n-1];
    }
};