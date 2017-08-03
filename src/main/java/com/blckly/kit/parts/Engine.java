package com.blckly.kit.parts;

public class Engine {

  private static String DEFAULT_ENGINE_NAME = "defaultEngine";

  private String name;

  public Engine(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
