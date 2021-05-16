package com.exercise.palindrome;

public class ClosestPalindrome {

	private static boolean isAllNine(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != '9') {
				return false;
			}
		}
		return true;
	}

	private static boolean ifPowerOf10(Integer val) {
		if (Math.log10(val) - (int) Math.log10(val) == 0) {
			return true;
		} else
			return false;

	}

	private static int buildMirror(int value, boolean forOdd) {
		String newLeftStr = new Integer(value).toString();
		StringBuilder result = new StringBuilder(newLeftStr);
		StringBuilder sbForRevert;
		
		if (forOdd && value >= 10) {
			// don't need the middle digit for Revert in this case
			sbForRevert = new StringBuilder(newLeftStr.substring(0, newLeftStr.length() - 1));
		}else {
			sbForRevert = new StringBuilder(newLeftStr);
		}
		
		sbForRevert.reverse();
		result.append(sbForRevert);
		return Integer.parseInt(result.toString());
	}

	private static int pickClosestOneButNotSelf(int origin, int val1, int val2, int val3) {

		// If origin value is palindrome, want to exclude the same val
		int diff1 = Math.abs(val1 - origin) == 0 ? Integer.MAX_VALUE : Math.abs(val1 - origin);
		int diff2 = Math.abs(val2 - origin) == 0 ? Integer.MAX_VALUE : Math.abs(val2 - origin);
		int diff3 = Math.abs(val3 - origin) == 0 ? Integer.MAX_VALUE : Math.abs(val3 - origin);

		int closestVal = val1;
		int cloestDiff = diff1;

		if (diff2 < diff1) {
			closestVal = val2;
			cloestDiff = diff2;
		}

		if (diff3 < cloestDiff) {
			cloestDiff = diff3;
			closestVal = val3;
		}
		return closestVal;
	}

	public static Integer calPalindrome(String input) {

		int value = Integer.parseInt(input);

		if (value == 0) {
			return 1;
		}

		// if single digit, such as 8
		if (value < 10) {
			return value - 1;
		}

		// such as 10000
		if (ifPowerOf10(value)) {
			return value - 1;
		}
		// such as 10001
		if (ifPowerOf10(value - 1)) {
			return value - 2;
		}

		// if all 9, such as 99999
		if (isAllNine(input)) {
			return value + 2;
		}

		int length = input.length();
		boolean oddLength = length % 2 != 0;
		int middle = (int) Math.ceil((double) length / 2);

		String left = input.substring(0, middle);

		int newValue1 = Integer.parseInt(left) - 1;
		int newValue2 = Integer.parseInt(left);
		int newValue3 = Integer.parseInt(left) + 1;

		return pickClosestOneButNotSelf(value, buildMirror(newValue1, oddLength), buildMirror(newValue2, oddLength),
				buildMirror(newValue3, oddLength));
	}

	public static void main(String[] args) {
		// I have another test class to compare results between this way of calculation and brutal way of calculating closest Palindrome
		// for all integers with a for loop, and the results are matching.
		long start = System.nanoTime();
		System.out.println(ClosestPalindrome.calPalindrome("101"));
		System.out.println(ClosestPalindrome.calPalindrome("1002"));
		System.out.println(ClosestPalindrome.calPalindrome("1299"));
		System.out.println(ClosestPalindrome.calPalindrome("1805170811"));
		long finish = System.nanoTime();
		long timeElapsed = finish - start;
		System.out.println("Time used:" + timeElapsed);
	}

}
