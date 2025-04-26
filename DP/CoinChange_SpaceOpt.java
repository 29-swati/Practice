/*Given an integer array coins[ ] representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ]. 
Note: Assume that you have an infinite supply of each type of coin. Therefore, you can use any coin as many times as you want.
Answers are guaranteed to fit into a 32-bit integer. 

Examples:

Input: coins[] = [1, 2, 3], sum = 4
Output: 4
Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3]. */

//-------------------------- SPACE OTIMIZED -------------------------------------


//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int count(int coins[], int sum) {
        // code here.
        int n = coins.length;
        //int[][] dp = new int[n+1][sum+1]; 
        
        int[] dp = new int[sum+1];
        dp[0] = 1;
        
        int prevArr[] = new int[sum+1];
        prevArr[0] = 1;
        
        for(int c=1;c<=n;c++){
            prevArr = dp;
            for(int s=1;s<=sum;s++){
                int coinValue = coins[c-1];
                dp[s] = prevArr[s];
                if(s-coinValue >=0){
                    dp[s] += dp[s-coinValue];
                    //System.out.print(dp[c][s-coinValue]);
                }
             
            }
            
            
            //System.out.println();
        }
        
        return dp[sum];
    }
}
