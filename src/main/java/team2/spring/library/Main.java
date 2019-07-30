package team2.spring.library;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import team2.spring.library.dao.*;
import team2.spring.library.entities.*;

import javax.persistence.NoResultException;
import java.util.*;

public class Main {
  private static SessionFactory sessionFactory;
  private static String TAG = "Main";

  public static void main(String[] args) {

    // Hibernate settings equivalent to hibernate.cfg.xml's properties
    Configuration cfg = new Configuration()
            .addAnnotatedClass(team2.spring.library.entities.Book.class)
            .addAnnotatedClass(team2.spring.library.entities.Author.class)
            .addAnnotatedClass(team2.spring.library.entities.Copy.class)
            .addAnnotatedClass(team2.spring.library.entities.Reader.class)
            .addAnnotatedClass(team2.spring.library.entities.Story.class)
            .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
            .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/library_spring?createDatabaseIfNotExist=true&serverTimezone=UTC")
            .setProperty("hibernate.current_session_context_class", "thread")
            .setProperty("hibernate.connection.username", "root")
            .setProperty("hibernate.connection.password", "1123581321")
            .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
            .setProperty("hibernate.show_sql", "true")
            .setProperty("hibernate.format_sql", "true")
            .setProperty("hibernate.hbm2ddl.auto", "update");

    // Create SessionFactory
    sessionFactory = cfg.buildSessionFactory();

//    sessionFactory.getCurrentSession().getTransaction().begin();
//
//        // Add our book with some authors
//    BookDao dao = new BookDao(sessionFactory);
//    Book book = new Book("How to get a job in SoftServe");
//    Set<Author> authors = new HashSet<>();
//    authors.add(new Author("Marian Milian"));
//    authors.add(new Author("Dmytro Dovgal"));
//    authors.add(new Author("Roman Zahorui"));
//    book.setAuthors(authors);
//
//    int bookId = dao.insert(book);
//    Book addedBook = dao.retrieve(bookId);
//
//    // Add some copies for the book
//    CopyDao copyDao = new CopyDao(sessionFactory);
//    int copyId_1 = copyDao.insert(new Copy(addedBook, true));
//    int copyId_2 = copyDao.insert(new Copy(addedBook, true));
//    int copyId_3 = copyDao.insert(new Copy(addedBook, false));
//    copyDao.insert(new Copy(addedBook, false));
//    copyDao.insert(new Copy(addedBook, true));
//
//    // Add a few readers
//    ReaderDao readerDao = new ReaderDao(sessionFactory);
//    int readerId_1 = readerDao.insert(new Reader("First Reader", new GregorianCalendar(2004, Calendar.FEBRUARY, 11).getTime()));
//    int readerId_2 = readerDao.insert(new Reader("Second Reader", new GregorianCalendar(1999, Calendar.SEPTEMBER, 10).getTime()));
//    int readerId_3 = readerDao.insert(new Reader("Third Reader", new GregorianCalendar(2000, Calendar.JULY, 9).getTime()));
//
//    StoryDao storyDao = new StoryDao(sessionFactory);
//    Story firstStory = new Story(readerDao.retrieve(readerId_1), copyDao.retrieve(copyId_1), new GregorianCalendar(2019, Calendar.JULY, 9).getTime());
//    Story secondStory = new Story(readerDao.retrieve(readerId_2), copyDao.retrieve(copyId_2), new GregorianCalendar(2019, Calendar.JUNE, 7).getTime());
//    Story thirdStory = new Story(readerDao.retrieve(readerId_3), copyDao.retrieve(copyId_3), new GregorianCalendar(2019, Calendar.MARCH, 8).getTime());
//    storyDao.insert(firstStory);
//    storyDao.insert(secondStory);
//    storyDao.insert(thirdStory);
//
//    firstStory.setTimeReturn(new GregorianCalendar(2019, Calendar.JULY, 29).getTime());
//    secondStory.setTimeReturn(new GregorianCalendar(2019, Calendar.JUNE, 17).getTime());
//
//    sessionFactory.getCurrentSession().getTransaction().commit();

    sessionFactory.getCurrentSession().getTransaction().begin();

//    StoryDao storyDao = new StoryDao(sessionFactory);
//    int count =  storyDao.findByPeriod(
//            new GregorianCalendar(1999, Calendar.FEBRUARY, 11).getTime(),
//            new GregorianCalendar(2019, Calendar.DECEMBER, 11).getTime());
//    LibLog.error(TAG, count+" ");


//    //1.
//    try {
//      BookDao bookDao = new BookDao(sessionFactory);
//      Book bookByTitle = bookDao.findByTitle("How to get a job in SoftServe");
//      CopyDao copyDao2 = new CopyDao(sessionFactory);
//      List<Copy> availableCopies = copyDao2.getAvailableCopies(bookByTitle);
//
////      return new AvaliableBookDto(book, availableCopies);
//      LibLog.error(TAG, availableCopies.toString());
//    } catch (NoResultException ex) {
//      // show error in jsp
//    }
//
//    //2.
//    try {
//      AuthorDao authorDao = new AuthorDao(sessionFactory);
//      Author author = authorDao.findByName("Roman Zahorui");
//      BookDao bookDao = new BookDao(sessionFactory);
//      List<Book> booksForAuthor = bookDao.findBooksByAuthor(author);
//
////      return new AvaliableBookDto(book, availableCopies);
////      LibLog.error(TAG, booksForAuthor.toString());
//    } catch (NoResultException ex) {
//      // show error in jsp
//    }
//
//
//    //3.1 ??????????????????????????????????????????????????
//
//    //3.2
//    try {
//      ReaderDao readerDao = new ReaderDao(sessionFactory);
//      Reader reader = readerDao.findByName("Third Reader");
//      LibLog.error(TAG, reader.toString());
//
//      StoryDao storyDao = new StoryDao(sessionFactory);
//      List<Story> stories = storyDao.readBooksForReader(reader);
//
//      LibLog.error(TAG, "Reader : "+reader.getName());
//      for (Story s : stories) {
//        LibLog.error(TAG, s.getCopy().getBook().getTitle() + "  Took : " + s.getTimeTake() + "   Returned : "+ s.getTimeReturn());
//      }
////      LibLog.error(TAG, story.toString());
//
////      return new AvaliableBookDto(book, availableCopies);
////      LibLog.error(TAG, booksForAuthor.toString());
//    } catch (NoResultException ex) {
//      // show error in jsp
//    }
//
//    //3.2
//    try {
//      ReaderDao readerDao = new ReaderDao(sessionFactory);
//      Reader reader = readerDao.findByName("Third Reader");
//      LibLog.error(TAG, reader.toString());
//
//      StoryDao storyDao = new StoryDao(sessionFactory);
//      List<Story> stories = storyDao.readBooksForReader(reader);
//
//      LibLog.error(TAG, "Reader : "+reader.getName());
//      for (Story s : stories) {
//        LibLog.error(TAG, s.getCopy().getBook().getTitle() + "  Took : " + s.getTimeTake() + "   Returned : "+ s.getTimeReturn());
//      }
////      LibLog.error(TAG, story.toString());
//
////      return new AvaliableBookDto(book, availableCopies);
////      LibLog.error(TAG, booksForAuthor.toString());
//    } catch (NoResultException ex) {
//      // show error in jsp
//    }
    sessionFactory.getCurrentSession().getTransaction().commit();
  }
}
