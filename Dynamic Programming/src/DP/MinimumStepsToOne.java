package DP;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumStepsToOne {

	/*
	Code: Min Steps to One using DP
	
		Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:
		1.) Subtract 1 from it. (n = n - ­1) ,
		2.) If n is divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
		3.) If n is divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
		
		Input format :
		The first and the only line of input contains an integer value, 'n'.
		
		Output format :
		Print the minimum number of steps.
		
		Constraints :
		1 <= n <= 10 ^ 6
		
		Time Limit: 1 sec
		Sample Input 1 :
		4
		Sample Output 1 :
		2 
		Explanation of Sample Output 1 :
		For n = 4
		Step 1 :  n = 4 / 2  = 2
		Step 2 : n = 2 / 2  =  1 
		Sample Input 2 :
		7
		Sample Output 2 :
		3
		
		Explanation of Sample Output 2 :
		For n = 7
		Step 1 :  n = 7 ­- 1 = 6
		Step 2 : n = 6  / 3 = 2 
		Step 3 : n = 2 / 2 = 1  
			
	
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		System.out.println(countMinStepsToOneDP(n));
		System.out.println(countMinStepsToOneM(n));
		System.out.println(countMinStepsToOne(n));
	}
	public static int countMinStepsToOne(int n) {
		//Your code goes here
		if(n==1) {
			return 0;
		}
		int op1 = countMinStepsToOne(n-1);
		int op2=Integer.MAX_VALUE;
		int op3=Integer.MAX_VALUE;
		if(n%3==0) {
			 op2 =countMinStepsToOne(n/3);
		}
		if(n%2==0) {
			 op3 = countMinStepsToOne(n/2);
			
		}
		return Math.min(op1, Math.min(op2, op3))+1;
	}
	public static int countMinStepsToOneM(int n) {
		int dp[] = new int[n+1];
		
		Arrays.fill(dp,-1);
		return countMinStepsToOneM(n, dp);
	}
	private static int countMinStepsToOneM(int n, int[] dp) {
		// TODO Auto-generated method stub
		if(n==1) {
			dp[n] = 0;
			return 0;
		}
		if(dp[n] != -1) {
			return dp[n];
		}
		int op1 = countMinStepsToOneM(n-1,dp);
		int op2=Integer.MAX_VALUE;
		int op3=Integer.MAX_VALUE;
		if(n%3==0) {
			 op2 =countMinStepsToOneM(n/3,dp);
		}
		if(n%2==0) {
			 op3 = countMinStepsToOneM(n/2,dp);
			
		}
		dp[n] = Math.min(op1, Math.min(op2, op3))+1;
		
		return dp[n];
	}
	
	public static int countMinStepsToOneDP(int n) {
		int dp[] = new int[n+1];
		dp[1] = 0;
		for(int i=2;i<n+1;i++) {
			int op1 = dp[i-1];
			int op2=Integer.MAX_VALUE;
			int op3=Integer.MAX_VALUE;
			if(i%3==0) {
			 op2 = dp[i/3];
			}
			if(i%2==0) {
			 op3 =dp[i/2];
			}
			dp[i]= Math.min(op1, Math.min(op2, op3))+1;
		}
		return dp[n];
	}

}
