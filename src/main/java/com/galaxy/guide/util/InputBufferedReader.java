package com.galaxy.guide.util;

import static com.galaxy.guide.util.Constants.NULL_OR_EMPTY_FILEPATH;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class to handle reading {@link java.io.BufferedReader} wrapped input streams
 */
public class InputBufferedReader {

  public static List<String> toLines(String filePath) throws IOException {
    if (StringUtil.isNullOrEmpty(filePath)) {
      throw new IllegalArgumentException(NULL_OR_EMPTY_FILEPATH);
    }

    List<String> lines;

    try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {

      //br returns as stream and convert it into a List
      lines = br.lines().filter(str -> !StringUtil.isNullOrEmpty(str)).collect(Collectors.toList());
    }
    return lines;
  }
}
