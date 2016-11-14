package hello.rao;

import org.springframework.stereotype.Service;

/**
 * Contains configuration information telling the application and client where
 * to access the services. Two addresses are exposed because the address will be
 * different when deployed into the production environment.
 * <p>
 * 
 * For development purposes, both addresses may be listed as:
 * <code>rest.server.internal=http://localhost:8080/iprms-service</code>
 * <p>
 * <code>rest.server.external=http://localhost:8080/iprms-service</code>
 * </p>
 * 
 * For production purposes, the addresses will be different:
 * <code>rest.server.internal=http://10.33.117.103:8080/iprms-service</code>
 * <p>
 * <code>rest.server.external=/iprms-service-dev</code>
 * </p>
 * 
 * @lastChangedDate $LastChangedDate: 2016-04-28 12:25:44 -0400 (Thu, 28 Apr 2016) $
 * @version $Revision: 7077 $
 * @id $Id: GenericRao.java 7077 2016-04-28 16:25:44Z brunetg $
 * @HeadURL $HeadURL: http://njes1u39.ci.gc.ca/svn/iprms-webpos/trunk/src/main/java/ca/gc/cic/gol/iprms/pos/rao/GenericRao.java $
 */

@Service
public class GenericRao
{

    /**
     * Server Internal represents the URL address where the web services are
     * available for access by the application WAR file. This is an internal
     * address that is not made available to the browser client.
     */

    //private @Value("#{iprmsProperties['rest.server.internal']}")
    String serverInternal;

    /**
     * Server External represents the URL address where the web service is
     * exposed via an Apache Proxy. This allows for direct communication between
     * the client application and the service.
     * <p>
     * 
     * Note: For ajax to work correctly, the external address must make
     * reference to the service as also being on the same apache host as the
     * application.
     * <p>
     */
  //  private @Value("#{iprmsProperties['rest.server.external']}")
    String serverExternal;

    public String getServerInternal()
    {
	return serverInternal;
    }

    public String getServerExternal()
    {
	return serverExternal;
    }



//    /**
//     * Returns the service session id required to make a request to the Service
//     * layer. Will return a null if the current session is not authenticated or
//     * if the <code>principal</code> object is not of type
//     * <Code>CustomUserDetailINT</Code>
//     * 
//     * @param request
//     *            current active HTTP session
//     * 
//     * @return service session id
//     */
//    public String getServiceSessionId()
//    {
//	CustomUserDetailINT userDetail = getCurrentUser();
//
//	if ( userDetail != null && StringUtils.isNotEmpty(userDetail.getServiceSessionId()) ) { return userDetail.getServiceSessionId(); }
//
//	return null;
//    }

    /**
     * Returns the current logon id. Will return a null if the current session
     * is not authenticated or if the <code>principal</code> object is not of
     * type <Code>CustomUserDetailINT</Code>
     * 
     * @return String logon id of the user currently logged in.
     */
    public String getCurrentUserClearTextPassword()
   {
//	CustomUserDetailINT userDetail = getCurrentUser();
//
//	return userDetail.getPassword();
	
	return "fakePassword";
    }

//    /**
//     * Returns the current location id. Will return a null if the current
//     * session is not authenticated or if the <code>principal</code> object is
//     * not of type <Code>CustomUserDetailINT</Code>
//     * 
//     * @return Integer location id of the user currently logged in.
//     */
//    public Integer getCurrentUserLocation()
//    {
//	CustomUserDetailINT userDetail = getCurrentUser();
//
//	if ( userDetail != null && StringUtils.isNotEmpty(userDetail.getServiceSessionId()) ) { return userDetail.getLocationId(); }
//
//	return null;
//    }

    /**
     * Returns the current logon id. Will return a null if the current session
     * is not authenticated or if the <code>principal</code> object is not of
     * type <Code>CustomUserDetailINT</Code>
     * 
     * @return String logon id of the user currently logged in.
     */
    public String getCurrentUserLogonId()
    {
	//CustomUserDetailINT userDetail = getCurrentUser();

	return 	"fakeUser";
    }

}
