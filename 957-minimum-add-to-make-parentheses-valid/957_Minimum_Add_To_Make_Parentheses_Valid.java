// class Solution {
//     public int minAddToMakeValid(String s) {
//         Stack<Character> stack = new Stack<>();

//         for(char c : s.toCharArray()){
//             if(c == ')'){
//                 if(!stack.isEmpty() && stack.peek() == '('){
//                     stack.pop();
//                 }
//                 else{
//                     stack.push(c);
//                 }
//             }
//             else{
//                 stack.push(c);
//             }
//         }
//         return stack.size();
//     }
// }
class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int open = 0;
        for(char ch:s.toCharArray()){
            if(ch == '('){
                open++;
            }else{
                open--;
            }
            if(open<0){
                ans++;
                open =0;
            }
        }
        return ans+ open;
    }
}


// class Solution{
//     public int minAddToMakeValid(String s){
//         int ans = 0;
//         if(s.length() == 0){
//         return 0;
//         }
//         for(char c : s.toCharArray()){
//             if(c == '('){
//                 ans++;
//             }
//             else{
//                 ans--;
//             }
//         }
//         return Math.abs(ans);
//     }
// }

// Stack<Character> stack = new Stack<>();

//         for(char ch : s.toCharArray()){
//             if(ch == ')'){
//                 if(!stack.isEmpty() && stack.peek() == '('){
//                     stack.pop();
//                 }else{
//                     stack.push(ch);
//                 }
//             }
//             else{
//                 stack.push(ch);
//             }
//         }
//         return stack.size();


