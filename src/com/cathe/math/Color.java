package com.cathe.math;

public class Color<Type> {
  public Type r, g, b, a;

  public Color( Type r, Type g, Type b, Type a ) {
    this.r = r;
    this.g = g;
    this.b = b;
    this.a = a;
  }

  public Color( Color<Type> other ) {
    this.r = other.r;
    this.g = other.g;
    this.b = other.b;
    this.a = other.a;
  }

  @Override
  public String toString() {
    return "(" + r + ", " + g + ", " + b + ", " + a + ")";
  }
}
