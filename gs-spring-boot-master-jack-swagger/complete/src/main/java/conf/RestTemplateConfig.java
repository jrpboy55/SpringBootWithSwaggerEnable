package conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import hello.rao.RestWrapper;


// TODO review 'timeouts'... there should be 2 settings... CorpBatch...
@SuppressWarnings("deprecation")
@Configuration
public class RestTemplateConfig
{
  /*  @Bean
    public PoolingClientConnectionManager poolingClientConnectionManager()
    {
	PoolingClientConnectionManager poolingClientConnectionManager = new PoolingClientConnectionManager();
	poolingClientConnectionManager.setMaxTotal(100);
	poolingClientConnectionManager.setDefaultMaxPerRoute(10);
	return poolingClientConnectionManager;
    }
    
    @Bean
    public DefaultHttpClient httpClient()
    {
	DefaultHttpClient httpClient = new DefaultHttpClient(poolingClientConnectionManager());
	return httpClient;
    }
    
    @Bean
    public HttpComponentsClientHttpRequestFactory requestFactory()
    {
	HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient());
	return requestFactory;
    }
    
    @Bean
    ClientHttpRestErrorHandler clientHttpResponseErrorHandler()
    {
	ClientHttpRestErrorHandler clientHttpResponseErrorHandler = new ClientHttpRestErrorHandler();
	return clientHttpResponseErrorHandler;
    }*/
    
    @Bean
    public RestTemplate restTemplate()
    {
	RestTemplate restTemplate = new RestTemplate();
	//restTemplate.setErrorHandler(new ClientHttpRestErrorHandler());
	//restTemplate.setRequestFactory(requestFactory());
	return restTemplate;
    }
    
    @SuppressWarnings("rawtypes")
    @Bean
    public RestWrapper restWrapper()
    {
	RestWrapper restWrapper = new RestWrapper();
	restWrapper.setRestClientReadTimeoutMS(1000);
	return restWrapper;
    }
    
}
