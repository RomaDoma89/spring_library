package team2.spring.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import team2.spring.library.dto.ReaderStatisticDto;
import team2.spring.library.entities.Reader;
import team2.spring.library.entities.Story;
import team2.spring.library.services.BookServiceImpl;
import team2.spring.library.services.ReaderServiceImpl;

import java.util.List;

@Controller
public class ReaderController {

  @Autowired
  private BookServiceImpl bookService;
  @Autowired
  private ReaderServiceImpl readerService;

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
  //
  @RequestMapping(value = "/userStatisticForm", method = RequestMethod.GET)
  public ModelAndView userStatisticForm() {
    return new ModelAndView("userStatisticForm", "readerStatisticDto", new ReaderStatisticDto());
  }

  @RequestMapping(value = "/readerStatisticByName", method = RequestMethod.POST)
  public ModelAndView readerStatisticByName(
      @ModelAttribute ReaderStatisticDto readerStatisticDto, BindingResult bindingResult) {
    String select = readerStatisticDto.getSelect();
    System.out.println(readerStatisticDto);

    ModelAndView modelAndView = new ModelAndView();
    if (bindingResult.hasErrors() || readerStatisticDto.getReader().isEmpty()) {
      modelAndView.setViewName("error");
    }
    if (select.equals("read")) {
      List<Story> stories;
        try{
            stories =readerService.findReadBook(readerStatisticDto.getReader());
            System.out.println(stories);
        }
        catch (Exception e){
            modelAndView.setViewName("error");
            return modelAndView;
        }
      if(stories.isEmpty()){
        modelAndView.setViewName("error");
      }
      else {
        modelAndView.setViewName("userStatisticRead");
        readerStatisticDto.setStories(stories);
        modelAndView.addObject(readerStatisticDto);
      }
      return modelAndView;
    }
    if (select.equals("ordered")) {
        System.out.println("I tut");
        List<Story> stories;
        try{
            stories = readerService.findNotReturnedBook(readerStatisticDto.getReader());
            System.out.println(stories);
        }
        catch (Exception e){
            modelAndView.setViewName("userStatisticRead");
            return modelAndView;
        }

        if (stories.isEmpty()){
          modelAndView.setViewName("error");
      } else {
        modelAndView.setViewName("userStatisticRead");
        readerStatisticDto.setStories(stories);
        modelAndView.addObject(readerStatisticDto);
      }

      return modelAndView;
    } else {
        List<Story> stories;
        try{
            stories =readerService.findReadBook(readerStatisticDto.getReader());
            System.out.println(stories);
//            stories.stream().min()
        }
        catch (Exception e){
            modelAndView.setViewName("error");
            return modelAndView;
        }
        if(stories.isEmpty()){
            modelAndView.setViewName("error");
        }
        else {
            modelAndView.setViewName("userStatisticRegistration");
            readerStatisticDto.setStories(stories);
            modelAndView.addObject(readerStatisticDto);
        }

      return modelAndView;
    }
  }
  //
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

  @RequestMapping(value = "/appealStatistic", method = RequestMethod.GET)
  public ModelAndView appealStatistic() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("readerAverageAppeal");

    return modelAndView;
  }
}
