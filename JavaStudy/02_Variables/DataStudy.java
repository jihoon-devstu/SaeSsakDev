public class DataStudy {
  String name;
  int age;
  double height;
  String gender;

  public void dataInsert() {
    name = "Jihoon";
    age = 31;
    height = 183;
    gender = "Male";
  }

  public static void main(String[] args) {
    DataStudy dataStudy = new DataStudy();
    dataStudy.dataInsert();
    System.out.println("Name: " + dataStudy.name);
    System.out.println("Age: " + dataStudy.age);
    System.out.println("Height: " + dataStudy.height);
    System.out.println("Gender: " + dataStudy.gender);
  }
}
