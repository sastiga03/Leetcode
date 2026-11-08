class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            String sorted=new String(arr);
            if(map.containsKey(sorted)){
                map.get(sorted).add(str);
            }
            else{
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(sorted,temp);
            }
        }
        return new ArrayList<>(map.values());
    }
}