package com.cathe.engine;

import com.cathe.logging.Logger;
import com.cathe.math.Color;
import org.lwjgl.opengl.GL;

import java.util.logging.Level;

import static org.lwjgl.glfw.GLFW.*;

public final class Engine implements java.io.Closeable {
  private Logger logger;
  private Render render;
  private Window window;
  private Settings settings;

  public Engine( Logger logger, Settings settings ) throws RuntimeException {
    this.logger = logger;
    this.settings = settings;

    if (!glfwInit()) {
      String msg = "Failed to initialize GLFW";
      logger.log(Level.SEVERE, msg);
      throw new RuntimeException(msg);
    }

    createWindow(settings.windowWidth, settings.windowHeight, settings.windowTitle);
    window.show();
    this.render = new Render(logger, window, settings);
  }

  private void createWindow( int width, int height, String title ) throws RuntimeException {
    glfwDefaultWindowHints();                  // Optional, the current window hints are already the default
    glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);  // The window will stay hidden after creation
    glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // The window will be resizable

    window = new Window(width, height, title);
    if (!window.isInitialized()) {
      String msg = "Failed to create the GLFW window";
      logger.log(Level.SEVERE, msg);
      throw new RuntimeException(msg);
    }
    window.center();

    logger.log(Level.INFO, "Window '" + title + "', " + width + "x" + height + " was created");
  }

  public void loop() {
    GL.createCapabilities();

    render.setClearColor(settings.clearColor);

    while (window.isActive()) {
      render.startFrame();
      glfwPollEvents();
    }
  }

  void setClearColor( Color<Float> color ) {
    render.setClearColor(color);
    settings.clearColor = color;
  }

  public void stop() { window.setInactive(); }
  public void close() { window.close(); }
  public Settings getSettings() { return settings; }
}
