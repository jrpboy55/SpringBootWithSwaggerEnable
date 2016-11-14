package hello.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.model.DateRange;
import hello.model.User;

@RestController
public class HelloController
{

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String index()
    {
	String greeting = new String ("Greetings from Spring Boot!");
	
	return greeting;
    }
    

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public User getUser()
    {
	User user = new User("jack", "jrpboy@gmail.com");
	
	System.out.println(user.toString());
	return user;
    }
      

    @RequestMapping(value = "/dateRange", method = RequestMethod.GET, produces = "application/json")
    public DateRange getDate()
    {
	DateRange dateRange = new DateRange("2000-01-01", "2010-11-11");
	
	System.out.println(dateRange.toString());
	return dateRange;
    }
    
    @RequestMapping(value = "/dateRange",consumes = "application/json", method = RequestMethod.POST, produces = "application/json")
    public DateRange postDate(@RequestBody DateRange newDateRange)
    {
	
	newDateRange.setToDate("2016-11-13");
	
	return newDateRange;
    }

}
