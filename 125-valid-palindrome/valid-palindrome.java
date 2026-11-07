class Solution {
    public boolean isPalindrome(String s) {
        String ans="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' ' && Character.isLetterOrDigit(s.charAt(i))){
                ans+=Character.toLowerCase(s.charAt(i));
            }
        }
        int i=0;
        int j=ans.length()-1;
        while(i<j){
            if(ans.charAt(i)!=ans.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}