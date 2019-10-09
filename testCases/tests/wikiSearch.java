package tests;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import extention.verfiyText;
import utilies.commonOps;
import worksFlow.db_query;

public class wikiSearch extends commonOps {
	@Test(groups = {"Sanity"})
	public void test01_searchWiki()
			throws IOException, ParseException, ParserConfigurationException, SAXException, InterruptedException
		{
			worksFlow.wikiSearch.searchItem("pop");
			verfiyText.textInElement(wikiResults.pageName, "Pop");

		}
	

	@Test(groups = {"DataBase"})
	public void test02_dbQrueyWiki() throws IOException, ParseException, ParserConfigurationException, SAXException 
	{
		worksFlow.wikiSearch.pressingItem("pop music");
		verfiyText.textInElement(wikiResults.pageName, db_query.getMessage("Excpted_Result", "'Pop music'"));

	}
	
	@Test(groups = {"Sanity"})
	public void test02_dorpWiki()
			throws IOException, ParseException, ParserConfigurationException, SAXException, InterruptedException
		{
			worksFlow.wikiSearch.dropDownWikiPress("the big wind", "az");

		}

}
