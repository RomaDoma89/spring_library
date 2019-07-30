package team2.spring.library.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import team2.spring.library.LibLog;
import team2.spring.library.dao.interfaces.BookDaoInfs;
import team2.spring.library.entities.Author;
import team2.spring.library.entities.Book;
import team2.spring.library.entities.Story;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class BookDao implements BookDaoInfs {

  private static final String TAG = BookDao.class.getName();
  @Autowired private SessionFactory sessionFactory;

  @Override
  public int insert(Book entity) {
    Session session = sessionFactory.getCurrentSession();
    int id = (int) session.save(entity);
    LibLog.debug(TAG, "inserted : " + session.find(Book.class, id));
    return id;
  }

  @Override
  public Book retrieve(int id) {
    Session session = sessionFactory.getCurrentSession();
    return session.find(Book.class, id);
  }

  @Override
  public List<Book> retrieveAll() throws NoResultException {
    Session session = sessionFactory.getCurrentSession();
    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Book> cq = cb.createQuery(Book.class);
    Root<Book> root = cq.from(Book.class);
    cq.select(root);
    Query query = session.createQuery(cq);
    return query.getResultList();
  }

  @Override
  public Book update(Book entity) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(entity);
    return session.find(Book.class, entity.getId());
  }

  @Override
  public boolean delete(int id) {
    Session session = sessionFactory.getCurrentSession();
    Book book = session.find(Book.class, id);
    session.delete(book);
    return null != book;
  }

  //  1.1 Подивитись, чи певна книжка доступна
  @Override
  public Book findByTitle(String title) throws NoResultException {
    Session session = sessionFactory.getCurrentSession();
    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Book> cq = cb.createQuery(Book.class);
    Root<Book> root = cq.from(Book.class);

    cq.select(root).where(cb.equal(root.get("title"), title));

    return session.createQuery(cq).getSingleResult();
  }

  //    2.2 Вивести всі книжки по автору (основний автор, співавтор)
  @Override
  public List<Book> findBooksByAuthor(Author author) {
    Session session = sessionFactory.getCurrentSession();
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Author> cq = builder.createQuery(Author.class);
    Root<Author> root = cq.from(Author.class);
    root.join("books");

    cq.select(root).where(builder.equal(root.get("id"), author.getId()));
    Query query = session.createQuery(cq);

    Author a = (Author) query.getSingleResult();

    LibLog.error(TAG, a.getBooks().toString());
    return new ArrayList<>(a.getBooks());
  }
  // 6
  public List<Story> getPopularBook(Date firstDate, Date secondDate) {
    Session session = sessionFactory.getCurrentSession();
    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Story> cq = cb.createQuery(Story.class);
    Root<Story> root = cq.from(Story.class);

    cq.select(root).where(cb.between(root.get("timeTake"), firstDate, secondDate));
    return session.createQuery(cq).getResultList();
  }
}
