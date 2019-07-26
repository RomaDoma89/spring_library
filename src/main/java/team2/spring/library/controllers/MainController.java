package team2.spring.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class MainController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView homePage() {
    return new ModelAndView("index");
  }

  @RequestMapping(value = "/averageAgeOfReader", method = RequestMethod.GET)
  public ModelAndView averageAgeOfReader() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("readerAverageAge");

    return modelAndView;
  }

  @RequestMapping(value = "/appealStatistic", method = RequestMethod.GET)
  public ModelAndView appealStatistic() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("readerAverageAppeal");

    return modelAndView;
  }

  @RequestMapping(value = "/readerRegistration", method = RequestMethod.GET)
  public ModelAndView readerRegistrationStatistic() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("readersRegistrationStatistic");

    return modelAndView;
  }
}
