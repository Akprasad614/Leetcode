class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int digit = 0;
        StringBuilder str = new StringBuilder();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                digit = digit*10 + (c - '0');
            }

            else if(c == '['){
                numStack.push(digit);
                strStack.push(str);

                digit = 0;
                str = new StringBuilder();
            }

            else if(c == ']'){
                int repeat = numStack.pop();
                StringBuilder prevStr = strStack.pop();

                for(int i =0;i<repeat;i++){
                    prevStr.append(str);
                }
                str = prevStr;
            }

            else{
                str.append(c);
            }
        }
        return str.toString();
    }
}