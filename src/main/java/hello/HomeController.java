package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
@RequestMapping("/")
public class HomeController {
 
  @Autowired private PersonService personSvc;
   
  /**
   * Requests to http://localhost:8080/hello will be mapped here.
   * Everytime invoked, we pass list of all persons to view
   */
  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public String listAll(Model model) {
    String test="Hi Guys Mand,Chotu,Kunal And Rustag this is our Sample App Url";
    return test;
  }
   
  /**
   * POST requests to http://localhost:8080/hello/addPerson goes here.
   * The new person data is passed from HTML from and bound into the
   * Person object.
   */
  @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
  public String addPerson(@ModelAttribute Person person) {
    personSvc.add(person);
    return "redirect:/";
  }
  
  @RequestMapping(value = "/test", method = RequestMethod.GET)
  @ResponseBody
  public String testss() {

    return "Sa ITre";
  }
}