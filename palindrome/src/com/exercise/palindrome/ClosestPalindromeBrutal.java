package com.exercise.palindrome;

class ClosestPalindromeBrutal {

	// Function to check Palindrome   
	public static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	// Function return closest Palindrome number
	public static int closestPalindrome(String input) {

		int value = Integer.parseInt(input);

		// Case1 : largest palindrome number
		// which is smaller to given number
		int RPNum = value - 1;

		while (isPalindrome(Integer.toString(RPNum)) == false) {
			RPNum--;
		}

		// Case 2 : smallest palindrome number
		// which is greater than given number
		int SPNum = value + 1;

		while (isPalindrome(Integer.toString(SPNum)) == false) {
			SPNum++;
		}

		int result = 0;

		// Check absolute difference
		if (Math.abs(value - SPNum) < Math.abs(value - RPNum)) {
			result = SPNum;
		} else {
			result = RPNum;

		}
		return result;
	}

	// Driver code    
	public static void main(String[] args) {
		String input = "102";
		long start = System.nanoTime();
		System.out.println(closestPalindrome(input));
		long finish = System.nanoTime();
		long timeElapsed = finish - start;
		System.out.println(timeElapsed);
	}
}