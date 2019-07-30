package team2.spring.library.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import team2.spring.library.dao.interfaces.*;
import team2.spring.library.entities.Author;
import team2.spring.library.entities.Reader;
import team2.spring.library.entities.Story;

import javax.persistence.NoResultException;
import java.util.List;

@Service
@AllArgsConstructor
public class ReaderServiceImpl implements ReaderService {

  private BookDaoInfs bookDao;
  private CopyDaoInfs copyDao;
  private AuthorDaoInfs authorDao;
  private StoryDaoInfs storyDao;
  private ReaderDaoInfs readerDao;

  @Override
  public List<Story> findReadBook(String name) throws NoResultException {
    Reader reader = readerDao.findByName(name);
    return storyDao.readBooksForReader(reader);
  }

  @Override
  public List<Story> findNotReturnedBook(String name) throws NoResultException {
    Reader reader = readerDao.findByName(name);
    return storyDao.notReturnedBooksForReader(reader);
  }
}
