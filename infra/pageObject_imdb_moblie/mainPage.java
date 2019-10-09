package pageObject_imdb_moblie;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPage {
	@FindBy(how = How.ID, using = "self_implemented_search")
	public WebElement search;
	
	@FindBy(how = How.ID, using = "search_query")
	public WebElement searchQuery;
	
	@FindBy(how = How.XPATH, using = "//*[@text='Star Wars: The Rise of Skywalker']")
	public WebElement suggestion;
	
	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.imdb.mobile:id/title']")
	public WebElement deviceOffLine;

}
