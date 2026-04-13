import java.util.HashMap;
//Hash Table
//Determine if two strings are isomorphic. Two strings are isomorphic if the characters
// in the first string can be replaced to get the second string
// (using a hash map to track character mappings).
public class Task5 {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sToT = new HashMap<>();
        HashMap<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sToT.containsKey(sChar)) {
                if (sToT.get(sChar) != tChar) return false;
            } else {
                sToT.put(sChar, tChar);
            }
            if (tToS.containsKey(tChar)) {
                if (tToS.get(tChar) != sChar) return false;
            } else {
                tToS.put(tChar, sChar);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("ab", "aa"));
    }
}