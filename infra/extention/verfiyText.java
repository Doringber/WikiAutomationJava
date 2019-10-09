package extention;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import utilies.commonOps;

public class verfiyText extends commonOps {
	public static void textInElement(WebElement elem, String excptedValue)
			throws IOException, ParseException, ParserConfigurationException, SAXException {
		try {
			assertEquals(elem.getText(), excptedValue);
			test.log(LogStatus.PASS, "Verify Text successfully");

		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"Failed on the Text details: " + e + "See screenshot" + test.addScreenCapture(takeSS()));
			fail("Failed on the Text");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL,
					"Failed on the Text details: " + e + "See screenshot" + test.addScreenCapture(takeSS()));
			fail("Failed to Verify Text");

		}
	}
	
	public static void contains(String response, String text) {
		try {
			assertTrue(response.contains(text));
			test.log(LogStatus.PASS, "Contains Passed successfully");

		} catch (AssertionError e) {
			test.log(LogStatus.FAIL,text + "Failed To be contains , details: " + e );
			fail(text + "Failed To be contains , details: " + e);		}
	}
	
	

}
