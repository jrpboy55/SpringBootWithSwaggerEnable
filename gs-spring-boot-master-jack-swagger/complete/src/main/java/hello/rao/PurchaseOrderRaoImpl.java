package hello.rao;

import org.springframework.stereotype.Service;


/**
 * @lastChangedDate $LastChangedDate: 2016-04-28 12:25:44 -0400 (Thu, 28 Apr 2016) $
 * @version $Revision: 7077 $
 * @id $Id: PurchaseOrderRaoImpl.java 7077 2016-04-28 16:25:44Z brunetg $
 * @HeadURL $HeadURL: http://njes1u39.ci.gc.ca/svn/iprms-webpos/trunk/src/main/java/ca/gc/cic/gol/iprms/pos/web/purchase/dao/PurchaseOrderRaoImpl.java $
 */

@Service("purchaseOrderRao")
public class PurchaseOrderRaoImpl extends GenericRao //implements PurchaseOrderDao
{
    /*
	@Autowired
	RestWrapper<PurchaseOrderWS, PurchaseOrderWS> purchaseOrderRestWrapper;

	@Autowired
	RestWrapper<OnlinePurchaseOrderWS, OnlinePurchaseOrderWS> onlinePurchaseOrderRestWrapper;

	@Autowired
	RestWrapper<WebPosPurchaseOrderWS, String> webPosPurchaseOrderRestWrapper;

	@Autowired
	RestWrapper<String ,WebPosPurchaseOrderViewWS> getWebPosPurchaseOrderRestWrapper;

	@Autowired
	RestWrapper<NameValueMapListWS, String> updateWebPosPurchaseOrderRestWrapper;

	@Autowired
	RestWrapper<String, PurchaseOrderViewHeaderListWS> receiptSearchRestWrapper;

	@Autowired
	RestWrapper<ReceiptSearchParametersWS, ReceiptSearchViewListWS> allReceiptSearchRestWrapper;

	@Autowired
	RestWrapper<NameValueMapListWS, String> reverseReceiptRestWrapper;

	//private @Value("#{urlProperties['rest.url.purchaseOrder']}")
	String purchaseOrderRestUrl;

	//private @Value("#{urlProperties['rest.url.onlinePurchaseOrder']}")
	String onlinePurchaseOrderRestUrl;

	//private @Value("#{urlProperties['rest.url.webposPurchaseOrder']}")
	String webPosPurchaseOrderRestUrl;

	//private @Value("#{urlProperties['rest.url.initiateWebposPurchaseOrder']}")
	@Value("${createReceiptUrl}")
        private String intiateWebPosPurchaseOrderRestUrl;
    
        @Value("${cicCashierUsername}")
        private String userName = MyProperties.getInstance().getProperty("cicCashierUsername");
    
        @Value("${cicCashierPassword}")
        private String userPassword = MyProperties.getInstance().getProperty("cicCashierPassword");

	//private @Value("#{urlProperties['rest.url.updateWebposPurchaseOrderReceiptStatus']}")
	String updateWebposPurchaseOrderReceiptStatusRestUrl;

	//private @Value("#{urlProperties['rest.url.listReceiptsByReceiptNumber']}")
	String receiptSearchByReceiptNumberRestUrl;

	//private @Value("#{urlProperties['rest.url.listReceiptsByParam']}")
	String receiptSearchByParamRestUrl;

	//private @Value("#{urlProperties['rest.url.reverseReceipt']}")
	String reverseReceiptUrl;


	public PurchaseOrderWS getPurchaseOrder(String iprmsNumber)
	{
		PurchaseOrderWS receiptWS = null;

		if (!StringUtils.isEmpty(iprmsNumber))
		{

			String url = getServerInternal() + purchaseOrderRestUrl + "/" + iprmsNumber;
			receiptWS = purchaseOrderRestWrapper.getObject( url, 
					getCurrentUserLogonId(), 
					getCurrentUserClearTextPassword(), 
					PurchaseOrderWS.class);
		}

		return receiptWS;
	}

	public OnlinePurchaseOrderWS getOnlinePurchaseOrder(String iprmsNumber)
	{
		OnlinePurchaseOrderWS onlineReceiptWS = null;

		// TODO add validation
		if (!StringUtils.isEmpty(iprmsNumber))
		{
			String url = getServerInternal() + onlinePurchaseOrderRestUrl + "/" + iprmsNumber;
			onlineReceiptWS = onlinePurchaseOrderRestWrapper.getObject( url, 
					getCurrentUserLogonId(), 
					getCurrentUserClearTextPassword(), 
					OnlinePurchaseOrderWS.class);
		}

		return onlineReceiptWS;
	}

	public WebPosPurchaseOrderViewWS getWebPosPurchaseOrder(Integer receiptID)
	{
		WebPosPurchaseOrderViewWS webPosPurchaseOrderWS = null;

		// TODO add validation
		if (receiptID != null)
		{
			String url = getServerInternal() + webPosPurchaseOrderRestUrl + "/" + receiptID;
			webPosPurchaseOrderWS = getWebPosPurchaseOrderRestWrapper.getObject( url,
					getCurrentUserLogonId(), 
					getCurrentUserClearTextPassword(), 
					WebPosPurchaseOrderViewWS.class);
		}

		return webPosPurchaseOrderWS;
	}

	public String initiatePurchaseOrder(WebPosPurchaseOrderWS webPosPO )
	{
		//String iprmsReceiptNum  = purchaseOrderWrapper.postObjectWithReturn(iprmsInitiate, "admin.iprms@cic.gc.ca", "admin", initiatePurchaseOrderWS, String.class);

		// TODO String url = getServerInternal() + intiateWebPosPurchaseOrderRestUrl;

		String iprmsReceiptId = webPosPurchaseOrderRestWrapper.postObjectWithReturn( intiateWebPosPurchaseOrderRestUrl, 
				getCurrentUserLogonId(), 
				getCurrentUserClearTextPassword(), 
				webPosPO, 
				String.class); 

		return iprmsReceiptId;
	}


	public String updateWebPosPurchaseOrderReceiptStatus(NameValueMapListWS nameValueMapListWS)
	{
		String url = getServerInternal() + updateWebposPurchaseOrderReceiptStatusRestUrl;

		return updateWebPosPurchaseOrderRestWrapper.postObjectWithReturn( url, 
				getCurrentUserLogonId(), 
				getCurrentUserClearTextPassword(), 
				nameValueMapListWS, 
				String.class);

	}

	public PurchaseOrderViewHeaderListWS findAllReceiptsByReceiptNumber(String receiptNumber)
	{
		String url = getServerInternal() + receiptSearchByReceiptNumberRestUrl + receiptNumber;

		PurchaseOrderViewHeaderListWS purchaseOrderListWS = receiptSearchRestWrapper.getObject( url, 
				getCurrentUserLogonId(), 
				getCurrentUserClearTextPassword(), 
				PurchaseOrderViewHeaderListWS.class);

		return purchaseOrderListWS;
	}

	public ReceiptSearchViewListWS getAllReceiptByParams(ReceiptSearchParametersWS receiptSearchParametersWS)
	{
		String url = getServerInternal() + receiptSearchByParamRestUrl;
		ReceiptSearchViewListWS receiptListWS =  allReceiptSearchRestWrapper.postObjectWithReturn( url , 
				getCurrentUserLogonId(), 
				getCurrentUserClearTextPassword(), 
				receiptSearchParametersWS, 
				ReceiptSearchViewListWS.class);
		return receiptListWS;
	}

	public String reverseReceipt(NameValueMapListWS nameValueMapListWS)
	{
		String url = getServerInternal() + reverseReceiptUrl;
		return reverseReceiptRestWrapper.postObjectWithReturn( url, 
				getCurrentUserLogonId(), 
				getCurrentUserClearTextPassword(), 
				nameValueMapListWS, 
				String.class);
	}*/
}
