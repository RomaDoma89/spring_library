package team2.spring.library.dao.interfaces;

import javax.persistence.NoResultException;
import java.util.List;

public interface Dao<E> {

  int insert(E entity) throws NoResultException;

  E retrieve(int id) throws NoResultException;

  List<E> retrieveAll() throws NoResultException;

  E update(E entity) throws NoResultException;

  boolean delete(int id) throws NoResultException;
}
