package utilies;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.ParseException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import com.relevantcodes.extentreports.ExtentReports;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.restassured.RestAssured;

public class commonOps extends baseTest {
	// XML - DataConfing
	public static String getData(String nodeName) throws ParserConfigurationException, SAXException, IOException {
		File fXmlFile = new File("./config/Data.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(nodeName).item(0).getTextContent();

	}

	// WebDriver - initDriver
	public static void initBrowesr(String browesrType) throws ParserConfigurationException, SAXException, IOException {

		switch (browesrType.toLowerCase()) {
		case "chrome":
			driver = initChromeDriver();
			break;
		case "firefox":
			driver = initFireFox();
			break;
		case "ie":
			driver = initIEdriver();
			break;
		case "safari":
			driver = initSafariDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.get(getData("URL"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// screen = new Screen();

	}

	private static WebDriver initSafariDriver() {
		driver = new SafariDriver();
		return driver;

	}

	private static WebDriver initIEdriver() throws ParserConfigurationException, SAXException, IOException {
		System.setProperty("webdriver.ie.driver", getData("IEDriverServerpath"));
		driver = new InternetExplorerDriver();
		return driver;
	}

	private static WebDriver initFireFox() throws ParserConfigurationException, SAXException, IOException {
		System.setProperty("webdriver.gecko.driver", getData("FirefoxdriverPath"));
		driver = new FirefoxDriver();
		return driver;

	}

	private static WebDriver initChromeDriver() throws ParserConfigurationException, SAXException, IOException {
		System.setProperty("webdriver.chrome.driver", getData("ChromedriverPath"));
		driver = new ChromeDriver();
		return driver;
	}

	// initMobile driver
	public static void initMobile() throws ParserConfigurationException, SAXException, IOException {
		dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, getData("device_name"));
		dc.setCapability("noReset",true);
//		dc.setCapability("fullReset",false);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
		driver = new AndroidDriver<>(new URL(getData("Appium_server")), dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	

	// initAPI
	public static void initAPI() throws ParserConfigurationException, SAXException, IOException {
		RestAssured.baseURI = getData("API_URL");
		httpRequest = RestAssured.given();
	}

	// initElectron
	public static void initElectronDriver(String App) throws ParserConfigurationException, SAXException, IOException {
		System.setProperty("webdriver.chrome.driver", getData("ChromedriverElectronPath"));
		ChromeOptions opt = new ChromeOptions();
		opt.setBinary(App);
		dc.setCapability("chromeOptions", opt);
		dc.setBrowserName("chrome");
		driver = new ChromeDriver(dc);

	}

	// ExtentReports
	public static void instanceReport() throws ParserConfigurationException, SAXException, IOException {
		extent = new ExtentReports(
				getData("ReportFilePath") + "Eexcution_" + timeStamp + "/" + getData("ReportFileName") + ".html");

	}

	public static void initReportTest(String TestName, String TestDescription) {
		test = extent.startTest(TestName, TestDescription);
	}

	public static void finalizeReportTest() {
		extent.endTest(test);
	}

	public static void finalizeExtentTest() {

		extent.flush();
		extent.close();
	}

	public static String takeSS() throws IOException, ParseException, ParserConfigurationException, SAXException {

		String path = getData("ReportScreenPath") + "Execution_" + timeStamp + "/" + "screenshot_" + getRandomNubmer()
				+ ".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(path));
		return path;

	}

	public static int getRandomNubmer() {
		Random rand = new Random();
		int num = rand.nextInt(9999999) + 1;
		return num;
	}

	// TestNG

	@BeforeSuite
	public void starSuite() throws SAXException, IOException, ParserConfigurationException {
		instanceReport();

	}

	@AfterSuite
	public void afterSutie() {
		finalizeExtentTest();

	}

	@BeforeTest(groups = { "Sanity" })
	@Parameters({ "platform" })
	public void startSession(String platform) throws ParserConfigurationException, SAXException, IOException {
		myPlatform = platform;
		if (myPlatform.toLowerCase().equals("web"))
			initBrowesr(getData("BrowserType"));

		else if (myPlatform.toLowerCase().equals("mobile"))
			initMobile();
		else if (myPlatform.toLowerCase().equals("api"))
			initAPI();
		else if (myPlatform.toLowerCase().equals("electron"))
			initElectronDriver(getData("ElectronApp"));

		initPage.init();

	}

	 @AfterTest(groups = {"Sanity"})
	 public void closeSession() throws ParserConfigurationException, SAXException,
	 IOException
	 {
	 if(!myPlatform.toLowerCase().equals("API"))
		 driver.quit();
		
	 }

	@BeforeMethod(groups = { "Sanity" })
	public static void doBeforeTest(Method method) {
		initReportTest(method.getName().split("_")[0], method.getName().split("_")[1]);
	}

	@AfterMethod(groups = { "Sanity" })
	public static void doAfterTest() throws ParserConfigurationException, SAXException, IOException {
		 if(myPlatform.equalsIgnoreCase("Web"))
			 driver.get(getData("URL"));
		finalizeReportTest();

	}
}


