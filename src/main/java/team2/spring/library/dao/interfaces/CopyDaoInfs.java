package team2.spring.library.dao.interfaces;

import team2.spring.library.entities.Book;
import team2.spring.library.entities.Copy;

import javax.persistence.NoResultException;
import java.util.List;

public interface CopyDaoInfs extends Dao<Copy> {
  List<Copy> getAvailableCopies(Book book) throws NoResultException;

  List<Copy> getAllCopiesByBook(Book book) throws NoResultException;
}
