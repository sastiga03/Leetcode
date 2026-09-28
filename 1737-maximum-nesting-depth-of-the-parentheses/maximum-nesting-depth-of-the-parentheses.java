class Solution {
    public int maxDepth(String s) {
        int c=0;
        int maxnum=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                c++;
                if(maxnum<c)
                maxnum=c;
            }
            else if(s.charAt(i)==')'){
                c--;
            }
        }
        return maxnum;
    }
}