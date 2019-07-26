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
//  @RequestMapping(value = "/availableBookForm",method = RequestMethod.GET)
//  public ModelAndView availableBookForm(){
//    return  new ModelAndView("availableBookForm");
//  }

}
