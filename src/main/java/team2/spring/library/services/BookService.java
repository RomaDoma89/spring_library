package team2.spring.library.services;

import team2.spring.library.entities.Author;
import team2.spring.library.entities.Book;
import team2.spring.library.entities.Copy;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    List<Copy> isBookAvailable(String title);
    List<Book> findBookByAuthor(String name);
}
