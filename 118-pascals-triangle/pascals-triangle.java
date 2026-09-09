class Solution {
    public List<List<Integer>> generate(int numRows) {
    List<List<Integer>>res=new ArrayList<>();
      int[][]dp=new int[numRows][numRows];
      for(int i=0;i<numRows;i++){
        dp[i][0]=1;
        dp[i][i]=1;
        for(int j=1;j<i;j++){
            dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
        }
        List<Integer>list=new ArrayList<>();
        for(int k=0;k<=i;k++){
            list.add(dp[i][k]);
        }
        res.add(list);
      } 
      return res;  
    }

}