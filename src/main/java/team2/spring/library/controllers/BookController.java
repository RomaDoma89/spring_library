package team2.spring.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

  @RequestMapping(value = "/availableBookForm", method = RequestMethod.GET)
  public ModelAndView availableBookForm() {
    return new ModelAndView("availableBookForm");
  }

  @RequestMapping(value = "/booksByAuthorForm", method = RequestMethod.GET)
  public ModelAndView booksByAuthorForm() {
    return new ModelAndView("booksByAuthorForm");
  }

  @RequestMapping(value = "/readerAverageAppealForm", method = RequestMethod.GET)
  public ModelAndView readerAverageAppealForm() {
    return new ModelAndView("readerAverageAppealForm");
  }

  @RequestMapping(value = "/userStatisticForm", method = RequestMethod.GET)
  public ModelAndView userStatisticForm() {
    return new ModelAndView("userStatisticForm");
  }

  // Dima`s jsp
  @RequestMapping(value = "/inputAvgAge", method = RequestMethod.GET)
  public ModelAndView inputAvgAge() {
    return new ModelAndView("inputAvgAge");
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
}
