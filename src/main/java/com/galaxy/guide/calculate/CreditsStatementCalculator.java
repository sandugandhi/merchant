package com.galaxy.guide.calculate;

import static com.galaxy.guide.calculate.TOKENKEY.GALACTIC;
import static com.galaxy.guide.calculate.TOKENKEY.RAREMETALAMOUNT;
import static com.galaxy.guide.calculate.TOKENKEY.RAREMETALTYPE;

import com.galaxy.guide.util.RomanNumberUtil;
import java.math.BigDecimal;

/**
 * Concrete calculator for Credit type statement i.e. 'glob glob Silver is 34 Credits'
 */
public class CreditsStatementCalculator extends AbstractCalculator implements Calculator {

  @Override
  public String calculate(Token token) {

    TOKENKEY[] tokenkeys = {GALACTIC, RAREMETALAMOUNT, RAREMETALTYPE};
    validate(token, tokenkeys);

    BigDecimal romanValue = RomanNumberUtil.toDecimal(extractRomanString(token));

    BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(token.get(RAREMETALAMOUNT)));
    BigDecimal result = amount.divide(romanValue, 3, BigDecimal.ROUND_DOWN);

    // store the rare metal rate
    BOOK.put(token.get(RAREMETALTYPE), result);

    return result.toPlainString();
  }
}
