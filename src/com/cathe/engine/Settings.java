package com.cathe.engine;

import com.cathe.math.Color;

public class Settings {
  public Color<Float> clearColor = new Color<>(0.3f, 0.5f, 0.7f, 1.0f);
  public int windowWidth = 1366, windowHeight = 768;
  public String windowTitle = "Window";
  public boolean vSync = false;
}
