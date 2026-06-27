class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==0){
            return false;
        }
        while(n != 1){
            if(n % 4 != 0){
                return false;
            }
            n=n/4;
        }
        return true;
    }
}


// if(n<0) return false;
// if(n == 1) return true;                      1st condition checks the powers of 2 only 2nd checks the multiple of 4 giving 
// return (n&(n-1) == 0 && n % 3==1);      remainder = 1(as many non multiple of 2 gives rem = 1) and both filter out powers of 4 