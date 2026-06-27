// // cycle of a linked list

// class Solution {
//     public boolean isHappy(int n) {
//         int first = n;
//         int second = n;
//         do{
//             first = square(first);
//             second = square(square(second));
//         }while(first != second);
//         if(first == 1){
//             return true;
//         }
//         return false;
//     }
//     int square(int n){
//         int sum = 0;
//         while(n>0){
//             int rem = n%10;
//             sum += (rem*rem);
//             n = n/10;
//         }
//         return sum;
//     }
// }


class Solution {
    public boolean isHappy(int n) {
        while(n!=1 && n!=4){
        int sum = 0;
            while(n > 0){
                int d = n%10;
                sum+=d*d;                                  // 4 check the presence of loop beacuse whe 4 arives it continues to form
                n = n/10;                                  // a number loop and end with 4, so when 4 is found then it is 
            }                                              // (not HAPPY NUMBER)
            n = sum;
        }
        if(n==1){
            return true;
        }
        else return false;
    }
}