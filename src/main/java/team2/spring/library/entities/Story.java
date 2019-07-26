package team2.spring.library.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "reader_story")
public class Story {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private int id;

  @ManyToOne
  @JoinColumn(name = "id_reader", nullable = false)
  private Reader reader;

  @ManyToOne
  @JoinColumn(name = "id_copy", nullable = false)
  private Copy copy;

  @Column(name = "time_take", nullable = false)
  private Date timeTake;

  @Column(name = "time_return")
  private Date timeReturn;

  public Story(Reader reader, Copy copy, Date timeTake) {
    this.reader = reader;
    this.copy = copy;
    this.timeTake = timeTake;
  }
}
