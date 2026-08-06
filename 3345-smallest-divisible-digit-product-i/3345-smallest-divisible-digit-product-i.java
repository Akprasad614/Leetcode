class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int prod = 1;
            int m = n;
            while(m!=0){
                int i = m%10;
                prod = prod*i; 
                m = m/10;
            }
            if(prod % t == 0) return n;
            n++;
        }

    }
}