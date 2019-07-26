package team2.spring.library.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "reader")
public class Reader {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private int id;

  @Column(name = "name", length = 100, unique = true, nullable = false)
  private String name;

  @Temporal(TemporalType.DATE)
  @Column(name = "birthday", nullable = false)
  private Date birthday;

  public Reader(String name) {
    this.name = name;
  }
}
