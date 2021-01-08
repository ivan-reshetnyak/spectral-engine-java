package com.cathe.engine;

import static org.lwjgl.glfw.GLFW.glfwGetTime;

public class Timer {
  private double
          globalTime, globalDeltaTime,
          time, deltaTime;
  private boolean paused;

  public Timer() {
    globalTime = glfwGetTime();
    time = globalTime;
    globalDeltaTime = 0;
    deltaTime = 0;
  }

  public void update() {
    double curTime = glfwGetTime();
    globalDeltaTime = curTime - globalTime;
    globalTime = curTime;

    deltaTime = isPaused() ? 0 : globalDeltaTime;
    time += deltaTime;
  }

  public void pause() { paused = true; }
  public void unpause() { paused = false; }

  public boolean isPaused() { return paused; }
  public double getGlobalTime() { return globalTime; }
  public double getGlobalDeltaTime() { return globalDeltaTime; }
  public double getTime() { return time; }
  public double getDeltaTime() { return deltaTime; }
}
