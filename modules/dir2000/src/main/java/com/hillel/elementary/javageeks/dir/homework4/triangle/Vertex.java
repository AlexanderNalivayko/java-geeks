package com.hillel.elementary.javageeks.dir.homework4.triangle;

import java.util.Objects;

public class Vertex {
  private int x;
  private int y;

  Vertex(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "Vertex{" +
            "x=" + x +
            ", y=" + y +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vertex vertex = (Vertex) o;
    return x == vertex.x &&
            y == vertex.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }
}
