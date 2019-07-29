package team2.spring.library.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team2.spring.library.entities.Book;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAuthorDto {
    private String author;
    private List<Book> books;

}
