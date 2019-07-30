package team2.spring.library.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team2.spring.library.LibLog;
import team2.spring.library.dao.interfaces.AuthorDaoInfs;
import team2.spring.library.dao.interfaces.Dao;
import team2.spring.library.entities.Author;

@Transactional
@Repository
public class AuthorDao implements AuthorDaoInfs {

  private static final String TAG = AuthorDao.class.getName();
  private SessionFactory sessionFactory;

  @Autowired
  public AuthorDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public int insert(Author entity) throws NoResultException {
    Session session = sessionFactory.getCurrentSession();
    int id = (int) session.save(entity);
    LibLog.debug(TAG, "inserted : " + session.find(Author.class, id));
    return id;
  }

  @Override
  public Author retrieve(int id) throws NoResultException {
    Session session = sessionFactory.getCurrentSession();
    return session.find(Author.class, id);
  }

  @Override
  public List<Author> retrieveAll() throws NoResultException {
    Session session = sessionFactory.getCurrentSession();
    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Author> cq = cb.createQuery(Author.class);
    Root<Author> root = cq.from(Author.class);
    cq.select(root);
    Query query = session.createQuery(cq);
    return query.getResultList();
  }

  @Override
  public Author update(Author entity) throws NoResultException {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(entity);
    return session.find(Author.class, entity.getId());
  }

  @Override
  public boolean delete(int id) throws NoResultException {
    Session session = sessionFactory.getCurrentSession();
    Author book = session.find(Author.class, id);
    session.delete(book);
    return null != book;
  }

  //    2.1 Вивести всі книжки по автору (основний автор, співавтор)
  public Author findByName(String name) throws NoResultException {
    Session session = sessionFactory.getCurrentSession();
    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Author> cq = cb.createQuery(Author.class);
    Root<Author> root = cq.from(Author.class);

    cq.select(root).where(cb.equal(root.get("name"), name));

    return session.createQuery(cq).getSingleResult();
  }
}
