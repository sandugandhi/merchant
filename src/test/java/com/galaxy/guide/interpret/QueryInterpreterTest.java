package com.galaxy.guide.interpret;

import static com.galaxy.guide.calculate.TOKENKEY.GALACTIC;
import static com.galaxy.guide.calculate.TOKENKEY.RAREMETALTYPE;

import com.galaxy.guide.util.Constants;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class QueryInterpreterTest {

  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Test
  public void canInterpretValidSimpleQuery() {

    //given
    String rawInput = "  how much is glob prok?";
    QueryInterpreter s = new QueryInterpreter();

    //when
    s.interpret(rawInput);

    //then
    Assert.assertEquals("should match galactic words:", "glob prok", s.get(GALACTIC));
    Assert.assertEquals("should match subject:", "glob prok", s.getSubject());
  }

  @Test
  public void cannotInterpretInValidSimpleQuery() throws IllegalArgumentException {

    //given
    String rawInput = "  how much is wood chuck chuck if wood chuck is to chuck wood?";
    QueryInterpreter s = new QueryInterpreter();

    //then
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage(Constants.NULL_OR_EMPTY_LINE);

    //when
    s.interpret(rawInput);
  }


  @Test
  public void canInterpretValidCreditsQuery() {
    //given
    String rawInput = "  how many Credits is glob prok Iron?";
    //when
    QueryInterpreter s = new QueryInterpreter();
    s.interpret(rawInput);
    //then
    Assert.assertEquals("should match galactic words:", "glob prok", s.get(GALACTIC));
    Assert.assertEquals("should match rareMetalType:", "Iron", s.get(RAREMETALTYPE));
    Assert.assertEquals("should match subject:", "glob prok Iron", s.getSubject());
  }

  @Test
  public void cannotInterpretInValidCreditsQuery1() throws IllegalArgumentException {

    //given
    String rawInput = "  how many Credits is ? ";
    QueryInterpreter s = new QueryInterpreter();

    //then
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage(Constants.NULL_OR_EMPTY_LINE);

    //when
    s.interpret(rawInput);
  }

  @Test
  public void cannotInterpretInValidCreditsQuery2() throws IllegalArgumentException {

    //given
    String rawInput = "  how many Credits is glob ? ";
    QueryInterpreter s = new QueryInterpreter();

    //then
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage(Constants.NULL_OR_EMPTY_LINE);

    //when
    s.interpret(rawInput);
  }
}

