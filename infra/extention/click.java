package extention;



import static org.testng.Assert.fail;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import utilies.commonOps;

public class click extends commonOps {
	public static void go(WebElement elem)
			throws IOException, ParseException, ParserConfigurationException, SAXException {
		try {
			elem.click();
			test.log(LogStatus.PASS, "Element clicked successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"Failed to click on Element, deatils: " + e + "See screenshot" + test.addScreenCapture(takeSS()));

			fail("Failed to click on Element ");

		}

	}
	
	


}
