class Solution {
    public int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=num1;i<=num2;i++){
            String s=String.valueOf(i);
            for(int j=1;j<s.length()-1;j++){
                int l=s.charAt(j-1);
                int mid=s.charAt(j);
                int r=s.charAt(j+1);
                if((mid>l && mid>r)||(mid<l && mid<r)){
                    count++;
                }
            }
        }
        return count;
    }
}