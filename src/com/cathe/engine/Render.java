package com.cathe.engine;

import com.cathe.logging.Logger;
import com.cathe.math.Color;

import java.util.logging.Level;

import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.opengl.GL11.*;

final class Render {
  private Logger logger;
  private Settings settings;
  private Window window;

  Render( Logger logger, Window window, Settings settings ) {
    this.logger = logger;
    this.window = window;
    this.settings = settings;

    window.makeContextCurrent();
    setVSync(settings.vSync);
  }

  void startFrame() {
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    window.swapBuffers();
    logger.log(Level.FINEST, "Frame start");
  }

  void setClearColor( Color<Float> color ) {
    glClearColor(color.r, color.g, color.b, color.a);
    settings.clearColor = color;
    logger.log(Level.FINE, "Set clear color: " + color);
  }

  void setVSync( boolean state ) {
    if (state) {
      // Enable
      glfwSwapInterval(1);
      logger.log(Level.FINE, "Toggle V-Sync on");
    } else {
      // Disable
      glfwSwapInterval(0);
      logger.log(Level.FINE, "Toggle V-Sync off");
    }
  }
}
