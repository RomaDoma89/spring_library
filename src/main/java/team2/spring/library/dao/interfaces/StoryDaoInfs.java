package team2.spring.library.dao.interfaces;

import team2.spring.library.entities.Reader;
import team2.spring.library.entities.Story;

import javax.persistence.NoResultException;
import java.util.List;

public interface StoryDaoInfs  extends Dao<Story> {
    List<Story> readBooksForReader(Reader reader)throws NoResultException;
    List<Story> notReturnedBooksForReader(Reader reader)throws NoResultException;

    }
