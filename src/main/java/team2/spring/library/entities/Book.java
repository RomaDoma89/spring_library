package team2.spring.library.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private int id;

  @Column(name = "title", length = 225, unique = true)
  private String title;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "book_author",
          joinColumns = { @JoinColumn(name = "id_book", nullable = false, updatable = false) },
          inverseJoinColumns = { @JoinColumn(name = "id_author", nullable = false, updatable = false) }
  )
  private Set<Author> authors = new HashSet<>();

  public Book() {}

  public Book(String title) {
    this.title = title;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Set<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }

  @Override
  public String toString() {
    return "Book{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", authors=" + authors +
            '}';
  }
}
