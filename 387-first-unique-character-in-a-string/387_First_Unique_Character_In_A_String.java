// class Solution {
//     public int firstUniqChar(String s) {
//         HashMap<Character,Integer> map = new HashMap<>();

//         for(char ch : s.toCharArray()){
//             map.put(ch,map.getOrDefault(ch,0) + 1);
//         }
//         for(int i = 0;i<s.length();i++){                           // 32 ms [ HashMap ]. not good approach
//             char ch = s.charAt(i);
//             if(map.get(ch) == 1){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }
class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){                           // 5 ms [ freq array ]. good approach
            if(freq[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}