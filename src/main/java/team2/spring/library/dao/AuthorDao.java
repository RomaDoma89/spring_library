package team2.spring.library.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import team2.spring.library.LibLog;
import team2.spring.library.entities.Author;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDao implements Dao<Author> {
    private final static String TAG = AuthorDao.class.getName();
    private SessionFactory sessionFactory;

    @Autowired
    public AuthorDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int insert(Author entity) {
        Session session = sessionFactory.getCurrentSession();
        Author author = (Author) session.save(entity);
        LibLog.debug(TAG, "insert : " + author.toString());
        return author.getId();
    }

    @Override
    public Author retrieve(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Author.class, id);
    }

    @Override
    public List<Author> retrieveAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery <Author> cq = cb.createQuery(Author.class);
        Root <Author> root = cq.from(Author.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Author update(Author entity) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Author book = session.find(Author.class, id);
        session.delete(book);
        return null != book;
    }
}
