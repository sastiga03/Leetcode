class Solution {
    static void find(int open,int close,int n,List<String>ans,String str){
        if(str.length()==2*n){
            ans.add(str);
            return;
        }
        if(open<n){
            find(open+1,close,n,ans,str+"(");
        }
        if(close<open){
            find(open,close+1,n,ans,str+")");
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        String str="";
        find(0,0,n,ans,str);
        return ans;
    }
}