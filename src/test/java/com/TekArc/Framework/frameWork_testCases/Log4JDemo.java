package com.TekArc.Framework.frameWork_testCases;

import com.TekArc.Framework.Utilities.TestBase;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Log4JDemo extends TestBase {
  Logger log = Logger.getLogger(getClass().getSimpleName());

  @Test
  public void TC1() {
    log.trace("My custom Message");
    log.debug("My custom Message");
    log.info("My custom Message");

    log.error("My custom Message");

    System.out.println("My custom Message");
  }
}