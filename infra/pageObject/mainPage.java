package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPage {
	@FindBy(how = How.ID, using = "searchInput")
	public WebElement searchBox;
	
	@FindBy(how = How.XPATH, using = "//button[@class='pure-button pure-button-primary-progressive']")
	public WebElement searchButton;
	
	@FindBy(how = How.ID, using = "searchLanguage")
	public WebElement dropDownSelect;

}
