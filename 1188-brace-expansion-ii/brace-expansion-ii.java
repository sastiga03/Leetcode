import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression, new int[]{0});
        
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> parse(String s, int[] index) {
        Set<String> result = new TreeSet<>();
        Set<String> current = new TreeSet<>();
        current.add("");

        while (index[0] < s.length() && s.charAt(index[0]) != '}') {
            char ch = s.charAt(index[0]);

            if (ch == ',') {
                result.addAll(current);
                current.clear();
                current.add("");
                index[0]++;
            } 
            else if (ch == '{') {
                index[0]++;

                Set<String> inside = parse(s, index);

                index[0]++; // skip '}'

                current = concatenate(current, inside);
            } 
            else {
                // lowercase letter
                Set<String> letter = new HashSet<>();
                letter.add(String.valueOf(ch));

                current = concatenate(current, letter);
                index[0]++;
            }
        }

        result.addAll(current);
        return result;
    }

    private Set<String> concatenate(Set<String> a, Set<String> b) {
        Set<String> result = new TreeSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}