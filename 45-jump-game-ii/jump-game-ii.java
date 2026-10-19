class Solution {
    public int jump(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=0;
        for(int i=1;i<nums.length;i++){
            dp[i]=9999;
        }
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=i+nums[i] && j<n;j++){
                dp[j]=Math.min(dp[j],dp[i]+1);
            }
        }
        return dp[n-1];
    }
}