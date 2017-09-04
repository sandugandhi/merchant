package com.galaxy.guide.calculate;

import java.util.HashMap;
import java.util.Map;

public class Token {

  private final Map<TOKENKEY, String> map = new HashMap<>();

  public Map<TOKENKEY, String> getMap() {
    return map;
  }

  public String get(TOKENKEY tokenkey) {
    return map.get(tokenkey);
  }
}
