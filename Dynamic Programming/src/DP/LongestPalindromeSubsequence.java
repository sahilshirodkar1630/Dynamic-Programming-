package DP;

import java.util.Scanner;

public class LongestPalindromeSubsequence {

	/*
	516. Longest Palindromic Subsequence

	Given a string s, find the longest palindromic subsequence's length in s.
	A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

	Example 1:
	Input: s = "bbbab"
	Output: 4
	Explanation: One possible longest palindromic subsequence is "bbbb".
	
	Example 2:
	Input: s = "cbbd"
	Output: 2
	Explanation: One possible longest palindromic subsequence is "bb".
	
	Constraints:
	1 <= s.length <= 1000
	s consists only of lowercase English letters.
	
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		System.out.println(LPSRecursive(a.toCharArray(),0,a.length()-1));
		System.out.println(LPSDP(a));
	}
	
// DP Approach
	private static int LPSDP(String a) {
		// TODO Auto-generated method stub
		int n = a.length();
		int dp[][] = new int[n][n];
		for(int g = 0; g < n; g++) {
			for(int i = 0, j = g; j < dp.length ;i++, j++) {
				if(g == 0) {
					dp[i][j] = 1;
				}else if(g == 1) {
					if(a.charAt(i) == a.charAt(j)) {
						dp[i][j] = 2;
					}else {
						dp[i][j] = 1;
					}
				}else {
					if(a.charAt(i) == a.charAt(j)) {
						dp[i][j] = dp[i+1][j-1] + 2;
					}else {
						dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
					}
				}
			}
		}
		return dp[0][n-1];
	}

	// RECURSIVE Approach
	private static  int LPSRecursive(char a[], int i, int j) {
	
		// Base Case 1: If there is only 1 character
        if (i == j) {
            return 1;
        }
 
    // Base Case 2: If there are only 2 characters and both are same
        if (a[i] == a[j] && i + 1 == j) {
            return 2;
        }
        
        // If first  and last characters match
        if(a[i]==a[j]) {
        	return LPSRecursive(a, i+1, j-1)+2;
        }
        
        //If first and last characters do not match
        return Math.max(LPSRecursive(a, i+1, j), LPSRecursive(a, i, j-1));
        
	}
	
	

}
