package tests;



	//package <set your test package>;
	import io.appium.java_client.remote.AndroidMobileCapabilityType;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidElement;
	import io.appium.java_client.remote.MobileCapabilityType;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.By;
	import org.testng.annotations.*;
	import java.net.URL;
	import java.net.MalformedURLException;
	import java.util.logging.Level;
	public class appiumTest {

	    protected AndroidDriver<AndroidElement> driver = null;

	    DesiredCapabilities dc = new DesiredCapabilities();
	    
	    @BeforeMethod
	    public void setUp() throws MalformedURLException {

	        dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
	        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.imdb.mobile");
	        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeActivity");
	        driver = new AndroidDriver<>(new URL("http://localhost:4724/wd/hub"), dc);
	        driver.setLogLevel(Level.INFO);
	    }

	    @Test
	    public void testUntitled() {
	        driver.findElement(By.xpath("//*[@text='MOVIES']")).click();
	        driver.findElement(By.xpath("//*[@contentDescription='TV']")).click();
	        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='self_implemented_search']")));
	        driver.findElement(By.xpath("//*[@id='self_implemented_search']")).click();
	        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='self_implemented_search']")));
	        driver.findElement(By.xpath("//*[@id='self_implemented_search']")).sendKeys("start");
	        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='icon' and ./parent::*[./parent::*[@id='key_pos_ime_action']] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.widget.ImageView']]")));
	        driver.findElement(By.xpath("//*[@id='icon' and ./parent::*[./parent::*[@id='key_pos_ime_action']] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.widget.ImageView']]")).click();
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}

