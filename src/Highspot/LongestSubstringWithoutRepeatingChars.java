package Highspot;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        int start = 0, end = 0;
        String str = "abcdedabe";
        int n = str.length(), max_len = 0;
        while (end < n) {
            while (set.contains(str.charAt(end))) {
                set.remove(str.charAt(start++));
            }
            set.add(str.charAt(end++));
            max_len = Math.max(max_len, set.size());
        }
        System.out.println(max_len);
    }

}
