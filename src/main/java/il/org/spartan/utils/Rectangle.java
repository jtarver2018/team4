package il.org.spartan.utils;

public class Rectangle {
  private final double y1;
  private double y2;
  private final double x1;
  private double x2;
  private double prevX2;

  public Rectangle(final double x1, final double y1, final double x2, final double y2) {
    this.y1 = y1;
    this.y2 = y2;
    this.x1 = x1;
    prevX2 = this.x2 = x2;
  }

  public double getLen() {
    return y2 > y1 ? y2 - y1 : y1 - y2;
  }

  public double getWidth() {
    return x2 > x1 ? x2 - x1 : x1 - x2;
  }

  public double perimeter() {
    return 2 * (getLen() + getWidth());
  }

  public double area() {
    return getLen() * getWidth();
  }

  public double getX1() {
    return this.x1;
  }

  public double getY1() {
    return this.y1;
  }

  public double getX2() {
    return this.x2;
  }

  public double getY2() {
    return this.y2;
  }

  // rotating around x1,y1 90 degrees left
  public Rectangle rotation() {
    x2 = x1 + y1 - y2;
    y2 = y1 + prevX2 - x1;
    prevX2 = x2;
    return this;
  }
}
