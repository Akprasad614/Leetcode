class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character , Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        for(char ch : t.toCharArray()){                         // 16 ms
            if(!map.containsKey(ch) || map.get(ch) == 0){
                return false;
            }
            map.put(ch,map.get(ch)-1);
        }
        return true;
    }
}



        
// class Solution {
//     public boolean isAnagram(String s, String t) {

//         if(s.length() != t.length()) {
//             return false;
//         }

//         int[] count = new int[26];

//         for(int i = 0; i < s.length(); i++) {.          // 5ms
//             count[s.charAt(i) - 'a']++;
//             count[t.charAt(i) - 'a']--;
//         }

//         for(int val : count) {
//             if(val != 0) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }