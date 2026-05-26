package ex05_interface;

public class Circle implements Shape {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public double getPerimeter() {
    return 2 * Math.PI * radius; // 원의 둘레 계산
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius; // 원의 넓이 계산
  }

}
