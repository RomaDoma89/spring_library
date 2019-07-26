package team2.spring.library.dao;

import java.util.List;

public interface Dao<E> {

  int insert(E entity);

  E retrieve(int id);

  List<E> retrieveAll();

  E update(E entity);

  boolean delete(int id);
}
