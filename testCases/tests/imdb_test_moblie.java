package tests;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import extention.verfiyText;
import utilies.commonOps;
import worksFlow.mobile_search;

public class imdb_test_moblie extends commonOps {

		@Test
		public void test01_selectedStarWars()
				throws IOException, ParseException, ParserConfigurationException, SAXException, InterruptedException {
			mobile_search.searchItem("star wars");
			Thread.sleep(1000);
			verfiyText.textInElement(imdbMobileResult.firstResult, "Star Wars: The Rise of Skywalker");


		}

}
