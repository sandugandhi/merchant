package com.galaxy.guide.util;

public class StringUtil {

  public static boolean isNullOrEmpty(final String str) {
    return (null == str || str.trim().length() == 0);
  }
}
