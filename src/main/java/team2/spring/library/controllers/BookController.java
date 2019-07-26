package team2.spring.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

  @RequestMapping(value = "/booksByAuthorForm", method = RequestMethod.GET)
  public ModelAndView booksByAuthorForm() {
    return new ModelAndView("booksByAuthorForm");
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
  @RequestMapping(value = "/bookTitle", method = RequestMethod.GET)
  public ModelAndView bookTitle() {
    System.out.println("im here");
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("availableBook");
    return modelAndView;
  }

  @RequestMapping(value = "/availableBookForm", method = RequestMethod.GET)
  public ModelAndView availableBookForm() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("booksByAuthor");
    return new ModelAndView("availableBookForm");
  }

  @RequestMapping(value = "/allBooks", method = RequestMethod.GET)
  public ModelAndView allBooks() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("allBooks");
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
