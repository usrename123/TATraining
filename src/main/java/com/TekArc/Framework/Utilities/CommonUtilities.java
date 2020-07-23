package com.TekArc.Framework.Utilities;

import java.io.FileInputStream;
import java.util.Properties;



public class CommonUtilities {
    static Properties props = new Properties();
   static FileInputStream fileIn = null;

  public static void loadPropertyFiles(String propPath) throws Exception {
    CommonUtilities.fileIn = new FileInputStream(propPath);
    System.out.println(System.getProperty(propPath));
    
    props.load(fileIn);
    System.getProperties().putAll(props);
  }
 
    
}