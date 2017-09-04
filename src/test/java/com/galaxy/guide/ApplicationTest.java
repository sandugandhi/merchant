package com.galaxy.guide;

import static com.galaxy.guide.util.Constants.EMPTY;
import static com.galaxy.guide.util.Constants.TEST_INPUT_FILENAME;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.NoSuchFileException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is an integration test done using JUnit
 * (Due to the constraint on using library dependencies, so actual method calls are being called
 * instead of a mock. The end-to-end flow needs to be tested anyways.)
 */
public class ApplicationTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @After
  public void cleanUpStreams() {
    System.setOut(null);
    System.setErr(null);
  }

  @Test
  public void testMainSuccess() throws IOException {

    //given
    String[] args = {TEST_INPUT_FILENAME};
    //when
    Application.main(args);

    //then
    //On windows, CRLF
    //On Linux/Mac, LF
    String crlf = EMPTY + "\n";
    if (System.getProperty("os.name").contains("indows")) {
      crlf = "\r" + "\n";
    }

    StringBuilder sb = new StringBuilder();
    sb.append("pish tegj glob glob is 42");
    sb.append(crlf);
    sb.append("glob prok Silver is 68");
    sb.append(crlf);
    sb.append("glob prok Gold is 57800");
    sb.append(crlf);
    sb.append("glob prok Iron is 782");
    sb.append(crlf);
    sb.append("I have no idea what you are talking about");
    sb.append(crlf);

    Assert.assertEquals("output matches the result of input.txt", sb.toString(),
        outContent.toString());
  }

  @Test(expected = NoSuchFileException.class)
  public void testMainFileNotFound() throws IOException {
    //given
    String[] args = {"nonexisitentfile"};
    // expect an exception

    //when
    Application.main(args);
  }

}
