package Utility;

public class Util {
	public static final String CHROME_PATH = System.getProperty("user.dir")+"\\chromedriver.exe";
	//public static final String CHROME_PATH = "D:\\chromedriver.exe";
	
	public static final String BASE_URL_guru99 = "http://www.demo.guru99.com/V4/";
	public static final String BASE_URL_guru99_tooltip = "http://demo.guru99.com/test/tooltip.html";
	public static final String BASE_URL_makemytrip = "https://www.makemytrip.com/";
	public static final String BASE_URL_syngenta = "https://www.syngenta.ch/";
	
	
	public static String customerID;
	public static final int WAIT_TIME = 30; 
	

	// Valid account for login
	public static final String USER_NAME = "mngr150931";
	public static final String PASSWD = "UdEnYma";
	//Manager home page title
	public static final String MGE_HP_title="Guru99 Bank Manager HomePage";
	
	//Invalid username or password after clicked on login button alert message
	public static final String Login_alert_msg="User or Password is not valid";

	public static void setCustomerId(String CustId){
		customerID=CustId;
	}
	

}
