class Solution { ////     Introduction to [ DP ]
    int[] dp;
    int climb(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = climb(n-1) + climb(n-2);
        return dp[n];
    }
    public int climbStairs(int n) {
        dp = new int[n+1];
        return climb(n);
    }
}

// tabulation form

// class Solution {

//     public int climbStairs(int n) {

//         if(n<=2)
//             return n;

//         int dp[]=new int[n+1];

//         dp[1]=1;
//         dp[2]=2;

//         for(int i=3;i<=n;i++){

//             dp[i]=dp[i-1]+dp[i-2];

//         }

//         return dp[n];
//     }
// }


//Space optimized 

// class Solution {

//     public int climbStairs(int n) {

//         if(n<=2)
//             return n;

//         int prev2 = 1;
//         int prev1 = 2;

//         for(int i=3;i<=n;i++){

//             int curr = prev1 + prev2;

//             prev2 = prev1;
//             prev1 = curr;
//         }

//         return prev1;
//     }
// }