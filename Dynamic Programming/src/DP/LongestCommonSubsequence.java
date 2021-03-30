package DP;

import java.util.Scanner;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		int output = LCS(a,b);
		System.out.println(output);
		System.out.println(lcs(a, b));
	}

	//Recurssion APproach
	public static int findLCSM(String a,String b) {
		int m = a.length();
		int n = b.length();
		int dp[][] = new int[m+1][n+1];
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				dp[i][j]= -1;
			}
		}
		
		return findLCSM(a, b,dp);
	}
	
	// Memoization Approach
	private static int findLCSM(String a, String b, int[][] dp) {
		// TODO Auto-generated method stub
		int m = a.length();
		int n = b.length();
		
		if(dp[m][n]!= -1) {
			return dp[m][n];
		}
		
		if(m == 0 || n == 0) {
			dp[m][n]=0;
			return dp[m][n];
		}
		
		if(a.charAt(0)==b.charAt(0)) {
			dp[m][n] = 1+findLCSM(a.substring(1), b.substring(1), dp);
		}else {
			int op1 = findLCSM(a, b.substring(1), dp);
			int op2 = findLCSM(a.substring(1), b, dp);
			dp[m][n] = Math.max(op1, op2);
		}
		
		return dp[m][n];
		
	}
	
	//DP Approach1
	private static int LCS(String a, String b) {
		// TODO Auto-generated method stub
		int n = a.length();
		int m = b.length();
		int dp[][] = new int[n+1][m+1];
		for(int i = dp.length-2; i >= 0; i--) {
			for(int j = dp[0].length-2; j >= 0; j--) {
				if(a.charAt(i) == b.charAt(j)) {
					dp[i][j] = 1 +dp[i+1][j+1];
				}else {
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		
		return dp[0][0];
	}
	
	//DP Approach2
	public static int lcs(String a,String b) {
		int dp[][] = new int[a.length()+1][b.length()+1];
		for(int i=1; i < a.length() + 1; i++) {
			for(int j = 1; j < b.length() + 1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = 1 +dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[a.length()][b.length()]; 
	}

}
