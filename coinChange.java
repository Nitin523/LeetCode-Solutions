// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

 

// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1
// Example 3:

// Input: coins = [1], amount = 0
// Output: 0




class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int[coins.length + 1][amount + 1];
        
        for(int i=0;i<coins.length+1;i++)
            dp[i][0] = 0;
        
        for(int j=0;j<amount+1;j++)
            dp[0][j] = Integer.MAX_VALUE - 1;
        
        for(int i=1;i<coins.length+1;i++) {
            for(int j=1;j<amount+1;j++) {
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
            }
        }
        if(dp[coins.length][amount] == Integer.MAX_VALUE -1)
            return -1;
        else 
            return dp[coins.length][amount];
    
        
    }
}