package com.TekArc.Framework.Utilities;

public class constants {
  public final int WAIT_COMMON = 5;

  public String getAppURL() throws Exception {
    String environmentFromConfig = System.getProperty("Environment").toLowerCase().trim();
    if (environmentFromConfig.startsWith("qa"))
      return "https://login.salesforce.com";

    else if (environmentFromConfig.startsWith("dev"))
      return "https://dev-tekarch.firebaseapp.com/";

    else if (environmentFromConfig.startsWith("prd"))
      return "https://prd-tekarch.firebaseapp.com/";

    else {
      return "set environment correctly...";
    }
  }
}
