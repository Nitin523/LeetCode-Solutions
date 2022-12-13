// Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

// A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

 

// Example 1:

// Input: str1 = "abac", str2 = "cab"
// Output: "cabac"
// Explanation: 
// str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
// str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
// The answer provided is the shortest such string that satisfies these properties.
// Example 2:

// Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
// Output: "aaaaaaaa"


//NOTE
// Shortest COmmon Super sequence length  =   a.length+b.length-Length of LCS of (a,b)


class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        	return LCS(str1.length(),str2.length(),str1,str2);
	}    

	public String LCS(int n1,int n2, String s,String t){
		int dp[][] = new int[n1+1][n2+1];
		for(int i=1; i<=n1; i++){
			for(int j=1; j<=n2; j++){
				if(s.charAt(i-1)==t.charAt(j-1)){
					dp[i][j] = 1+ dp[i-1][j-1];
				}else{
					dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
				}
			}
		}
        
        int i=n1, j=n2;
		String st="";
		while(i>0 && j>0){
			if(s.charAt(i-1)==t.charAt(j-1)){
				st=s.charAt(i-1)+st;
				i--;
				j--;
			}else if(dp[i-1][j]>dp[i][j-1]){
				st=s.charAt(i-1)+st;
				i--;
			}else{
				st=t.charAt(j-1)+st;
				j--;
			}
		}
		while(i> 0){
			st=s.charAt(i-1)+st;
			i--;
		}
		while(j> 0){
			st=t.charAt(j-1)+st;
			j--;
		}
		return st;
	}
}