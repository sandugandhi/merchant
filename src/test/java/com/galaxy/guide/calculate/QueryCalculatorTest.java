package com.galaxy.guide.calculate;

import static com.galaxy.guide.calculate.TOKENKEY.GALACTIC;
import static com.galaxy.guide.calculate.TOKENKEY.RAREMETALTYPE;

import com.galaxy.guide.store.GalacticTranslationBook;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class QueryCalculatorTest {

  @Test
  public void canCalculateValidSimpleQueryToken() {

    //given
    Token token = new Token();
    token.getMap().put(GALACTIC, "glob pish");
    Calculator qCalc = new QueryCalculator();
    GalacticTranslationBook BOOK = GalacticTranslationBook.getInstance();
    BOOK.putInGalacticRomanDictionary("glob", "I");
    BOOK.putInGalacticRomanDictionary("pish", "X");

    //when
    String result = qCalc.calculate(token);

    //then
    BigDecimal expectedValue = BigDecimal.valueOf(9d).setScale(0, BigDecimal.ROUND_DOWN);
    Assert.assertEquals("should match value:", expectedValue.toPlainString(), result);
  }


  @Test
  public void canCalculateValidCreditsQueryToken() {

    //given
    Token token = new Token();
    token.getMap().put(GALACTIC, "glob prok");
    token.getMap().put(RAREMETALTYPE, "Iron");
    Calculator qCalc = new QueryCalculator();
    GalacticTranslationBook BOOK = GalacticTranslationBook.getInstance();
    BOOK.putInGalacticRomanDictionary("glob", "I");
    BOOK.putInGalacticRomanDictionary("prok", "V");
    BOOK.put("Iron", BigDecimal.valueOf(5));

    //when
    String result = qCalc.calculate(token);

    //then
    BigDecimal expectedValue = BigDecimal.valueOf(20d).setScale(0, BigDecimal.ROUND_DOWN);
    Assert.assertEquals("should match :", expectedValue.toPlainString(), result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void throwsExceptionOnInvalidRomanCreditQueryToken() {
    //given
    Token token = new Token();
    token.getMap().put(GALACTIC, "sofa prok");
    token.getMap().put(RAREMETALTYPE, "Iron");
    Calculator qCalc = new QueryCalculator();
    GalacticTranslationBook BOOK = GalacticTranslationBook.getInstance();
    BOOK.putInGalacticRomanDictionary("glob", "I");
    BOOK.putInGalacticRomanDictionary("prok", "V");
    BOOK.put("Iron", BigDecimal.valueOf(5));

    //when
    qCalc.calculate(token);

    // above should throw IllegalArgumentException
  }
}
