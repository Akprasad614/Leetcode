class Solution {
    public int maximum69Number (int num) {
        String str = String.valueOf(num);
        for(int i =0;i<str.length();i++){
            if(str.charAt(i) == '6'){
                String newString =  str.substring(0,i) + "9" + str.substring(i+1);
                return Integer.parseInt(newString);
            }
        }
        return num;
    }
}

// String str = String.valueOf(num);
//         for(int i = 0; i<str.length() ; i++){
//             if(str.charAt(i) == '6'){
                
//                 String newString = str.substring(0,i) + "9" + str.substring(i+1);
//                 return Integer.parseInt(newString);
//             }
//         }
//         return num;
