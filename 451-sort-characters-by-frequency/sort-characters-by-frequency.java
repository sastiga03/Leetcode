class Solution {
    public String frequencySort(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        String str = "";
        while (!map.isEmpty()) {
            char ch = ' ';
            int max = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    ch = entry.getKey();
                }
            }
            for (int i = 0; i < max; i++) {
                str += ch;
            }
            map.remove(ch);
        }
        return str;
    }
}