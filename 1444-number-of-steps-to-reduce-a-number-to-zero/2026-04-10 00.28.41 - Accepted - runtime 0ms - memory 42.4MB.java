class Solution {
    int ctr =0;
    public int numberOfSteps(int num) {
        if(num == 0){
            return ctr;
        }
        ctr++;
        if(num % 2 == 0){
            return numberOfSteps(num/2);
        }
        else{
            return numberOfSteps(num-1);
        }
    }
}

// class Solution {
//     int ctr = 0;
// public int numberOfSteps(int num, int ctr) {
//     if(num == 0) return ctr;

//     if(num % 2 == 0) 
//         return numberOfSteps(num/2, ctr+1);
//     else 
//         return numberOfSteps(num-1, ctr+1);
// }
// }






