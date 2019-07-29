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
import team2.spring.library.entities.Story;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

  private BookDaoInfs bookDao;
  private CopyDaoInfs copyDao;
  private AuthorDaoInfs authorDao;
//  private StoryDaoInfs storyDao;

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
    return booksByAuthor;
  }

  // 5. завдання
//  public void findUsingTotal(String title) {
//    BookDao bookDao = new BookDao(sessionFactory);
//    Book book = bookDao.findByTitle("Hooked on Java");
//    CopyDao copyDao = new CopyDao(sessionFactory);
//    List<Copy> copies = copyDao.getAvailableCopiesByBook(book);
//    StoryDao storyDao = new StoryDao(sessionFactory);
//    List<Story> stories = storyDao.getStoriesForBookByCopies(copies);
//
//    // 1.
//    int totalUsage = stories.size();
//    System.out.println(totalUsage);
//
//    // 2.
//    Map<Copy, Long> counted =
//        stories.stream().collect(Collectors.groupingBy(Story::getCopy, Collectors.counting()));
//    Set<Map.Entry<Copy, Long>> entries = counted.entrySet();
//    for (Map.Entry<Copy, Long> e : entries) {
//      System.out.println(e.getKey().getId() + "  " + e.getValue());
//    }
//
//    // 3. serednii chas chetannia
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    ArrayList<Long> avg = new ArrayList<>();
//    for (Story s : stories) {
//      LocalDate fDate = formatter.parse(s.getTimeTake().toString(), LocalDate::from);
//      LocalDate sDate =
//          formatter.parse(
//              s.getTimeReturn() == null ? LocalDate.now().toString() : s.getTimeReturn().toString(),
//              LocalDate::from);
//      avg.add(DAYS.between(fDate, sDate));
//    }
//    System.out.println(avg.stream().mapToLong(a -> a).average().getAsDouble());
//  }
}
