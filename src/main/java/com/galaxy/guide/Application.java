package com.galaxy.guide;

import static com.galaxy.guide.util.Constants.TEST_INPUT_FILENAME;

import com.galaxy.guide.strategy.InputLineParser;
import com.galaxy.guide.strategy.TranslationContext;
import com.galaxy.guide.util.InputBufferedReader;
import com.galaxy.guide.util.StringUtil;
import java.io.IOException;
import java.util.List;

/**
 * Application with main method Problem: Merchant's Guide to the Galaxy
 *
 * Solution Notes:
 *
 * The translation context sets the appropriate strategy to execute based upon classification of the
 * input viz.
 *
 * <ol>
 *   <li>Simple Statement: For example: glob is I</>
 *   <li>Credits Statement: For example: glob glob is 34 Silver Credits.</>
 *   <li>Query: For example: how much is glob glob ?</>
 *   <li>Query: For example: how many credits is glob glob Silver ?</>
 * </ol>
 *
 * The steps involved in the processing of each input line are:
 *
 * <ol>
 *   <li>The interpretation logic (encapsulated in {@link com.galaxy.guide.interpret.Interpreter})</>
 *   <li>Further computation on interpreted input. ({@link com.galaxy.guide.calculate.Calculator})</>
 *   <li>Storing the computed result into a dictionary. ({@link com.galaxy.guide.store.GalacticTranslationBook})</>
 * <li>Using the dictionary to compute the result for query</>
 * </ol>
 *
 * Implementation Constraints:
 * <ol>
 *   <li>Depends upon " is " in the input for tokenizing</>
 *   <li>Depends upon " Credits" for classifying the 'Credits' type of input statement or query</>
 * </ol>
 *  */
class Application {

  private static void printResultIfNotNull(String result) {
    if (!StringUtil.isNullOrEmpty(result)) {
      System.out.println(result);
    }
  }

  public static void main(String[] args) throws IOException {

    //default input will be file input if no arguments are provided
    String filePath = TEST_INPUT_FILENAME;
    if (args != null && args.length != 0) {
      filePath = args[0];
    }

    List<String> lines = InputBufferedReader.toLines(filePath);

    InputLineParser inputLineParser = new InputLineParser(new TranslationContext());

    for (String line : lines) {
      String result = inputLineParser.execute(line);
      printResultIfNotNull(result);
    }
  }
}
