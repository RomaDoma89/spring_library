package team2.spring.library.dao.interfaces;

import team2.spring.library.entities.Author;
import team2.spring.library.entities.Book;
import team2.spring.library.entities.Story;

import javax.persistence.NoResultException;
import java.util.Date;
import java.util.List;

public interface BookDaoInfs extends Dao<Book> {
  Book findByTitle(String title) throws NoResultException;

  List<Book> findBooksByAuthor(Author author) throws NoResultException;

  List<Story> getPopularBook(Date firstDate, Date secondDate) throws NoResultException;
}
