package com.exercise.palindrome;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClosestPalindromeBrutalTest {

	@Test
	void testClosestPalindrome() {
		assertEquals(ClosestPalindromeBrutal.closestPalindrome("101"), 99);
		assertEquals(ClosestPalindromeBrutal.closestPalindrome("999"), 1001);
		assertEquals(ClosestPalindromeBrutal.closestPalindrome("12345"), 12321);
		assertEquals(ClosestPalindromeBrutal.closestPalindrome("1299"), 1331);
		assertEquals(ClosestPalindromeBrutal.closestPalindrome("1"), 0);
		assertEquals(ClosestPalindromeBrutal.closestPalindrome("9"), 8);
	}

}
