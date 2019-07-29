package team2.spring.library.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

import team2.spring.library.LibLog;
import team2.spring.library.entities.Book;
import team2.spring.library.entities.Reader;
import team2.spring.library.entities.Story;

@Repository
public class StoryDao implements Dao<Story> {

  private static final String TAG = StoryDao.class.getName();
  private SessionFactory sessionFactory;

  @Autowired
  public StoryDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public int insert(Story entity) {
    Session session = sessionFactory.getCurrentSession();
    int id = (int) session.save(entity);
    LibLog.debug(TAG, "inserted : " + session.find(Story.class, id));
    return id;
  }

  @Override
  public Story retrieve(int id) {
    Session session = sessionFactory.getCurrentSession();
    return session.find(Story.class, id);
  }

  @Override
  public List<Story> retrieveAll() {
    Session session = sessionFactory.getCurrentSession();
    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Story> cq = cb.createQuery(Story.class);
    Root<Story> root = cq.from(Story.class);
    cq.select(root);
    Query query = session.createQuery(cq);
    return query.getResultList();
  }

  @Override
  public Story update(Story entity) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(entity);
    return session.find(Story.class, entity.getId());
  }

  @Override
  public boolean delete(int id) {
    Session session = sessionFactory.getCurrentSession();
    Story story = session.find(Story.class, id);
    session.delete(story);
    return null == story;
  }

//  3. Переглянути статистику по читачу (які книжки брав)
  public List<Story> readBooksForReader(Reader reader) {
    Session session = sessionFactory.getCurrentSession();
    CriteriaBuilder cb = session.getCriteriaBuilder();

    CriteriaQuery<Story> cq = cb.createQuery(Story.class);

    Root<Story> root = cq.from(Story.class);
    root.join("reader");

    cq.select(root).where(cb.equal(root.get("reader"), reader));

    return session.createQuery(cq).getResultList();
  }

  //  3. Переглянути статистику по читачу (які на руках)
  public List<Story> notReturnedBooksForReader(Reader reader) {
    Session session = sessionFactory.getCurrentSession();
    CriteriaBuilder cb = session.getCriteriaBuilder();

    CriteriaQuery<Story> cq = cb.createQuery(Story.class);

    Root<Story> root = cq.from(Story.class);
    root.join("reader");

    cq.select(root).where(cb.equal(root.get("reader"), reader), cb.isNull(root.get("time_return")));

    return session.createQuery(cq).getResultList();
  }


//  public Date timeOfUsingLibraryForReaders() {
//    Session session = sessionFactory.getCurrentSession();
//    CriteriaBuilder cb = session.getCriteriaBuilder();
//
//    CriteriaQuery<Story> cq = cb.createQuery(Story.class);
//
//    Root<Story> root = cq.from(Story.class);
//    root.join("reader");

//    final Path<Date> checkDatePath = root.get("timeTake");
//    final ParameterExpression<Date> startDateParameter = cb.parameter(Date.class);
//
//
//    Path<Date> expiryDate = root.<Date> get("timeTake");
//    Expression<Date> exp = cb.least(expiryDate);
//
//
//
//    cq.select(root.get("reader"), root.get("timeTake")).groupBy(root.get("reader"));
//
//    Query query = session.createQuery(cq);
//    LibLog.error(TAG, query.toString());

//    List<Story> story = session.createQuery(cq).getResultList();
//    for (Story s : story) {
//      LibLog.error(TAG, s.toString());
//    }

//    return null;
//  }
}