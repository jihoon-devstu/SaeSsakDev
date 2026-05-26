package ex05_interface;

public class Rectangle implements Shape {
  private double width;
  private double height;

  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public double getPerimeter() {
    return 2 * (width + height); // 사각형의 둘레 계산
  }

  @Override
  public double getArea() {
    return width * height; // 사각형의 넓이 계산
  }

}
