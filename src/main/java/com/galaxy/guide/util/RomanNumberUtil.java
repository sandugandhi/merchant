package com.galaxy.guide.util;

import static com.galaxy.guide.util.Constants.INVALID_ROMAN;
import static com.galaxy.guide.util.Constants.ROMAN_PATTERN;

import java.math.BigDecimal;

/**
 * Utility class to convert given roman string into decimal values
 * Should be able to handle numbers from 1 to 4999 only.
 */
public class RomanNumberUtil {


  public static BigDecimal toDecimal(String roman) {
    String romanUpper = roman.toUpperCase();
    if (validate(romanUpper)) {
      return BigDecimal.valueOf(romanToDecimal(roman.toUpperCase()));
    } else {
      throw new IllegalArgumentException(roman + INVALID_ROMAN);
    }
  }

  private static boolean validate(String romanUpper) {
    return romanUpper.matches(ROMAN_PATTERN);
  }

  // This function returns value of a Roman symbol
  private static int value(char r) {
    if (r == 'I') {
      return 1;
    }
    if (r == 'V') {
      return 5;
    }
    if (r == 'X') {
      return 10;
    }
    if (r == 'L') {
      return 50;
    }
    if (r == 'C') {
      return 100;
    }
    if (r == 'D') {
      return 500;
    }
    if (r == 'M') {
      return 1000;
    }
    return -1;
  }

  // Finds decimal value of a given roman numeral using subtractive notation
  private static int romanToDecimal(String str) {
    // Initialize result
    int res = 0;

    for (int i = 0; i < str.length(); i++) {
      // Getting value of symbol s[i]
      int s1 = value(str.charAt(i));

      // Getting value of symbol s[i+1]
      if (i + 1 < str.length()) {
        int s2 = value(str.charAt(i + 1));

        // Comparing both values for the subtractive method
        if (s1 >= s2) {
          // Value of current symbol is greater
          // or equal to the next symbol
          res = res + s1;
        } else {
          res = res + s2 - s1;
          i++; // Value of current symbol is less than the next symbol
        }
      } else {
        res = res + s1;
        i++;
      }
    }
    return res;
  }
}
