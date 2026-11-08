class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer>magmap=new HashMap<>();
        for(char c:magazine.toCharArray()){
            magmap.put(c,magmap.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer>ranmap=new HashMap<>();
        for(char c:ransomNote.toCharArray()){
            ranmap.put(c,ranmap.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer>entry:ranmap.entrySet()){
            if(entry.getValue()>magmap.getOrDefault(entry.getKey(),0)){
                return false;
            }
        }
        return true;

    }
}