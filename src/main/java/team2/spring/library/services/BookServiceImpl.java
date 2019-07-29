package team2.spring.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.spring.library.dao.BookDao;
import team2.spring.library.entities.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.retrieveAll();
    }


}
