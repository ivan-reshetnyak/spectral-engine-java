package com.cathe.engine;

import org.lwjgl.glfw.GLFWVidMode;

import static org.lwjgl.glfw.GLFW.*;

final class Window implements java.io.Closeable {
  private long handle;
  private int width, height;

  Window( int width, int height, String title ) {
    this.width = width;
    this.height = height;

    handle = glfwCreateWindow(width, height, title, 0, 0);
  }

  public void close() {
    if (handle != 0)
      glfwDestroyWindow(handle);
  }

  void center() {
    GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
    glfwSetWindowPos(handle, (vidmode.width() - width) / 2, (vidmode.height() - height) / 2);
  }

  int getWidth() { return width; }
  int getHeight() { return height; }
  boolean isInitialized() { return handle != 0; }
  boolean isActive() { return !glfwWindowShouldClose(handle); }
  void show() { glfwShowWindow(handle); }
  void hide() { glfwHideWindow(handle); }
  void setActive( boolean state ) { glfwSetWindowShouldClose(handle, !state); }
  void setActive() { glfwSetWindowShouldClose(handle, false); }
  void setInactive() { glfwSetWindowShouldClose(handle, true); }
  void swapBuffers() { glfwSwapBuffers(handle); }
  void makeContextCurrent() { glfwMakeContextCurrent(handle); }
}
