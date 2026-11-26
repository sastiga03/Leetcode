class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans=new int[nums.length];
        int j=0;
        while(j<nums.length){
            int count=0;
            for(int i=0;i<nums.length;i++){
                if(i!=j && nums[i]<nums[j]){
                    count++;
                }
            }
            ans[j]=count;
            j++;
        }
        return ans;
    }
}