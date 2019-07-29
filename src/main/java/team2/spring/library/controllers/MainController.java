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

  @RequestMapping(value ="/error",method = RequestMethod.GET)
  public String error(){
  return "error";}
}
