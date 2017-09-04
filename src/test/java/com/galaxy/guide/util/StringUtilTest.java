package com.galaxy.guide.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

  @Test
  public void testNullString() {

    //given
    String nullStr = null;

    //when
    boolean result = StringUtil.isNullOrEmpty(nullStr);

    //then
    Assert.assertTrue(result);
  }

  @Test
  public void testEmptyString() {

    //given
    String emptyStr = "";

    //when
    boolean result = StringUtil.isNullOrEmpty(emptyStr);

    //then
    Assert.assertTrue(result);
  }

  @Test
  public void testNotEmptyString() {

    //given
    String notEmptyStr = "s";

    //when
    boolean result = StringUtil.isNullOrEmpty(notEmptyStr);

    //then
    Assert.assertFalse(result);
  }

}
