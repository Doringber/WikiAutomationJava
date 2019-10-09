package extention;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import utilies.commonOps;

public class updateText extends commonOps {
	public static void text(WebElement elem, String value)
			throws IOException, ParseException, ParserConfigurationException, SAXException {
		try {
			elem.sendKeys(value);
			test.log(LogStatus.PASS, "Text filed Updated successfully, This is the value: " + value);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to Updated Text Element, details: " + e + "See screenshot"
					+ test.addScreenCapture(takeSS()));
			fail("Failed to Updated Text Element ");

		}
	}


}
