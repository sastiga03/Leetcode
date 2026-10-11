class Solution {
public:
    int sumOfSquares(vector<int>& nums) {
        int n=nums.size();
        int res=0;
        int j=1;
        for(int i=0;i<n;i++){
            if((n%j)==0){
                res+=nums[i]*nums[i];
            }
            j++;
        }
        return res;
    }
};