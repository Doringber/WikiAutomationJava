package worksFlow;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extention.click;

public class electron_screen extends utilies.commonOps {
	
	public static void getInfo() throws IOException, ParseException, ParserConfigurationException, SAXException {
		click.go(electronMain.btn_create_window);
		click.go(electronMain.btn_info);
		click.go(electronMain.btn_demo_toggle);
		click.go(electronMain.btn_demo_toggle);
		click.go(electronMain.btn_screen_info);
		
		

		
	}

}
