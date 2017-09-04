package com.galaxy.guide.calculate;

import static com.galaxy.guide.calculate.TOKENKEY.GALACTIC;
import static com.galaxy.guide.calculate.TOKENKEY.RAREMETALTYPE;

import com.galaxy.guide.util.RomanNumberUtil;
import com.galaxy.guide.util.StringUtil;
import java.math.BigDecimal;

/**
 * Encapsulates the implementation of the computation logic for a token
 */
public class QueryCalculator extends AbstractCalculator implements Calculator {

  @Override
  public String calculate(Token token) {
    TOKENKEY[] tokenkeys = {GALACTIC};
    validate(token, tokenkeys);
    BigDecimal result1 = RomanNumberUtil.toDecimal(extractRomanString(token));

    String rareMetal = token.get(RAREMETALTYPE);
    if (!(StringUtil.isNullOrEmpty(rareMetal))) {
      BigDecimal rate = BOOK.get(rareMetal);
      BigDecimal result2 = rate.multiply(result1).setScale(0, BigDecimal.ROUND_DOWN);
      return result2.toPlainString();
    }
    return result1.toPlainString();
  }
}
