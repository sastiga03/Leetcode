class Solution {
    public void  res(int i,int n, int k,List<Integer>list,List<List<Integer>>find){
        if(list.size()==k){
            find.add(new ArrayList(list));
            return;
        }
        for(int j=i;j<=n;j++){
            list.add(j);
            res(j+1,n,k,list,find);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>find=new ArrayList<>();
        int i=0;
        res(1,n,k,new ArrayList<>(),find);
        return find;
    }
}