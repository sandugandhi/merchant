package com.galaxy.guide.interpret;

import com.galaxy.guide.calculate.TOKENKEY;
import org.junit.Assert;
import org.junit.Test;

public class SimpleStatementInterpreterTest {

  @Test
  public void canInterpretValidSimpleStatement() {
    //given
    String rawInput = "glob is I";
    //when
    SimpleStatementInterpreter s = new SimpleStatementInterpreter();
    s.interpret(rawInput);
    //then
    Assert.assertEquals("should match galacticWord:", "glob", s.get(TOKENKEY.GALACTIC));
    Assert.assertEquals("should match romanWord:", "I", s.get(TOKENKEY.ROMAN));
  }

}
