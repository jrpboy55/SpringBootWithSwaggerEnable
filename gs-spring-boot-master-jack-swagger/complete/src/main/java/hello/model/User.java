package hello.model;

public class User
{

    private String userName;

    private String userEmailAddr;

    public User(String userName, String userEmailAddr)
    {
	super();
	this.userName = userName;
	this.userEmailAddr = userEmailAddr;
    }

    public String getUserName()
    {
	return userName;
    }

    public void setUserName(String userName)
    {
	this.userName = userName;
    }

    public String getUserEmailAddr()
    {
	return userEmailAddr;
    }

    public void setUserEmailAddr(String userEmailAddr)
    {
	this.userEmailAddr = userEmailAddr;
    }

    @Override
    public String toString()
    {
	return "User [userName=" + userName + ", userEmailAddr=" + userEmailAddr + "]";
    }

}
