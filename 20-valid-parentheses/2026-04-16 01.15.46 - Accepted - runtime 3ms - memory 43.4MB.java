class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '{')
            stack.push('}');
            else if(c == '(')
            stack.push(')');
            else if(c == '[')
            stack.push(']');
            else{
                if(stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

// import java.util.Stack;
// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> stack = new Stack<>();

//         for(char ch : s.toCharArray()){
//             if(ch == '[' || ch == '(' || ch == '{'){
//                 stack.push(ch);
//             }
//             else{
//                 if(ch == ')'){
//                     if(stack.isEmpty() || stack.pop() != '('){
//                         return false;
//                     }
//                 }if(ch == '}'){
//                     if(stack.isEmpty() || stack.pop() != '{'){
//                         return false;
//                     }
//                 }if(ch == ']'){
//                     if(stack.isEmpty() || stack.pop() != '['){
//                         return false;
//                     }
//                 }
//             }
//         }
//         return stack.isEmpty();
//     }
// }