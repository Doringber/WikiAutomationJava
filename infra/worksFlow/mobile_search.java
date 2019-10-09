package worksFlow;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extention.click;
import extention.updateText;
import utilies.commonOps;

public class mobile_search extends commonOps {
	public static void searchItem(String searchItem) throws IOException, ParseException, ParserConfigurationException, SAXException {

	click.go(imdbMobileMain.search);
	updateText.text(imdbMobileMain.searchQuery, searchItem);
	click.go(imdbMobileMain.suggestion);
}
}
	
