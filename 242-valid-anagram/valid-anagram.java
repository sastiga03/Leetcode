class Solution {
    public boolean isAnagram(String s, String t) {
        char[] tarray=t.toCharArray();
        char[] sarray=s.toCharArray();
        Arrays.sort(tarray);
        Arrays.sort(sarray);
        if(tarray.length!=sarray.length){
            return false;
        }
        for(int i=0;i<sarray.length;i++){
            if(sarray[i]!=tarray[i]){
                return false;
            }
        }
        return true;

    }
}