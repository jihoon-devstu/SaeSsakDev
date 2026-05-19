public class Variables {
  String name;
  int age;
  double height;
  char gender;

  public void dataInsert() {
    name = "Jihoon";
    age = 31;
    height = 183;
    gender = 'M';
  }

  public static void main(String[] args) {
    Variables variables = new Variables();

    variables.dataInsert();
    System.out.println("Name: " + variables.name);
    System.out.println("Age: " + variables.age);
    System.out.println("Height: " + variables.height);
    System.out.println("Gender: " + variables.gender);

  }
}
