package com.cathe.demo;

import com.cathe.logging.CopyFormatter;
import com.cathe.logging.Logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class Main {
  public static void main( String[] Args ) {
    try {
      Logger logger = new Logger(Main.class.getName() + ".logger", Level.FINEST);
      logger.addHandler(new FileHandler("logs/com.cathe.demo.log"), new CopyFormatter());

      logger.log(Level.INFO, "Program start");
      logger.log(Level.INFO, "Program end");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
