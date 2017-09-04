package com.galaxy.guide.strategy;

import com.galaxy.guide.interpret.CreditsStatementInterpreter;
import com.galaxy.guide.interpret.QueryInterpreter;
import com.galaxy.guide.interpret.SimpleStatementInterpreter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Check if the correct strategy is identified from the inputs
 */
public class InputLineParserTest {

  private InputLineParser inputLineParser;

  @Before
  public void beforeEveryTest() {
    inputLineParser = new InputLineParser(new TranslationContext());
  }

  @Test
  public void canInterpretValidSimpleSentence() {

    //given
    String str = "   pISh is V  . ";

    //when
    inputLineParser.execute(str);

    //then
    Assert
        .assertEquals("should be SimpleStatementInterpreter instance:",
            SimpleStatementInterpreter.class,
            inputLineParser.getContext().getInterpreter().getClass());
  }

  @Test
  public void canParseCreditsSentence() {

    //given
    String str = "  [ glob  glob  ;  Silver is   34 credits  .  ";

    //when
    inputLineParser.execute(str);

    //then
    Assert
        .assertEquals("should be CreditsStatementInterpreter instance:",
            CreditsStatementInterpreter.class,
            inputLineParser.getContext().getInterpreter().getClass());
  }

  @Test
  public void canParseSimpleQuerySentence() {

    //given
    String str = "  how much  is   glob glob ?  ";

    //when
    inputLineParser.execute(str);

    //then
    Assert
        .assertEquals("should be QueryInterpreter instance:", QueryInterpreter.class,
            inputLineParser.getContext().getInterpreter().getClass());
  }

  @Test
  public void canParseCreditsQuerySentence() {

    //given
    String str = "  HOw Many CreDits is   glob prok Silver ?  ";

    //when
    inputLineParser.execute(str);

    //then
    Assert
        .assertEquals("should be QueryInterpreter instance:", QueryInterpreter.class,
            inputLineParser.getContext().getInterpreter().getClass());
  }

}
