package utilies;

import org.openqa.selenium.support.PageFactory;

public class initPage extends commonOps {
	
	public static void init() {
		wikiMain = PageFactory.initElements(driver, pageObject.mainPage.class);
		wikiResults = PageFactory.initElements(driver, pageObject.ResultPage.class);
		electronMain = PageFactory.initElements(driver, pageObjElctorn.mainPage.class);
		
		imdbMobileMain = PageFactory.initElements(driver, pageObject_imdb_moblie.mainPage.class);
		imdbMobileResult = PageFactory.initElements(driver, pageObject_imdb_moblie.resultPage.class);

	}

}
