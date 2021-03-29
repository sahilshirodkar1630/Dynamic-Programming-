package DP;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibDP(n));
		System.out.println(fibM(n));
		
	}
	public static int fibM(int n) {
		int dp[] = new int[n+1];
		
		Arrays.fill(dp,-1);
		return fibM(n, dp);
	}

	public static int fibM(int n,int[] dp) {
		if(n == 0 || n == 1) {
			dp[n] = n;
			return n;
		}
		if(dp[n]!= -1) {
			return dp[n];
		}
		dp[n]= fibM(n-1)+fibM(n-2);
		return dp[n];
		
	}
	
	public static int fibDP(int n) {
		
		int dp[] = new int[n+1];
		
		for(int i=0;i<n+1;i++) {
			if(i<2) {
				dp[i]=i;
			}else {
			dp[i]= dp[i-1]+dp[i-2];
			}
		}
		return dp[n];
		
	}
}
