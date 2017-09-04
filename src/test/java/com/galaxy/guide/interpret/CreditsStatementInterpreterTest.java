package com.galaxy.guide.interpret;

import static com.galaxy.guide.calculate.TOKENKEY.GALACTIC;
import static com.galaxy.guide.calculate.TOKENKEY.RAREMETALAMOUNT;
import static com.galaxy.guide.calculate.TOKENKEY.RAREMETALTYPE;

import com.galaxy.guide.store.GalacticTranslationBook;
import org.junit.Assert;
import org.junit.Test;

public class CreditsStatementInterpreterTest {

  @Test
  public void canInterpretValidCreditStatement() {
    //given
    GalacticTranslationBook BOOK = GalacticTranslationBook.getInstance();
    BOOK.putInGalacticRomanDictionary("glob", "I");
    BOOK.putInGalacticRomanDictionary("tgdf", "C");

    String rawInput = "glob tgdf Platinum is 40 Credits";
    //when
    CreditsStatementInterpreter s = new CreditsStatementInterpreter();
    s.interpret(rawInput);
    //then
    Assert.assertEquals("should match galactic words:", "glob tgdf", s.get(GALACTIC));
    Assert.assertEquals("should match rareMetalType:", "Platinum", s.get(RAREMETALTYPE));
    Assert.assertEquals("should match Amount:", "40", s.get(RAREMETALAMOUNT));
  }

}
