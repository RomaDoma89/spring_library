package team2.spring.library.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import team2.spring.library.LibLog;
import team2.spring.library.entities.Copy;

@Repository
public class CopyDao implements Dao<Copy> {

  private static final String TAG = CopyDao.class.getName();
  private SessionFactory sessionFactory;

  @Autowired
  public CopyDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public int insert(Copy entity) {
    Session session = sessionFactory.getCurrentSession();
    Copy copy = (Copy) session.save(entity);
      LibLog.debug(TAG, "insert : " + copy.toString());
    return copy.getId();
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
}
