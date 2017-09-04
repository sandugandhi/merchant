package com.galaxy.guide.store;


import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class GalacticTranslationBookTest {

  @Test
  public void canPutAndGetThem() {
    //given
    GalacticTranslationBook galacticTranslationBook = GalacticTranslationBook.getInstance();
    //when
    galacticTranslationBook.put("some_key", BigDecimal.ZERO);
    //then
    Assert.assertEquals(galacticTranslationBook.get("some_key"), BigDecimal.ZERO);
  }

  @Test
  public void canPutInGalacticRomanDictionaryAndGetThem() {
    //given
    GalacticTranslationBook galacticTranslationBook = GalacticTranslationBook.getInstance();
    //when
    galacticTranslationBook.putInGalacticRomanDictionary("some_key", "some_value");
    //then
    Assert.assertEquals(galacticTranslationBook.getFromGalacticRomanDictionary("some_key"),
        "some_value");
  }
}
