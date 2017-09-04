package com.galaxy.guide.calculate;

import static com.galaxy.guide.calculate.TOKENKEY.GALACTIC;
import static com.galaxy.guide.calculate.TOKENKEY.ROMAN;

import com.galaxy.guide.util.RomanNumberUtil;
import java.math.BigDecimal;

/**
 * A simple calculator for 'glob is I' kind of statements
 */
public class SimpleStatementCalculator extends AbstractCalculator implements Calculator {

  @Override
  public String calculate(Token token) {

    TOKENKEY[] tokenkeys = {ROMAN, GALACTIC};
    validate(token, tokenkeys);
    String roman = token.get(ROMAN);

    BigDecimal result = RomanNumberUtil.toDecimal(roman);

    BOOK.putInGalacticRomanDictionary(token.get(GALACTIC), roman);
    BOOK.put(token.get(GALACTIC), result);

    return result.toPlainString();
  }


}
