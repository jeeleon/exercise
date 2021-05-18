package com.exercise.palindrome;

public class CompareResults {

	public static void main(String[] args) {

		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			//System.out.println(i);
			int brutalResult = ClosestPalindromeBrutal.closestPalindrome(Integer.toString(i));
			int result = ClosestPalindrome.calPalindrome(Integer.toString(i));
			if (brutalResult != result) {
				System.out.println(new StringBuffer("i:").append(i).append("; brutal result: ").append(brutalResult)
						.append("; result:").append(result).toString());
			}
		}
	}

}
