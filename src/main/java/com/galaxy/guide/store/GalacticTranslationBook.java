package com.galaxy.guide.store;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * An object of this singleton class will hold
 *
 * 1) the key-value priceDictionary where
 * key is the galactic word/object in the remote planet's language
 * value is the decimal equivalent value for the key in earth's language
 *
 * 2) the intermediate galactic-roman dictionary where
 * key is the galactic word
 * value is the roman numeral string
 */
public class GalacticTranslationBook {

  // contains the price of one
  private final Map<String, BigDecimal> priceDictionary = new HashMap<>();
  private final Map<String, String> galacticRomanDictionary = new HashMap<>();

  //private constructor
  private GalacticTranslationBook() {
  }

  // used to get this instance
  public static GalacticTranslationBook getInstance() {
    return SingletonHelper.INSTANCE;
  }

  public void put(String key, BigDecimal value) {
    this.priceDictionary.put(key, value);
  }

  public BigDecimal get(String key) {
    return this.priceDictionary.get(key);
  }

  public void putInGalacticRomanDictionary(String key, String value) {
    this.galacticRomanDictionary.put(key, value);
  }

  public String getFromGalacticRomanDictionary(String key) {
    return this.galacticRomanDictionary.get(key);
  }

  // singleton helper to create the instance the first time it is called.
  private static class SingletonHelper {

    private static final GalacticTranslationBook INSTANCE = new GalacticTranslationBook();
  }
}
