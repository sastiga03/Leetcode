class Solution {
    public int countGoodSubstrings(String s) {
        int left=0;
        int right=0;
        int count=0;
        HashSet<Character> set=new HashSet<>();
        while(right<s.length()){
            set.add(s.charAt(right));
            if(right-left+1==3){
                if(set.size()==3){
                    count++;
                }
                set.clear();
                left++;
                set.add(s.charAt(left));
                set.add(s.charAt(left+1));
            }
            right++;
        }
        return count;
    }
}