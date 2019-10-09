package worksFlow;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extention.actions;
import extention.click;
import extention.updateText;
import utilies.commonOps;

public class wikiSearch extends commonOps {
	
	public static void searchItem(String searchItem) throws IOException, ParseException, ParserConfigurationException, SAXException 
	{
		updateText.text(wikiMain.searchBox, searchItem);
		click.go(wikiMain.searchButton);

	}
	
	public static void pressingItem(String searchItemTwo) throws IOException, ParseException, ParserConfigurationException, SAXException 
	{
		updateText.text(wikiMain.searchBox, searchItemTwo);
		click.go(wikiMain.searchButton);

	}
	
	public static void dropDownWikiPress(String searchItemthree,String valueItem) throws IOException, ParseException, ParserConfigurationException, SAXException, InterruptedException 
	{
		actions.dropDown(wikiMain.dropDownSelect,valueItem);
		updateText.text(wikiMain.searchBox, searchItemthree);

	}
}
