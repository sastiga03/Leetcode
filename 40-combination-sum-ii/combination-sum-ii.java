class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>ans=new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>(),ans);
        return ans;
    }
    public void backtrack(int[]candidates,int target,int start,List<Integer>res,List<List<Integer>>ans){
        if(target==0){
            ans.add(new ArrayList<>(res));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            res.add(candidates[i]);
            backtrack(candidates,target-candidates[i],i+1,res,ans);
            res.remove(res.size()-1);

        }
    }
}