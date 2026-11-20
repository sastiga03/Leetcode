class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr=new int[26];
        int i=0;
        int j=0;
        int ans=0;
        int max=0;
        while(j<s.length()){
            arr[s.charAt(j)-'A']++;
            max=Math.max(max,arr[s.charAt(j)-'A']);
            if((j-i+1)-max>k){
                arr[s.charAt(i)-'A']--;
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}