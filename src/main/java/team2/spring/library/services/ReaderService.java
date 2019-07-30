package team2.spring.library.services;

import team2.spring.library.entities.Story;

import javax.persistence.NoResultException;
import java.util.List;

public interface ReaderService {
  List<Story> findReadBook(String name) throws NoResultException;

  List<Story> findNotReturnedBook(String name) throws NoResultException;
}
