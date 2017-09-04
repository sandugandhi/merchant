package com.galaxy.guide.strategy;

import com.galaxy.guide.interpret.Interpreter;

/**
 * The translation context holds an interpreter strategy {@link Interpreter} object and executes it
 */
public class TranslationContext {

  private Interpreter interpreter;

  public TranslationContext() {
  }

  String execute(String string) {
    return interpreter.execute(string);
  }

  public Interpreter getInterpreter() {
    return interpreter;
  }

  public void setInterpreter(Interpreter interpreter) {
    this.interpreter = interpreter;
  }
}
