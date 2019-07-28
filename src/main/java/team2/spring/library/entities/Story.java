package team2.spring.library.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "reader_story")
public class Story {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private int id;

  @ManyToOne
  @JoinColumn(name = "reader", nullable = false)
  private Reader reader;

  @ManyToOne
  @JoinColumn(name = "copy", nullable = false)
  private Copy copy;

  @Temporal(TemporalType.DATE)
  @Column(name = "time_take", nullable = false)
  private Date timeTake;

  @Temporal(TemporalType.DATE)
  @Column(name = "time_return")
  private Date timeReturn;

  public Story(Reader reader, Copy copy, Date timeTake) {
    this.reader = reader;
    this.copy = copy;
    this.timeTake = timeTake;
  }
}
