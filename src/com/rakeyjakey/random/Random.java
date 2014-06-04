package com.rakeyjakey.random;

import com.rakeyjakey.maths.Maths;

import java.util.ArrayList;
import java.util.Arrays;
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

public class Random {

    private final static java.util.Random random = new java.util.Random();

    private Random() {
        //To prevent instantiation.
    }

    /**
     * @param low  The low bound of the random integer. (inclusive)
     * @param high The high bound of the random integer. (exclusive)
     * @return Returns a random integer between low (inclusive) and high
     * (exclusive).
     * @throws IllegalArgumentException if the high bound is less than the low bound.
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
     * @param digits The number of digits you wish the random number to have.
     * @return Returns a random number with the specified amount of digits.
     * @throws IllegalArgumentException if digits less than or equal to 0.
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
     * @param length the length in characters you want the random String to be.
     * @return a random String of specified length.
     */
    public static String nextString(int length) {
        StringBuilder s = new StringBuilder();

        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "u", "x", "y", "z"};

        for (int i = 0; i < length; i++) {
            s.append(alphabet[nextInt(0, alphabet.length)]);
        }

        return s.toString();
    }

    /**
     * @param length  the length in characters you want the random String to be.
     * @param exclude any characters that you wish to exclude.
     * @return a random String of specified length.
     */
    public static String nextString(int length, String... exclude) {

        StringBuilder s = new StringBuilder();

        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "u", "x", "y", "z"};

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
