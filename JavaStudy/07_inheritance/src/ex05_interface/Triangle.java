package ex05_interface;

public class Triangle implements Shape {
  private double width;
  private double height;

  public Triangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public double getPerimeter() {
    // 직각 삼각형을 가정하여 둘레 계산 (밑변 + 높이 + 빗변)
    double hypotenuse = Math.sqrt(width * width + height * height);
    return width + height + hypotenuse;
  }

  @Override
  public double getArea() {
    // 삼각형의 넓이 계산 (밑변 * 높이 / 2)
    return (width * height) / 2.0;
  }

}
