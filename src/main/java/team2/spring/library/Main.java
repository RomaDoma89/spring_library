package team2.spring.library;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import team2.spring.library.dao.*;
import team2.spring.library.entities.*;

import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main {
  private static SessionFactory sessionFactory;
  private static String TAG = "Main";

  public static void main(String[] args) {

    // Hibernate settings equivalent to hibernate.cfg.xml's properties
    Configuration cfg =
        new Configuration()
            .addAnnotatedClass(team2.spring.library.entities.Book.class)
            .addAnnotatedClass(team2.spring.library.entities.Author.class)
            .addAnnotatedClass(team2.spring.library.entities.Copy.class)
            .addAnnotatedClass(team2.spring.library.entities.Reader.class)
            .addAnnotatedClass(team2.spring.library.entities.Story.class)
            .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
            .setProperty(
                "hibernate.connection.url",
                "jdbc:mysql://localhost:3306/library_spring?createDatabaseIfNotExist=true&serverTimezone=UTC")
            .setProperty("hibernate.current_session_context_class", "thread")
            .setProperty("hibernate.connection.username", "root")
            .setProperty("hibernate.connection.password", "root")
            .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
            .setProperty("hibernate.show_sql", "true")
            .setProperty("hibernate.format_sql", "true")
            .setProperty("hibernate.hbm2ddl.auto", "update");

    // Create SessionFactory


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
    //        LibLog.error(TAG, s.getCopy().getBook().getTitle() + "  Took : " + s.getTimeTake() + "
    //   Returned : "+ s.getTimeReturn());
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
    //        LibLog.error(TAG, s.getCopy().getBook().getTitle() + "  Took : " + s.getTimeTake() + "
    //   Returned : "+ s.getTimeReturn());
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
