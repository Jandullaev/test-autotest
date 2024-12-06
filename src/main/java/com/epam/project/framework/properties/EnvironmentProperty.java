package com.epam.project.framework.properties;

import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class EnvironmentProperty {
  private static String env;

  static {
    setEnv();
  }

  private EnvironmentProperty() {
  }

  public static void setEnv() {
      env = EnvironmentPropertyConst.dev;
  }

  public static String getEnv() {
    return env;
  }
}
