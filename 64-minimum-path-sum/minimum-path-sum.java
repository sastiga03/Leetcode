class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][]dp=new int[n][m];
        dp[0][0]=grid[0][0];
        for(int i=1;i<m;i++){
            dp[0][i]=grid[0][i]+dp[0][i-1];  
        }
        for(int k=1;k<n;k++){
            dp[k][0]=grid[k][0]+dp[k-1][0];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}