package hello.rao;

/**
 * @lastChangedDate $LastChangedDate: 2016-04-28 12:25:44 -0400 (Thu, 28 Apr 2016) $
 * @version $Revision: 7077 $
 * @id $Id: PurchaseOrderDao.java 7077 2016-04-28 16:25:44Z brunetg $
 * @HeadURL $HeadURL: http://njes1u39.ci.gc.ca/svn/iprms-webpos/trunk/src/main/java/ca/gc/cic/gol/iprms/pos/web/purchase/dao/PurchaseOrderDao.java $
 */

public interface PurchaseOrderDao
{
//    /**
//     * Get a PurchaseOrder using the <i>iprmsNumber</i> parameter as a search key.  
//     * @param iprmsNumber
//     * @return
//     */
//    public PurchaseOrderWS getPurchaseOrder( String iprmsNumber );
//    
//    /**
//     * Get a OnlinePurchaseOrderEntity using the <i>iprmsNumber</i> parameter as a search key.
//     * <p>
//     * NB: This method will always add the 'sequenceNumber = 1' condition to its query 
//     * <p>
//     * @param iprmsNumber
//     * @return
//     */
//    public OnlinePurchaseOrderWS getOnlinePurchaseOrder( String iprmsNumber );    
//    
//    /**
//     * Get a WebPosPurchaseOrderEntity using the <code>receiptID</code> parameter. 
//     * <p>
//     * @param receiptID
//     * @return
//     */
//    public WebPosPurchaseOrderViewWS getWebPosPurchaseOrder( Integer receiptID  );
//    
//    /**
//     * Create a webpos purchase order record and set initial values using data contained in the 
//     * <code>WebPosPurchaseOrderWS</code>input parameter 
//     * <p>
//     * @param webPosPO
//     * @return
//     */
//    public String initiatePurchaseOrder( WebPosPurchaseOrderWS webPosPO );
//    
//    /**
//     * Find all PurchaseOrder metadata records whose data elements match the search parameter values passed in
//     * via the <code>ReceiptSearchParametersWS</code> object.
//     * 
//     * @param receiptSearchParametersWS
//     * @return
//     */
//    public ReceiptSearchViewListWS getAllReceiptByParams( ReceiptSearchParametersWS receiptSearchParametersWS );
//    
//    /**
//     * Uses a list of <code>NameValueMapsWS</code> objects from the <code>NameValueMapListWS</code> 
//     * input parameter to reverse a receipt.
//     * <p>
//     * The receipts have to be in an unreconciled status in order to be reversed.
// 
//     * @param nameValueMapListWS
//     * @return
//     */
//    public String reverseReceipt( NameValueMapListWS nameValueMapListWS );
//    
//    /**
//     * Find all PurchaseOrder records whose receipt number matches the 
//     * <i>receiptNumber</i> parameters value.
//     * <p>
//     * This method does <b>not</b> retrieve dependent data
//     * @param receiptNumber
//     * @return
//     */
//    public PurchaseOrderViewHeaderListWS findAllReceiptsByReceiptNumber(String receiptNumber);
//    
//    /**
//     * 
//     * Update the status of one or more Purchase Orders to the given receipt status code
//     * 
//     * @param nameValueMapListWS
//     * @return
//     */
//    public String updateWebPosPurchaseOrderReceiptStatus(NameValueMapListWS nameValueMapListWS);
}
