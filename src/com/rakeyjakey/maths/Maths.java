package com.rakeyjakey.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Jake Arnold.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

public final class Maths {

    private Maths() {
        //To prevent instantiation.
    }

    /**
     * Checks if the given integer is even.
     *
     * @param i integer to check if even.
     * @return true if integer given is even.
     */

    public static boolean isEven(int i) {
        return i % 2 == 0;
    }

    /**
     * Checks if the given double is a whole number.
     *
     * @param i double to check if whole.
     * @return true if integer given is a whole number (integer).
     */

    public static boolean isInteger(double i) {
        return i == Math.round(i);
    }

    /**
     * Checks if the given long is prime.
     *
     * @param l integer to check if prime.
     * @return true if integer given prime.
     */

    public static boolean isPrime(long l) {

        if (l < 2)
            return false;

        for (long i = 2; i < l - 1; i++) {
            if (l % i == 0)
                return false;
        }

        return true;
    }

    /**
     * Checks if the given integer is a square number.
     *
     * @param i integer to check if square number.
     * @return true if integer given is a square number.
     */

    public static boolean isSquareNumber(int i) {
        return isInteger(Math.sqrt(i));
    }

    /**
     * Checks if the given integer is a cube number.
     *
     * @param i integer to check if cube number.
     * @return true if integer given is a cube number.
     */
    public static boolean isCubeNumber(int i) {
        return isInteger(Math.cbrt(i));
    }

    /**
     * Checks if integer i is a multiple of integer j.
     *
     * @param i integer that we will be checking the multiple of.
     * @param j integer to check if is a multiple of i.
     * @return true if integer j is a multple of integer i.
     */
    public static boolean isMultipleOf(int i, int j) {
        return j % i == 0;
    }

    /**
     * Returns the fibonacci number at the term given.
     *
     * @param term the nth term of the sequence that you with to output.
     * @return the fibonacci number located at the nth term.
     */
    public static int fibonacciNumber(int term) {

        if (term == 0 || term > 46) {
            throw new IllegalArgumentException("Value not between 1 and 46.");
        }

        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 0; i < term; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * Checks if the given integer is a palindromic number.
     *
     * @param i the integer to check.
     * @return true if the integer is a palindromic number.
     */
    public static boolean isPalindromicNumber(int i) {

        // This converts i to a string.
        final String number = String.valueOf(i);

        // This creates a list to hold the characters of the number.
        List<Character> digitsCorrectWay = new ArrayList<Character>();

        // This populates the list with the characters.
        for (char c : number.toCharArray()) {
            digitsCorrectWay.add(c);
        }

        // This creates a clone of the initial list that is holding the
        // characters.
        List<Character> digitsReversed = new ArrayList<Character>(
                digitsCorrectWay);

        // This reverses the copy of the list.
        Collections.reverse(digitsReversed);

        // If the characters of the number are equal both reversed and the
        // normal way round then return true.
        return digitsCorrectWay.equals(digitsReversed);
    }

    /**
     * Checks if the integers given are evenly divisible by the divisor given.
     *
     * @param divisor  the integer to use as the divisor.
     * @param integers the integers that you wish to check are evenly divisible by
     *                 the divisor.
     * @return true if all integers are evenly divisible by the divisor.
     */
    public static boolean isEvenlyDivisibleBy(int divisor, int... integers) {

        // The integers specified are looped through, returning false if the
        // value divided by any of these gives a remainder.
        for (int i : integers) {
            if (divisor % i != 0) {
                return false;
            }
        }
        return true;

    }

    /**
     * Checks how many digits are in the integer provided.
     *
     * @param i The integer to be checked.
     * @return Returns the number of digits of the integer given.
     */
    public static int numberOfDigits(int i) {
        return String.valueOf(i).length();
    }

    /**
     * Squares the given integer.
     *
     * @param i the integer to be squared.
     * @return the integer given squared.
     */
    public static int square(int i) {
        return i * i;
    }

    /**
     * Returns the sum of the squares of the integers given.
     *
     * @param i the numbers to calculate the sum of the squares of.
     * @return the sum of the squares of the integers given.
     */
    public static int sumOfSquares(int... i) {
        int total = 0;

        for (int i1 : i)
            total += square(i1);

        return total;
    }

    /**
     * Returns the sum of the squares of the natural numbers from 1 to the given length.
     *
     * @param length the number to go up to.
     * @return the sum of the squares of the natural numbers from 1 to the given length.
     */
    public static int sumOfSquares(int length) {
        int total = 0;

        for (int i = 1; i < length + 1; i++)
            total += square(i);

        return total;
    }

    /**
     * Returns the square of the sum of the integers given.
     *
     * @param i the numbers to calculate the square of the sum of.
     * @return the square of the sum of the integers given.
     */
    public static int squareOfSum(int... i) {
        int total = 0;

        for (int i1 : i)
            total += i1;

        return square(total);
    }

    /**
     * Returns the square of the sum of the natural numbers from 1 to the given length.
     *
     * @param length the number to go up to.
     * @return the square of the sum of the natural numbers from 1 to the given length.
     */
    public static int squareOfSum(int length) {
        int total = 0;

        for (int i = 1; i < length + 1; i++) {
            total += i;
        }

        return square(total);
    }

    /**
     * Calculates the difference between two integers. It will always return positive.
     *
     * @param i the first integer.
     * @param j the second integer.
     * @return the difference between the first integer and the second integer.
     */
    public static int calculateDifference(int i, int j) {
        return i > j ? i - j : j - i;
    }

    /**
     * Gets the prime number at the term specified.
     *
     * @param term the term of the prime number that you wish to get. Eg. 6 would return 13 as it is the 6th prime number.
     * @return the prime number at the term specified.
     * @throws java.lang.IllegalArgumentException if the term is less than 1. You cannot have a 0th term or a negative term.
     */
    public static int primeFromTerm(int term) {

        if (term < 1)
            throw new IllegalArgumentException("The term must be greater or equal to 1");

        int currentTerm = 0;

        for (int i = 0; true; i++) {

            if (Maths.isPrime(i)) {
                currentTerm++;

                if (currentTerm == term)
                    return i;

            } else
                continue;

        }
    }
}
