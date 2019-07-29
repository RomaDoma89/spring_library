package team2.spring.library.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import team2.spring.library.LibLog;
import team2.spring.library.dao.interfaces.CopyDaoInfs;
import team2.spring.library.entities.Book;
import team2.spring.library.entities.Copy;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public class CopyDao implements CopyDaoInfs {

  private static final String TAG = CopyDao.class.getName();
  @Autowired
  private SessionFactory sessionFactory;

//  @Autowired
//  public CopyDao(SessionFactory sessionFactory) {
//    this.sessionFactory = sessionFactory;
//  }

  @Override
  public int insert(Copy entity) {
    Session session = sessionFactory.getCurrentSession();
    int id = (int) session.save(entity);
    LibLog.debug(TAG, "inserted : " + session.find(Copy.class, id));
    return id;
  }

  @Override
  public Copy retrieve(int id) {
    Session session = sessionFactory.getCurrentSession();
    return session.find(Copy.class, id);
  }

  @Override
  public List<Copy> retrieveAll() {
    Session session = sessionFactory.getCurrentSession();
    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Copy> cq = cb.createQuery(Copy.class);
    Root<Copy> root = cq.from(Copy.class);
    cq.select(root);
    Query query = session.createQuery(cq);
    return query.getResultList();
  }

  @Override
  public Copy update(Copy entity) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(entity);
    return session.find(Copy.class, entity.getId());
  }

  @Override
  public boolean delete(int id) {
    Session session = sessionFactory.getCurrentSession();
    Copy copy = session.find(Copy.class, id);
    session.delete(copy);
    return null != copy;
  }

  //  1.2 Подивитись, чи певна книжка доступна
  @Override
  public List<Copy> getAvailableCopies(Book book) throws NoResultException {
    System.out.println("pfqikj ");
    Session session = sessionFactory.getCurrentSession();
    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Copy> cq = cb.createQuery(Copy.class);
    Root<Copy> root = cq.from(Copy.class);

    Predicate predicate =
        cb.and(cb.equal(root.get("book"), book), cb.equal(root.get("available"), true));
    cq.select(root).where(predicate);

    return session.createQuery(cq).getResultList();
  }
}
