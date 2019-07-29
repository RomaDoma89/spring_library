package team2.spring.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import team2.spring.library.LibLog;
import team2.spring.library.dto.BookAuthorDto;
import team2.spring.library.dto.BookDto;
import team2.spring.library.entities.Book;
import team2.spring.library.services.BookService;
import team2.spring.library.services.BookServiceImpl;

import java.util.List;

@Controller
public class BookController {

  @Autowired
  private BookServiceImpl bookService;

  @RequestMapping(value = "/booksByAuthorForm", method = RequestMethod.GET)
  public ModelAndView booksByAuthorForm() {
    return new ModelAndView("booksByAuthorForm","bookAuthorDto",new BookAuthorDto());
  }

  @RequestMapping(value = "/inputBookStat", method = RequestMethod.GET)
  public ModelAndView inputBookStat() {
    return new ModelAndView("inputBookStat");
  }

  @RequestMapping(value = "/inputGetByPeriod", method = RequestMethod.GET)
  public ModelAndView inputGetByPeriod() {
    return new ModelAndView("inputGetByPeriod");
  }

  @RequestMapping(value = "/inputGetPopular", method = RequestMethod.GET)
  public ModelAndView inputGetPopular() {
    return new ModelAndView("inputGetPopular");
  }

  @RequestMapping(value = "/inputInfo", method = RequestMethod.GET)
  public ModelAndView inputInfo() {
    return new ModelAndView("inputInfo");
  }
  //
  @RequestMapping(value = "/availableBookForm", method = RequestMethod.GET)
  public ModelAndView availableBookForm() {
    return new ModelAndView("availableBookForm","bookDto",new BookDto());
  }

  @RequestMapping(value = "/availableBook", method = RequestMethod.POST)
  public ModelAndView availableBook(@ModelAttribute("bookDto")BookDto bookDto, BindingResult bindingResult) {
    ModelAndView modelAndView = new ModelAndView();

    if(bindingResult.hasErrors()||bookDto.getTitle().isEmpty()){
      modelAndView.setViewName("error");
      return modelAndView;
    }
      modelAndView.setViewName("availableBook");
    if (bookService.isBookAvailable(bookDto.getTitle()).size() > 0) {
      bookDto.setAvailable(true);
     }
    else {
        bookDto.setAvailable(false);
    }
    return modelAndView;
  }

//
  @RequestMapping(value = "/allBooks", method = RequestMethod.GET)
  public ModelAndView allBooks() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("allBooks");
    List<Book> listBook = bookService.getAllBooks();
    System.out.println(listBook);
    modelAndView.addObject("listBook", listBook);
    LibLog.error(BookController.class.getName(), listBook.toString());
    return modelAndView;
  }

  @RequestMapping(value = "/getByPeriod", method = RequestMethod.GET)
  public ModelAndView getByPeriod() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("getByPeriod");
    return modelAndView;
  }

  @RequestMapping(value = "/bookStatistic", method = RequestMethod.GET)
  public ModelAndView bookStatistic() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("statisticOfBook");
    return modelAndView;
  }

  @RequestMapping(value = "/getPopularBookByPeriod", method = RequestMethod.GET)
  public ModelAndView getPopularBookByPeriod() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("getPopular");
    return modelAndView;
  }

  @RequestMapping(value = "/getBookInfo", method = RequestMethod.GET)
  public ModelAndView getBookInfo() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("getInfo");
    return modelAndView;
  }
}
