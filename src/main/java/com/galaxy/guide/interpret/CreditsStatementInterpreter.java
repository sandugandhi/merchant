package com.galaxy.guide.interpret;

import static com.galaxy.guide.calculate.TOKENKEY.GALACTIC;
import static com.galaxy.guide.calculate.TOKENKEY.RAREMETALAMOUNT;
import static com.galaxy.guide.calculate.TOKENKEY.RAREMETALTYPE;
import static com.galaxy.guide.util.Constants.NULL_OR_EMPTY_LINE;
import static com.galaxy.guide.util.Constants.WITH_SPACE;

import com.galaxy.guide.calculate.CreditsStatementCalculator;
import com.galaxy.guide.util.Constants;
import com.galaxy.guide.util.StringUtil;

/**
 * Concrete interpreter for Credit type statement i.e. 'glob glob Silver is 34 Credits'
 */
public class CreditsStatementInterpreter extends AbstractInterpreter implements Interpreter {

  @Override
  public String execute(String input) {
    this.interpret(input);
    setCalculator(new CreditsStatementCalculator());
    getCalculator().calculate(getToken());
    return null;
  }

  @Override
  protected void interpret(String inputString) {
    String[] arr = inputString.split(Constants.IS_WORD);
    if (arr.length != 2 || StringUtil.isNullOrEmpty(arr[0]) || StringUtil.isNullOrEmpty(arr[1])) {
      throw new IllegalArgumentException(NULL_OR_EMPTY_LINE);
    }
    this.setSubject(arr[0]);
    this.setPredicate(arr[1]);
    int space_end = getSubject().lastIndexOf(WITH_SPACE);
    int first_space = getPredicate().indexOf(WITH_SPACE);
    if (first_space < 0 || space_end < 0) {
      throw new IllegalArgumentException(NULL_OR_EMPTY_LINE);
    }

    put(RAREMETALTYPE, getSubject().substring(space_end + 1));
    put(GALACTIC, getSubject().substring(0, space_end));
    put(RAREMETALAMOUNT, getPredicate().substring(0, first_space));
  }
}
