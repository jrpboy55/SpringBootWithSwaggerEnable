package hello.model;

/**
 * @lastChangedDate $LastChangedDate: 2016-04-27 15:53:22 -0400 (Wed, 27 Apr 2016) $
 * @version $Revision: 6766 $
 * @id $Id: DefaultHtmlBuilder.java 6766 2016-04-27 19:53:22Z brunetg $
 * @HeadURL $HeadURL: http://njes1u39.ci.gc.ca/svn/iprms-service/trunk/src/main/java/ca/gc/cic/gol/iprms/builder/DefaultHtmlBuilder.java $
 */

public class DateRange
{

    private String fromDate;
    private String toDate;

    public DateRange()
    {
	
    }
    public DateRange(String fromDate, String toDate)
    {
	super();
	this.fromDate = fromDate;
	this.toDate = toDate;
    }

    public String getFromDate()
    {
        return fromDate;
    }

    public void setFromDate(String fromDate)
    {
        this.fromDate = fromDate;
    }

    public String getToDate()
    {
        return toDate;
    }

    public void setToDate(String toDate)
    {
        this.toDate = toDate;
    }

    @Override
    public String toString()
    {
	return "DateRange [fromDate=" + fromDate + ", toDate=" + toDate + "]";
    }    
    
}
