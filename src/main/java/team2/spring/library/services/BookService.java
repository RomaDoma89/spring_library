package team2.spring.library.services;

import team2.spring.library.entities.Author;
import team2.spring.library.entities.Book;
import team2.spring.library.entities.Copy;

import javax.persistence.NoResultException;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks()throws NoResultException;
    List<Copy> isBookAvailable(String title)throws NoResultException;
    List<Book> findBookByAuthor(String name)throws NoResultException;
}
