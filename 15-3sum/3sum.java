class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arr=new ArrayList<>();
        Arrays.sort(nums);
        int left=0;
        int right=0;
        for(int i=0;i<nums.length;i++){
            left=i+1;
            right=nums.length-1;
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    arr.add(list);
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right+1]){
                        right--;
                    }
                }
                else if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }
                else{
                    right--;
                }
                
            }
        }
        return arr;
    }
}