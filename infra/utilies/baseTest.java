package utilies;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class baseTest {
	public static WebDriver driver;
//	public static Screen screen;
	static DesiredCapabilities dc = new DesiredCapabilities();

	public static ExtentReports extent;
	public static ExtentTest test;
	public static pageObject_imdb_moblie.mainPage imdbMobileMain;
	public static pageObject_imdb_moblie.resultPage imdbMobileResult;
	
	public static  pageObject.mainPage  wikiMain;
	public static  pageObject.ResultPage  wikiResults;
	public static pageObjElctorn.mainPage electronMain;



	
	public static RequestSpecification httpRequest;
	public static JSONObject requestParams = new JSONObject();
	public static Response resp;
	
	public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
	public static String myPlatform;

}
