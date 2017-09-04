package com.galaxy.guide.util;


import static com.galaxy.guide.util.Constants.EMPTY;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class InputBufferedReaderTest {

  @Test
  public void testValidInputFileIsRead() throws IOException {

    //given
    String filePath = "input.txt";

    //when
    List<String> lines = InputBufferedReader.toLines(filePath);

    //then
    Assert.assertEquals("given sample input file returns 12 lines:", 12, lines.size());
  }


  @Test(expected = IllegalArgumentException.class)
  public void testIfInputFileIsNotPassedThenThrowException() throws IOException {

    //when
    InputBufferedReader.toLines(null);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfInputFileIsEmptyThenThrowException() throws IOException {

    //when
    InputBufferedReader.toLines(EMPTY);

  }

  @Test(expected = NoSuchFileException.class)
  public void testNonExistentFileThrowsException() throws IOException {

    //given
    String filePath = "some non existent file";

    //when
    InputBufferedReader.toLines(filePath);
  }

}
