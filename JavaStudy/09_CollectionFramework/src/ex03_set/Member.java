package ex03_set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//생성자
@AllArgsConstructor
// Getter
@Getter
// Setter
@Setter
// toString
@ToString
// Equals and HashCode
@EqualsAndHashCode
public class Member {
  private final String name;
  private final int age;

}
