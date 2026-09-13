class Solution {
    public int solve(int[] nums, boolean check) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        if (check) {
            dp[1] = nums[1];
            dp[2] = Math.max(nums[2], nums[1]);
            for (int i = 3; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            }
            ans = dp[n - 1];
        } else {
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            }
            ans = dp[n - 2];
        }
        return ans;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (n == 3) {
            return Math.max(nums[0],Math.max(nums[1], nums[2]));
        }
        return Math.max(solve(nums, true), solve(nums, false));

    }
}