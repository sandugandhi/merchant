package com.galaxy.guide.strategy;

import static com.galaxy.guide.util.Constants.NO_IDEA;

import com.galaxy.guide.interpret.CreditsStatementInterpreter;
import com.galaxy.guide.interpret.QueryInterpreter;
import com.galaxy.guide.interpret.SimpleStatementInterpreter;
import com.galaxy.guide.util.Constants;
import com.galaxy.guide.util.StringUtil;

public class InputLineParser {

  private TranslationContext context;

  public InputLineParser(TranslationContext context) {
    setContext(context);
  }

  /**
   * Accepts a single string line as input and classifies it as a statement/question
   * and sets the interpreter strategy in the context and then executes it.
   */

  public String execute(String rawInput) {

    String sanitisedInput = sanitizeInput(rawInput);

    if (setContextStrategy(sanitisedInput) < 0) {
      return NO_IDEA;
    }

    try {
      return getContext().execute(sanitisedInput);
    } catch (Exception e) {
      // log the error message in the application error logs (here, it is error console)
      System.err.println(e.getMessage());
      // for client, return a standard message
      return NO_IDEA;
    }
  }

  private String sanitizeInput(String input) {
    if (StringUtil.isNullOrEmpty(input)) {
      throw new IllegalArgumentException(Constants.NULL_OR_EMPTY_LINE);
    }
    // sanitize input string. remove extra spaces, special/illegal characters
    return input.replaceAll(Constants.EXTRA_SPACE, Constants.WITH_SPACE)
        .replaceAll(Constants.EXCEPT_THESE_CHARS, Constants.EMPTY).trim();
  }

  private int setContextStrategy(String sanitisedInput) {
    String lowerSanitisedInput = sanitisedInput.toLowerCase();
    // If it is a question
    if (lowerSanitisedInput.endsWith(Constants.QUESTION) || lowerSanitisedInput
        .startsWith(Constants.HOW)) {

      if (lowerSanitisedInput.contains(Constants.CREDITS) || lowerSanitisedInput.startsWith(
          Constants.HOW_MANY)) {

        //If it is a Credit Token. For example: how many Credits is glob prok Silver ?
        context.setInterpreter(new QueryInterpreter());

      } else if (lowerSanitisedInput.startsWith(Constants.HOW_MUCH)) {

        //If Simple Token For example: how much is pish tegj glob glob ?
        context.setInterpreter(new QueryInterpreter());

      } else {
        return -1;
      }

    } else if (lowerSanitisedInput.contains(Constants.CREDITS) && !lowerSanitisedInput
        .matches(Constants.SIMPLE_PATTERN)) {

      // else if it is a Credit Statement. For example: glob prok Silver is 34 Credits
      context.setInterpreter(new CreditsStatementInterpreter());

    } else if (lowerSanitisedInput.matches(Constants.SIMPLE_PATTERN)) {

      // else if it is a Simple statement. For example: glob is I
      context.setInterpreter(new SimpleStatementInterpreter());

    } else {
      // could not classify the input string
      return -1;
    }
    return 0;
  }

  TranslationContext getContext() {
    return context;
  }

  private void setContext(TranslationContext context) {
    this.context = context;
  }
}
