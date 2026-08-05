class Solution {
public:
    bool isPalindrome(string s) {// return me boolean mang rha
        //  s= "A man, a plan, a canal: Panama" then
        string butki;
        for (char c : s) { // c check every char in string s
            if (isalnum(c)) { 
                butki += tolower(c);
            }
        } 
        // s = amanaplanacanalpanama now
        // ek pointer ko start me rakho or dusre ko last me
         int start = 0;
         int end = butki.size()-1;
         while(start < end){ 
            if(butki[start] != butki[end]){
                return false; //if agr ye cond satis krta he toh false return kr dega nhi toh means ye cond kavi satis kiya he nhi toh return toh nhi krega toh means its palin means u hvae to return true soooo
            }
            // do start ko 1 step inc and end ko dec
            start++;
            end--;
         }
        return true;// means after looping ends means its palin so u return true 
        
    }
}; 