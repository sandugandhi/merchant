package com.galaxy.guide.interpret;

import com.galaxy.guide.calculate.Calculator;
import com.galaxy.guide.calculate.TOKENKEY;
import com.galaxy.guide.calculate.Token;

/**
 * Abstract interpreter with defaults for
 * Depends upon an implementation of {@link Calculator} interface to do the computation to find the
 * answer (predicate) to a query
 */
public abstract class AbstractInterpreter implements Interpreter {

  private final Token token = new Token();
  private String subject;
  private String predicate;
  private Calculator calculator;

  protected void interpret(String input){}

  protected Calculator getCalculator() {
    return calculator;
  }

  protected void setCalculator(Calculator c) {
    this.calculator = c;
  }

  protected String getSubject() {
    return this.subject;
  }

  protected void setSubject(String subject) {
    this.subject = subject;
  }

  protected String getPredicate() {
    return this.predicate;
  }

  protected void setPredicate(String predicate) {
    this.predicate = predicate;
  }

  protected void put(TOKENKEY tokenkey, String value) {
    token.getMap().put(tokenkey, value);
  }

  protected String get(TOKENKEY tokenkey) {
    return token.getMap().get(tokenkey);
  }

  protected Token getToken() {
    return token;
  }

}
