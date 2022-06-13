package com.promineotech.baseball.entity;


public enum PAResult {

  OUT("O"), Single("1B"), DOUBLE("2B"), TRIPLE("3B"), HOME_RUN("HR");
  private final String stringValue;
  PAResult(final String s) { 
    stringValue = s; 
    }
  public String toString() { return stringValue; }
}
