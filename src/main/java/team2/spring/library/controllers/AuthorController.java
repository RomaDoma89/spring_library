package team2.spring.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import team2.spring.library.dto.BookAuthorDto;
import team2.spring.library.services.BookServiceImpl;

@Controller
public class AuthorController {
  @Autowired private BookServiceImpl bookService;

  @RequestMapping(value = "/booksByAuthor", method = RequestMethod.POST)
  public ModelAndView bookTitle(@ModelAttribute BookAuthorDto bookAuthorDto) {
    ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("booksByAuthor");
      System.out.println(bookAuthorDto);
    bookAuthorDto.setBooks(bookService.findBookByAuthor(bookAuthorDto.getAuthor()));
      System.out.println(bookAuthorDto);

    modelAndView.addObject("bookAuthorDto", bookAuthorDto);
    return modelAndView;
  }
}
