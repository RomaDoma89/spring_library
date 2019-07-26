package team2.spring.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReaderController {
  @RequestMapping(value = "/getBlackList", method = RequestMethod.GET)
  public ModelAndView getBlackList() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("getBList");

    return modelAndView;
  }

  @RequestMapping(value = "/inputAvgAge", method = RequestMethod.GET)
  public ModelAndView inputAvgAge() {
    return new ModelAndView("inputAvgAge");
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
  public ModelAndView avgAgeReader() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("getAvgAge");
    return modelAndView;
  }

  @RequestMapping(value = "/averageAgeOfReader", method = RequestMethod.GET)
  public ModelAndView averageAgeOfReader() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("readerAverageAge");

    return modelAndView;
  }

  @RequestMapping(value = "/readerRegistration", method = RequestMethod.GET)
  public ModelAndView readerRegistration() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("readersRegistrationStatistic");

    return modelAndView;
  }

  @RequestMapping(value = "/readerAverageAppealForm", method = RequestMethod.GET)
  public ModelAndView readerAverageAppealForm() {
    return new ModelAndView("readerAverageAppealForm");
  }

  @RequestMapping(value = "/userStatisticForm", method = RequestMethod.GET)
  public ModelAndView userStatisticForm() {
    return new ModelAndView("userStatisticForm");
  }

  @RequestMapping(value = "/appealStatistic", method = RequestMethod.GET)
  public ModelAndView appealStatistic() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("readerAverageAppeal");

    return modelAndView;
  }
}
