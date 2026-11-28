class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int count=0;
        int sum=0;
        double avg=Double.NEGATIVE_INFINITY;
        while (j < nums.length) {
            count++;
            sum+=nums[j];
            if(count==k){
                avg=Math.max(avg,(double)sum/k);
                count--;
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return avg;
    }
}