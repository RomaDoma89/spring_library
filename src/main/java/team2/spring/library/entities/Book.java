package team2.spring.library.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "book")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private int id;

  @Column(name = "title", length = 225, unique = true, nullable = false)
  private String title;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "book_author",
      joinColumns = {@JoinColumn(name = "id_book", nullable = false, updatable = false)},
      inverseJoinColumns = {@JoinColumn(name = "id_author", nullable = false, updatable = false)})
  private Set<Author> authors = new HashSet<>();

  public Book(String title) {
    this.title = title;
  }
}
