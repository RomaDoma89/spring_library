package team2.spring.library.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;

//import net.javaguides.springmvc.entity.Customer;
import team2.spring.library.entities.Book;

//@Repository
public class BookDao implements Dao<Book> {
//    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int insert(Book entity) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.save(entity);
        return book.getId();
    }

    @Override
    public Book retrieve(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Book.class, id);
    }

    @Override
    public List<Book> retrieveAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery <Book> cq = cb.createQuery(Book.class);
        Root <Book> root = cq.from(Book.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Book update(Book entity) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.find(Book.class, id);
        session.delete(book);
        return null != book;
    }
}
