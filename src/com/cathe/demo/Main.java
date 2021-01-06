package com.cathe.demo;

import com.cathe.engine.Engine;
import com.cathe.engine.RuntimeException;
import com.cathe.engine.Settings;
import com.cathe.logging.CopyFormatter;
import com.cathe.logging.Logger;
import com.cathe.math.Color;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class Main {
  public static void main( String[] Args ) {
    try {
      Logger logger = new Logger(Main.class.getName() + ".logger", Level.FINE);
      logger.addHandler(new FileHandler("logs/com.cathe.demo.log"), new CopyFormatter());
      logger.log(Level.INFO, "Program start");

      Settings settings = new Settings();
      settings.clearColor = new Color<>(0.3f, 0.5f, 0.7f, 1.0f);
      settings.windowWidth = 1024;
      settings.windowHeight = 512;
      settings.windowTitle = "DEMO";

      try (Engine engine = new Engine(logger, settings);) {
        engine.loop();
      } catch (RuntimeException e) {
        logger.log(Level.SEVERE, "Runtime exception encountered, terminating!");
      }

      logger.log(Level.INFO, "Program end");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
