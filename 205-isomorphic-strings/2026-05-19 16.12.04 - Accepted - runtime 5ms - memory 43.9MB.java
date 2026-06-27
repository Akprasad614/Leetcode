class Solution {
    public boolean isIsomorphic(String s, String t) {
        int [] map1 = new int[256];
        int [] map2 = new int[256];                 // as ascii value upto 256 , initialy all 0
        for(int i = 0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map1[c1] != map2[c2]){                       // 5 ms.  using array
                return false;
            }
            map1[c1] = i+1;
            map2[c2] = i+1;
        }
        return true;
    }
}
        // if(s.length() != t.length()){
        //     return false;
        // }
        // Map<Character,Character> s1 = new HashMap<>();
        // Map<Character,Character> s2 = new HashMap<>();
        // for(int i = 0;i<s.length();i++){
        //     char c1 = s.charAt(i);
        //     char c2 = t.charAt(i);                                          // 26 ms.    HashMap
        //     if (s1.containsKey(c1) && s1.get(c1) != c2) {
        //         return false;
        //     }

        //     if (s2.containsKey(c2) && s2.get(c2) != c1) {
        //         return false;
        //     }
        //     s1.put(c1,c2);
        //     s2.put(c2,c1);
        // }
        // return true;