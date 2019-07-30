package team2.spring.library.dao.interfaces;

import team2.spring.library.entities.Reader;

import javax.persistence.NoResultException;

public interface ReaderDaoInfs extends Dao<Reader> {
     Reader findByName(String name) throws NoResultException;
}
