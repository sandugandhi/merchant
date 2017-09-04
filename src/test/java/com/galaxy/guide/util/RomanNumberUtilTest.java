package com.galaxy.guide.util;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RomanNumberUtilTest {

  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Test
  public void canConvertValidRomanString() {
    //Given a valid roman string
    String romanStr = "mMmCMxciX";
    //when
    BigDecimal b = RomanNumberUtil.toDecimal(romanStr);
    //then
    Assert.assertEquals(b, BigDecimal.valueOf(3999L));

  }

  @Test
  public void cannotConvertInvalidRomanString() throws IllegalArgumentException {
    //Given a valid roman string
    String invalidRomanStr = "mMmCMxciL";

    //then
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage(invalidRomanStr + " is not a valid roman numeral string");

    //when
    RomanNumberUtil.toDecimal(invalidRomanStr);
  }

}
