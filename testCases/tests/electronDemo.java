package tests;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import extention.verfiyText;
import utilies.commonOps;
import worksFlow.electron_screen;

public class electronDemo extends commonOps {
	
	@Test
	public void test04_GetInfoElectron() throws IOException, ParseException, ParserConfigurationException, SAXException {
		electron_screen.getInfo();
		verfiyText.textInElement(electronMain.field_screen_info, "Your screen is: 1280px x 800px");
		
	}

}
