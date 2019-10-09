package extention;


import static org.testng.Assert.fail;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import utilies.commonOps;

public class actions extends commonOps {
	public static void dropDown(WebElement dropDownSelect,String value)
			throws IOException, ParseException, ParserConfigurationException, SAXException {
		try {
			Select dropDown = new Select(wikiMain.dropDownSelect);  
			dropDown.selectByValue(value);
			Thread.sleep(1000);
			test.log(LogStatus.PASS, ("Dropdown options was selected successfully, This is the value: " + value));
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"Failed to selected dropdown, deatils: " + e + "See screenshot" + test.addScreenCapture(takeSS()));

			fail("Failed to selected dropdown ");

		}

	}

}
