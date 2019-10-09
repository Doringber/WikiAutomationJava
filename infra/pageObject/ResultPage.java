package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResultPage {
	@FindBy(how = How.ID, using = "firstHeading")
	public WebElement pageName;
	
	@FindBy(how = How.XPATH, using = "//a[@title=\"Pop music\"]")
	public WebElement resultName;

}
