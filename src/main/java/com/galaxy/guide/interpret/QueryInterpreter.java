package com.galaxy.guide.interpret;

import static com.galaxy.guide.calculate.TOKENKEY.GALACTIC;
import static com.galaxy.guide.calculate.TOKENKEY.RAREMETALTYPE;
import static com.galaxy.guide.util.Constants.CREDITS;
import static com.galaxy.guide.util.Constants.IS_WORD;
import static com.galaxy.guide.util.Constants.NULL_OR_EMPTY_LINE;
import static com.galaxy.guide.util.Constants.WITH_SPACE;

import com.galaxy.guide.calculate.QueryCalculator;
import com.galaxy.guide.util.Constants;
import com.galaxy.guide.util.StringUtil;

/**
 * Concrete implementor for interpreting question
 * For example: 'how many Credits is glob prok Silver ? '
 * For example: how much is pish tegj glob glob ?'
 */
public class QueryInterpreter extends AbstractInterpreter implements Interpreter {

  @Override
  protected void interpret(String input) {
    String noQuery = input.replaceAll(Constants.QUESTION, "").trim();
    String arr[] = noQuery.split(IS_WORD);
    if (arr.length != 2 || StringUtil.isNullOrEmpty(arr[0]) || StringUtil.isNullOrEmpty(arr[1])) {
      throw new IllegalArgumentException(NULL_OR_EMPTY_LINE);
    }

    this.setSubject(arr[1]);

    if (noQuery.toLowerCase().contains(CREDITS)) {
      int spacend = getSubject().lastIndexOf(WITH_SPACE);
      if (spacend < 0) {
        throw new IllegalArgumentException(NULL_OR_EMPTY_LINE);
      }
      put(GALACTIC, getSubject().substring(0, spacend));
      put(RAREMETALTYPE, getSubject().substring(spacend + 1));
      spacend = arr[0].lastIndexOf(WITH_SPACE);
      if (spacend < 0) {
        throw new IllegalArgumentException(NULL_OR_EMPTY_LINE);
      }
      this.setPredicate(arr[0].substring(spacend + 1));
    } else {
      put(GALACTIC, getSubject());
    }
  }

  @Override
  public String execute(String input) {
    this.interpret(input);
    setCalculator(new QueryCalculator());
    setPredicate(getCalculator().calculate(getToken()));
    return this.getSubject() + IS_WORD + this.getPredicate();
  }
}
