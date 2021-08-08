package net.session.login;

public class creditBean {
	private String userID;
	private Double camt;
	
	public String getUser()
	{
		return userID;
	}
	public void setUser(String userID)
	{
		this.userID=userID;
	}
	public Double getCamt()
	{
		return camt;
	}
	public void setCamt(Double camt)
	{
		this.camt=camt;
	}
	public creditBean(String userID, Double camt) {
		super();
		this.userID=userID;
		this.camt=camt;
	}
	public creditBean() {
		super();
	}
	
}