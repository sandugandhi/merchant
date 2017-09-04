package com.galaxy.guide.interpret;

import static com.galaxy.guide.calculate.TOKENKEY.GALACTIC;
import static com.galaxy.guide.calculate.TOKENKEY.ROMAN;
import static com.galaxy.guide.util.Constants.NULL_OR_EMPTY_LINE;

import com.galaxy.guide.calculate.SimpleStatementCalculator;
import com.galaxy.guide.util.Constants;
import com.galaxy.guide.util.StringUtil;

public class SimpleStatementInterpreter extends AbstractInterpreter implements Interpreter {

  @Override
  public String execute(String input) {
    this.interpret(input);
    setCalculator(new SimpleStatementCalculator());
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

    put(GALACTIC, getSubject());
    put(ROMAN, getPredicate());
  }
}
