package com.galaxy.guide.calculate;

import static com.galaxy.guide.calculate.TOKENKEY.GALACTIC;
import static com.galaxy.guide.util.Constants.NOT_FOUND;
import static com.galaxy.guide.util.Constants.NULL_OR_EMPTY_LINE;
import static com.galaxy.guide.util.Constants.WITH_SPACE;

import com.galaxy.guide.util.StringUtil;

abstract class AbstractCalculator implements Calculator {

  String extractRomanString(Token token) {

    StringBuilder roman = new StringBuilder();
    String galactic = token.get(GALACTIC);
    String[] galacticArray = galactic.split(WITH_SPACE);

    for (String s : galacticArray) {
      String r = BOOK.getFromGalacticRomanDictionary(s);
      if (StringUtil.isNullOrEmpty(r)) {
        throw new IllegalArgumentException(s + NOT_FOUND);
      }
      roman.append(r);
    }
    return roman.toString();
  }

  protected void validate(Token token, TOKENKEY[] tokenkeys) {
    if (token == null) {
      throw new IllegalArgumentException(NULL_OR_EMPTY_LINE);
    }
    for (TOKENKEY tokenKey : tokenkeys) {
      if (StringUtil.isNullOrEmpty(token.get(tokenKey))) {
        throw new IllegalArgumentException(NULL_OR_EMPTY_LINE);
      }
    }
  }
}
