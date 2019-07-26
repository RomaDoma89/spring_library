package team2.spring.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorController {
  @RequestMapping(value = "/booksByAuthor", method = RequestMethod.GET)
  public ModelAndView bookTitle() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("booksByAuthor");
    return modelAndView;
  }
}
