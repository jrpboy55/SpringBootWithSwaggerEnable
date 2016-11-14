package hello;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JExpr;
import com.helger.jcodemodel.JMethod;

import hello.controller.HelloController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JackScrapeControllerIT // extends AbstractTestNGSpringContextTests
{

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;
    
    @Autowired
    private HelloController controller;

    @Test
    public void getAllControllerBeans() throws Exception
    {

	ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
	scanner.addIncludeFilter(new AnnotationTypeFilter(Controller.class));

	for (BeanDefinition beanDefinition : scanner.findCandidateComponents("hello"))
	{
	    System.out.println("XXX: " + beanDefinition.getBeanClassName() + beanDefinition.toString());
	    
	    
	}
    }

    // this one is good!
    @Test
    public void getAllRequestMappingHandlers()
    {
	
	Map<RequestMappingInfo, HandlerMethod> mapper = requestMappingHandlerMapping.getHandlerMethods();

	for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : mapper.entrySet())
	{
	    System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
	}
	System.out.println(mapper.size());

    }
    @Test
    public void getAllRequestMappingHandlersForName()
    {

	List<HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethodsForMappingName("HC#index");

	for (HandlerMethod handlerMethod :handlerMethods)
	{
//	    
//	    System.out.println( handlerMethod.getBean());
//	    System.out.println( handlerMethod.getBeanType());
	    System.out.println( handlerMethod.getMethod().toString());
	    System.out.println( handlerMethod.getMethodParameters().toString());
	    System.out.println("handerMethod: " + handlerMethod.toString());
	}
	//System.out.println(mapper.size());

    }


    @Test
    public void createSRC() throws JClassAlreadyExistsException, IOException
    {
	JCodeModel api = new JCodeModel();
	JDefinedClass newSRCFile = api._class("foo.Bar");

	JMethod m = newSRCFile.method(0, int.class, "foo");
	m.body()._return(JExpr.lit(5));

	File file = new File("./src/main/java/");
	file.mkdirs();
	api.build(file);

    }

    @Test
    public void createSRCCOmplex() throws JClassAlreadyExistsException, IOException
    {
	JCodeModel api = new JCodeModel();
	JDefinedClass newSRCFile = api._class("foo.PORestClient");

	// class variables?
	newSRCFile.field(0, hello.model.DateRange.class, "dateRange");

	// autowired?
	newSRCFile.field(0, String.class, "autowireString");

	JMethod m = newSRCFile.method(0, int.class, "createPO");
	m.body()._return(JExpr.lit(5));

	File file = new File("./src/main/java/");
	file.mkdirs();
	api.build(file);

    }

}
