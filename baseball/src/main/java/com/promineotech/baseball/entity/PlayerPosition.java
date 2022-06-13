package com.promineotech.baseball.entity;


public enum PlayerPosition {

  PITCHER("P"), CATCHER("C"), FIRST("1B"), SECOND("2B"), THIRD("3B"), SHORT("SS"), LEFT("LF"), CENTER("CF"), RIGHT("RF");
  private final String stringValue;
  PlayerPosition(final String s) { 
    stringValue = s; 
    }
  public String toString() { return stringValue; }
}
