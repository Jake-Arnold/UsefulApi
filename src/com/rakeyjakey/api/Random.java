package com.rakeyjakey.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Random {

	static java.util.Random random = new java.util.Random();
	
	/**
	 * @param low
	 *            The low bound of the random integer. (inclusive)
	 * @param high
	 *            The high bound of the random integer. (exclusive)
	 * @return Returns a random integer between low (inclusive) and high
	 *         (exclusive).
	 * @throws IllegalArgumentException
	 *             if the high bound is less than the low bound.
	 * 
	 */
	public static int nextInt(int low, int high) {

		if (high < low)
			throw new IllegalArgumentException(
					"The high bound cannot be less than the low bound");

		int i;

		do {
			i = random.nextInt(high);
		} while (i < low);

		return i;
	}

	/**
	 * 
	 * @param digits
	 *            The number of digits you wish the random number to have.
	 * @return Returns a random number with the specified amount of digits.
	 * @throws IllegalArgumentException
	 *             if digits <= 0.
	 */
	public static int nextInt(int digits) {

		if (digits <= 0)
			throw new IllegalArgumentException(
					"The argument 'digits' must be greater than 0.");

		int i;
		int max = (digits + 1) * 1000;

		do {
			i = random.nextInt(max);
		} while (Maths.numberOfDigits(i) != digits);

		return i;
	}

	/**
	 * 
	 * @param length
	 *            the length in characters you want the random String to be.
	 * @return a random String of specified length.
	 */
	public static String nextString(int length) {
		StringBuilder s = new StringBuilder();

		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
				"w", "u", "x", "y", "z" };

		for (int i = 0; i < length; i++) {
			s.append(alphabet[nextInt(0, alphabet.length)]);
		}

		return s.toString();
	}

	/**
	 * 
	 * @param length
	 *            the length in characters you want the random String to be.
	 * @param exclude
	 *            any characters that you wish to exclude.
	 * @return a random String of specified length.
	 */
	public static String nextString(int length, String... exclude) {

		StringBuilder s = new StringBuilder();

		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
				"w", "u", "x", "y", "z" };

		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList(alphabet));

		List<String> list2 = new ArrayList<>();
		list2.addAll(Arrays.asList(exclude));

		list.removeAll(list2);

		for (int i = 0; i < length; i++) {
			s.append(list.get(nextInt(0, list.size())));
		}

		return s.toString();
	}

	public static void main(String[] args) {
		while (true) {

			System.out.println(nextString(4));

			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}
		}
	}
}
