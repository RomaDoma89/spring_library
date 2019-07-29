package team2.spring.library.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import team2.spring.library.LibLog;
import team2.spring.library.dao.interfaces.AuthorDaoInfs;
import team2.spring.library.dao.interfaces.BookDaoInfs;
import team2.spring.library.dao.interfaces.CopyDaoInfs;
import team2.spring.library.entities.Author;
import team2.spring.library.entities.Book;
import team2.spring.library.entities.Copy;

import java.util.List;


@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

  private BookDaoInfs bookDao;
  private CopyDaoInfs copyDao;
  private AuthorDaoInfs authorDao;

  @Override
  public List<Book> getAllBooks() {
    return bookDao.retrieveAll();
  }

  @Override
  public List<Copy> isBookAvailable(String title) {
    Book book = bookDao.findByTitle(title);
    LibLog.error("Tag", book.toString());
    List<Copy> availableCopies = copyDao.getAvailableCopies(book);
    LibLog.error("Tag", availableCopies.toString());
    return availableCopies;
  }

    @Override
    public List<Book> findBookByAuthor(String name) {
       Author author = authorDao.findByName(name);
        List<Book> booksByAuthor = bookDao.findBooksByAuthor(author);
    for (Book b : booksByAuthor) System.out.println(b.toString());
        return booksByAuthor ;
    }


}
