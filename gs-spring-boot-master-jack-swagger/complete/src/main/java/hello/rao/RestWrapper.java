package hello.rao;

/**
 * @lastChangedDate $LastChangedDate: 2016-04-27 15:53:22 -0400 (Wed, 27 Apr 2016) $
 * @version $Revision: 6766 $
 * @id $Id: DefaultHtmlBuilder.java 6766 2016-04-27 19:53:22Z brunetg $
 * @HeadURL $HeadURL: http://njes1u39.ci.gc.ca/svn/iprms-service/trunk/src/main/java/ca/gc/cic/gol/iprms/builder/DefaultHtmlBuilder.java $
 */

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

public class RestWrapper<T, R>
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    // Set via Spring configuration files. ?? is it really, how, this is a @Service, it is using the values set here, not the XML configuration file.
    
    // DEFAULTS
    private Integer restClientReadTimeoutMS 	= 	20000;  // 20 second default
    
    private Integer restSOTimeoutMS 		= 	20000;  // 20 second default
    

    // Set via Spring configuration files
    @Autowired
    private RestTemplate restTemplate;

    private static String USERNAME = "username";

    private static String PASSWORD = "password";

    /**
     * Required for setting the HTTP client timeout value. TODO - can we Spring this?
     */
    @PostConstruct
    public void initRestWrapper()
    {
	if(restTemplate != null)
	{
	    ClientHttpRequestFactory factory = restTemplate.getRequestFactory();
	    
	    if(factory != null && factory instanceof HttpComponentsClientHttpRequestFactory)
	    {
		HttpComponentsClientHttpRequestFactory innerFactory = (HttpComponentsClientHttpRequestFactory) factory;
		
		/*if(innerFactory.getHttpClient() != null && innerFactory.getHttpClient() instanceof DefaultHttpClient)
		{
		    DefaultHttpClient httpClient = (DefaultHttpClient) innerFactory.getHttpClient();
		    httpClient.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, restClientReadTimeoutMS);
		    httpClient.getParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT, restSOTimeoutMS);

		    logger.debug("XXX Setting http.connection.timeout to: " + restClientReadTimeoutMS);
		    logger.debug("XXX  Setting http.socket.timeout to: " 	+ restSOTimeoutMS);
		}*/
	    }
	}
    }

    private ResponseEntity<R> getObject(String url, HttpHeaders headers, HttpMethod httpMethod, Class<R> clazz)
	    throws ResourceAccessException
    {
	MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
	HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(postParameters, headers);
	ResponseEntity<R> entity = restTemplate.exchange(url, httpMethod, requestEntity, clazz);
	return entity;
    }

    private <Type, Return> ResponseEntity<R> getObject(String url, HttpHeaders headers, HttpMethod httpMethod, Class<R> clazz,
	    Object... params) throws ResourceAccessException
    {
	MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
	HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(postParameters, headers);
	ResponseEntity<R> entity = restTemplate.exchange(url, httpMethod, requestEntity, clazz, params);
	return entity;
    }

    public R getObject(String url, String username, String password, Class<R> clazz)
    {
	HttpHeaders headers = new HttpHeaders();
	headers.add(USERNAME, username);
	headers.add(PASSWORD, password);
	ResponseEntity<R> entity = getObject(url, headers, HttpMethod.GET, clazz);
	return entity.getBody();
    }

    public R getObject(String url, String username, String password, ParameterizedTypeReference<R> typeReference)
    {
	HttpHeaders headers = new HttpHeaders();
	headers.add(USERNAME, username);
	headers.add(PASSWORD, password);
	HttpEntity<T> requestEntity = new HttpEntity<T>(null, headers);
	ResponseEntity<R> entity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, typeReference);
	return entity.getBody();
    }

    public R getObject(String url, String username, String password, Class<R> clazz, Object... params)
    {
	HttpHeaders headers = new HttpHeaders();
	headers.add(USERNAME, username);
	headers.add(PASSWORD, password);
	ResponseEntity<R> entity = getObject(url, headers, HttpMethod.GET, clazz, params);

	return entity.getBody();
    }

    /*
     * START This is a post that acts as a GET - to be reviewed, POSTs that are actually gets with request body content are not recommended
     */
    private ResponseEntity<R> postObjectWithReturn(String url, HttpHeaders headers, HttpMethod httpMethod, T object, Class<R> clazz)
    {
	HttpEntity<T> requestEntity = new HttpEntity<T>(object, headers);
	ResponseEntity<R> entityReturned = restTemplate.exchange(url, httpMethod, requestEntity, clazz);
	return entityReturned;
    }

    public R postObjectWithReturn(String url, String username, String password, T object, Class<R> clazz)
    {
	HttpHeaders headers = prepareWriteHeaders();
	headers.add(USERNAME, username);
	headers.add(PASSWORD, password);
	ResponseEntity<R> entity = postObjectWithReturn(url, headers, HttpMethod.POST, object, clazz);
	return entity.getBody();
    }

    /*
     * END
     */
    private ResponseEntity<R> postObject(String url, HttpHeaders headers, HttpMethod httpMethod, T object, Class<R> clazz)
    {
	HttpEntity<T> requestEntity = new HttpEntity<T>(object, headers);
	ResponseEntity<R> entityReturned = restTemplate.exchange(url, httpMethod, requestEntity, clazz);
	return entityReturned;
    }

    public R postObject(String url, String username, String password, T object, Class<R> clazz)
    {
	HttpHeaders headers = prepareWriteHeaders();
	headers.add(USERNAME, username);
	headers.add(PASSWORD, password);
	ResponseEntity<R> entity = postObject(url, headers, HttpMethod.POST, object, clazz);
	return entity.getBody();
    }

    /*
     * END
     */
    private ResponseEntity<R> putObject(String url, HttpHeaders headers, HttpMethod httpMethod, T object, Class<R> clazz)
    {
	HttpEntity<T> requestEntity = new HttpEntity<T>(object, headers);
	ResponseEntity<R> entityReturned = restTemplate.exchange(url, httpMethod, requestEntity, clazz);
	return entityReturned;
    }

    public R putObject(String url, String username, String password, T object, Class<R> clazz)
    {
	HttpHeaders headers = prepareWriteHeaders();
	headers.add(USERNAME, username);
	headers.add(PASSWORD, password);
	ResponseEntity<R> entity = putObject(url, headers, HttpMethod.PUT, object, clazz);
	return entity.getBody();
    }

    private HttpHeaders prepareWriteHeaders()
    {
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);

	// set acceptable media Types for return value
	List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
	acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
	acceptableMediaTypes.add(MediaType.APPLICATION_XML);
	headers.setAccept(acceptableMediaTypes);

	return headers;
    }

    public Integer getRestClientReadTimeoutMS()
    {
	return restClientReadTimeoutMS;
    }

    public void setRestClientReadTimeoutMS(Integer restClientReadTimeoutMS)
    {
	this.restClientReadTimeoutMS = restClientReadTimeoutMS;
    }
    

    public void setRestSOTimeoutMS(Integer restSOTimeoutMS)
    {
	this.restSOTimeoutMS = restSOTimeoutMS;
    }

    public RestTemplate getRestTemplate()
    {
	return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate)
    {
	this.restTemplate = restTemplate;
    }

    public Integer getRestSOTimeoutMS()
    {
	return restSOTimeoutMS;
    }

}
