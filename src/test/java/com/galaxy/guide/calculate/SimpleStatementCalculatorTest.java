package com.galaxy.guide.calculate;

import static com.galaxy.guide.calculate.TOKENKEY.GALACTIC;
import static com.galaxy.guide.calculate.TOKENKEY.ROMAN;

import com.galaxy.guide.store.GalacticTranslationBook;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class SimpleStatementCalculatorTest {

  @Test
  public void canCalculateValidSimpleStatementTest() {
    //given
    Token token = new Token();
    token.getMap().put(GALACTIC, "tegj");
    token.getMap().put(ROMAN, "L");
    Calculator sCalc = new SimpleStatementCalculator();
    GalacticTranslationBook BOOK = GalacticTranslationBook.getInstance();

    //when
    sCalc.calculate(token);

    //then
    BigDecimal expectedValue = BigDecimal.valueOf(50).setScale(0, BigDecimal.ROUND_DOWN);
    Assert.assertEquals("should match roman value of tegj=L", "L",
        BOOK.getFromGalacticRomanDictionary("tegj"));
    Assert.assertEquals("should match decimal value of tegj=50", expectedValue, BOOK.get("tegj"));
  }

}
