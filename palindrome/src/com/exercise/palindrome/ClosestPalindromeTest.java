package com.exercise.palindrome;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClosestPalindromeTest {

	@Test
	void testCalPalindrome() {
		assertEquals(ClosestPalindrome.calPalindrome("101"), 99);
		assertEquals(ClosestPalindrome.calPalindrome("999"), 1001);
		assertEquals(ClosestPalindrome.calPalindrome("12345"), 12321);
		assertEquals(ClosestPalindrome.calPalindrome("1299"), 1331);
		assertEquals(ClosestPalindrome.calPalindrome("1"), 0);
		assertEquals(ClosestPalindrome.calPalindrome("9"), 8);
	}

}
