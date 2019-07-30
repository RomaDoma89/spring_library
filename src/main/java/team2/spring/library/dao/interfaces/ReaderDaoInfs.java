package team2.spring.library.dao.interfaces;

import team2.spring.library.entities.Reader;
import team2.spring.library.entities.Story;

import javax.persistence.NoResultException;
import java.util.List;

public interface ReaderDaoInfs extends Dao<Reader> {
  Reader findByName(String name) throws NoResultException;

  List<Story> getBlackList() throws NoResultException;

  List<Story> getReaderStory(Reader reader) throws NoResultException;
}
