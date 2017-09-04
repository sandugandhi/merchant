package com.galaxy.guide.calculate;

import static com.galaxy.guide.calculate.TOKENKEY.GALACTIC;
import static com.galaxy.guide.calculate.TOKENKEY.RAREMETALAMOUNT;
import static com.galaxy.guide.calculate.TOKENKEY.RAREMETALTYPE;

import com.galaxy.guide.store.GalacticTranslationBook;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class CreditsStatementCalculatorTest {

  @Test
  public void canCalculateValidCreditsStatement() {
    //given
    Token token = new Token();
    token.getMap().put(GALACTIC, "glob glob");
    token.getMap().put(RAREMETALTYPE, "Silver");
    token.getMap().put(RAREMETALAMOUNT, "34");
    Calculator qCalc = new CreditsStatementCalculator();
    GalacticTranslationBook BOOK = GalacticTranslationBook.getInstance();
    BOOK.putInGalacticRomanDictionary("glob", "I");
    //BOOK.put("glob", BigDecimal.ONE);
    //BOOK.put("Silver", BigDecimal.valueOf(17));

    //when
    qCalc.calculate(token);

    //then
    BigDecimal expectedValue = BigDecimal.valueOf(17.000d).setScale(3, BigDecimal.ROUND_DOWN);
    Assert.assertEquals("should match rate of Silver:", expectedValue, BOOK.get("Silver"));
  }
}
