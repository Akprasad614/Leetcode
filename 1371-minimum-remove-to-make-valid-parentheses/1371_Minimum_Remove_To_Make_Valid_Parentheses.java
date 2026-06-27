class Solution {
    public String minRemoveToMakeValid(String s) {
        //Stack<Integer> stack = new Stack<>();         16 ms
        Deque<Integer> stack = new ArrayDeque<>();      // 10 ms deque is faster version
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length;i++){
            if(arr[i] == '('){
                stack.push(i);
            }
            else if(arr[i] == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    arr[i] = '*';
                }
            }
        }
        while(!stack.isEmpty()){
            arr[stack.pop()] = '*';
        }

        StringBuilder st = new StringBuilder();
        for(char ch : arr){
            if(ch != '*'){
                st.append(ch);
            }
        }

        return st.toString();
    }
}