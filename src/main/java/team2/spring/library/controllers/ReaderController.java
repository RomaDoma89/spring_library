package team2.spring.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReaderController {
  @RequestMapping(value = "/getBlackList", method = RequestMethod.GET)
  public ModelAndView readerRegistrationStatistic() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("getBList");

    return modelAndView;
  }

  @RequestMapping(value = "/readerStatisticByName", method = RequestMethod.GET)
  public ModelAndView readerStatisticByName() {
    String select = "1";
    ModelAndView modelAndView = new ModelAndView();

    if (select.equals("1")) {
      modelAndView.setViewName("userStatisticRead");
      return modelAndView;
    }
    if (select.equals("2")) {
      modelAndView.setViewName("userStatisticOnHand");

      return modelAndView;
    } else {
      modelAndView.setViewName("userStatisticRegistration");

      return modelAndView;
    }
  }

  @RequestMapping(value = "/avgAgeReader", method = RequestMethod.GET)
  public ModelAndView getPopularBookByPeriod() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("getAvgAge");
    return modelAndView;
  }
}
